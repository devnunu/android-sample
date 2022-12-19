package com.devnunu.sample.ui.dtoSample.third

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState

@Composable
fun DtoSampleThirdScreen(
    viewModel: DtoSampleThirdViewModel
) {
    val firstData by viewModel.collectAsState { it.firstData }
    val secondData by viewModel.collectAsState { it.secondData }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(bottom = 20.dp),
            text = "firstData: ${firstData.orEmpty()}"
        )
        Text(
            text = "secondData: ${secondData.orEmpty()}"
        )
    }
}