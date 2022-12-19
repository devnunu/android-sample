package com.devnunu.sample.ui.dtoSample.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import com.devnunu.sample.components.button.SampleButton
import com.devnunu.sample.components.input.BasicInput
import com.devnunu.sample.theme.Purple200

@Composable
fun DtoSampleFirstScreen(
    viewModel: DtoSampleFirstViewModel
) {

    val inputValue by viewModel.collectAsState { it.inputValue }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicInput(
            modifier = Modifier.padding(bottom = 20.dp, start = 50.dp, end = 50.dp),
            value = inputValue.orEmpty(),
            onValueChange = viewModel::onValueChange
        )
        SampleButton(
            text = "다음 페이지",
            onClick = viewModel::onClickNextBtn
        )
    }
}