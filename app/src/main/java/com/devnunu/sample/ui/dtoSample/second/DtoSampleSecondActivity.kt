package com.devnunu.sample.ui.dtoSample.second

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.airbnb.mvrx.viewModel
import com.devnunu.sample.ui.dtoSample.third.DtoSampleThirdActivity
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class DtoSampleSecondActivity : ComponentActivity() {

    private val viewModel: DtoSampleSecondViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DtoSampleSecondScreen(viewModel = viewModel)
        }
        setEventObserver()
    }

    private fun setEventObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.eventFlow.onEach { event ->
                    when (event) {
                        is DtoSampleSecondViewModel.Event.StartSampleThirdActivity -> {
                            startDtoSampleThirdActivity()
                        }
                    }
                }.launchIn(this@repeatOnLifecycle)
            }
        }
    }

    private fun startDtoSampleThirdActivity() {
        startActivity(
            Intent(this, DtoSampleThirdActivity::class.java)
        )
    }
}