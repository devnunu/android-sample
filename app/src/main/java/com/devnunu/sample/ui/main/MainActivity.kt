package com.devnunu.sample.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.sample.components.button.SampleButton
import com.devnunu.sample.ui.bottomSheetSample.BottomSheetSampleActivity
import com.devnunu.sample.theme.SampleTheme
import com.devnunu.sample.ui.dtoSample.first.DtoSampleFirstActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SampleButton(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Dto Sample",
                        onClick = { startDtoSampleFirstActivity() }
                    )
                    SampleButton(
                        text = "Bottom Sheet Sample",
                        onClick = { startBottomSheetSampleActivity() }
                    )
                }
            }
        }
    }

    private fun startDtoSampleFirstActivity() {
        startActivity(
            Intent(this, DtoSampleFirstActivity::class.java)
        )
    }

    private fun startBottomSheetSampleActivity() {
        startActivity(
            Intent(this, BottomSheetSampleActivity::class.java)
        )
    }
}