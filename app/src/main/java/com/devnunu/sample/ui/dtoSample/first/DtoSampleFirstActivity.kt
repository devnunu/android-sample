package com.devnunu.sample.ui.dtoSample.first

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.airbnb.mvrx.viewModel
import com.devnunu.sample.ui.dtoSample.second.DtoSampleSecondActivity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DtoSampleFirstActivity : ComponentActivity() {

    private val viewModel: DtoSampleFirstViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DtoSampleFirstScreen(viewModel = viewModel)
        }
        setEventObserver()
    }

    private fun setEventObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.eventFlow.onEach { event ->
                    when(event) {
                        is DtoSampleFirstViewModel.Event.StartSampleSecondActivity-> {
                            startDtoSampleSecondActivity()
                        }
                    }
                }.launchIn(this@repeatOnLifecycle)
            }
        }
    }

    private fun startDtoSampleSecondActivity() {
        startActivity(
            Intent(this, DtoSampleSecondActivity::class.java)
        )
    }
}