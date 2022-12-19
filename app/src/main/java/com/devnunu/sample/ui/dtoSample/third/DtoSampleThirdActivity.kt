package com.devnunu.sample.ui.dtoSample.third

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.airbnb.mvrx.viewModel

class DtoSampleThirdActivity : ComponentActivity() {

    private val viewModel: DtoSampleThirdViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DtoSampleThirdScreen(viewModel = viewModel)
        }
    }
}