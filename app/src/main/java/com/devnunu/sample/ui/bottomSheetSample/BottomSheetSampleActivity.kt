package com.devnunu.sample.ui.bottomSheetSample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.airbnb.mvrx.viewModel

class BottomSheetSampleActivity : ComponentActivity() {

    private val viewModel: BottomSheetSampleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetSampleScreen(viewModel = viewModel)
        }
    }
}