package com.devnunu.sample.components.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.devnunu.sample.theme.Purple200

@Composable
fun BasicInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        BasicTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            cursorBrush = SolidColor(Purple200),
            onValueChange = onValueChange
        )
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = if (isFocused) Purple200 else Color.LightGray,
            thickness = 1.dp
        )
    }
}