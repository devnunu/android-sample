package com.devnunu.sample.ui.bottomSheetSample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import com.devnunu.sample.components.button.SampleButton
import com.devnunu.sample.components.scaffold.BaseScaffold
import com.devnunu.sample.ui.bottomSheetSample.components.BottomSheetSampleBottomSheet

@Composable
fun BottomSheetSampleScreen(
    viewModel: BottomSheetSampleViewModel
) {

    val viewModelSheetState by viewModel.collectAsState { it.bottomSheetState }

    BaseScaffold(
        bottomSheetView = BottomSheetSampleBottomSheet(
            viewModelSheetState = viewModelSheetState,
            viewModel = viewModel
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            SampleButton(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Modal 1",
                onClick = { viewModel.onClickOpenBottomSheet(BottomSheetSampleTag.SAMPLE_1) }
            )
            SampleButton(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Modal 2",
                onClick = { viewModel.onClickOpenBottomSheet(BottomSheetSampleTag.SAMPLE_2) }
            )
            SampleButton(
                modifier = Modifier.padding(bottom = 10.dp),
                text = "Modal 2",
                onClick = { viewModel.onClickOpenBottomSheet(BottomSheetSampleTag.SAMPLE_3) }
            )
        }
    }
}