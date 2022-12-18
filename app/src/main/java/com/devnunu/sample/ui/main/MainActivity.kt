package com.devnunu.sample.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.devnunu.sample.components.button.SampleButton
import com.devnunu.sample.ui.bottomSheetSample.BottomSheetSampleActivity
import com.devnunu.sample.theme.SampleTheme

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
                        text = "Bottom Sheet Sample",
                        onClick = { startBottomSheetSampleActivity() }
                    )
                }
            }
        }
    }

    private fun startBottomSheetSampleActivity() {
        startActivity(
            Intent(this, BottomSheetSampleActivity::class.java)
        )
    }
}