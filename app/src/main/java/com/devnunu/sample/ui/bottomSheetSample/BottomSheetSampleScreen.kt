package com.devnunu.sample.ui.bottomSheetSample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import com.devnunu.sample.ui.bottomSheetSample.components.BottomSheetSampleBottomSheet
import com.devnunu.sample.model.BottomSheetState
import com.devnunu.sample.components.BaseScaffold
import com.devnunu.sample.components.button.SampleButton

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetSampleScreen(
    viewModel: BottomSheetSampleViewModel
) {

    val bottomSheetState by viewModel.collectAsState { it.bottomSheetState }

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = {
            if (it == ModalBottomSheetValue.Hidden) {
                viewModel.onCloseBottomSheet()
                return@rememberModalBottomSheetState false
            }
            if (it == ModalBottomSheetValue.HalfExpanded) {
                return@rememberModalBottomSheetState false
            }
            true
        })

    LaunchedEffect(bottomSheetState) {
        when (bottomSheetState) {
            is BottomSheetState.Closed -> modalBottomSheetState.animateTo(ModalBottomSheetValue.Hidden)
            is BottomSheetState.Opened -> modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
        }
    }

    BaseScaffold(
        bottomSheetView = BottomSheetSampleBottomSheet(
            modalBottomSheetState = modalBottomSheetState,
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