package com.devnunu.sample.components.scaffold

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@OptIn(ExperimentalMaterialApi::class)
data class ScaffoldBottomSheetView(
    val sheetState: ModalBottomSheetState,
    val sheetShape: Shape,
    val sheetContent: @Composable ColumnScope.() -> Unit,
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BaseScaffold(
    // bottom Sheet
    bottomSheetView: ScaffoldBottomSheetView? = null,
    // content
    content: @Composable () -> Unit,
) {
    if (bottomSheetView != null) {
        ModalBottomSheetLayout(
            sheetState = bottomSheetView.sheetState,
            sheetShape = bottomSheetView.sheetShape,
            sheetContent = bottomSheetView.sheetContent,
            content = {
                content()
            }
        )
    } else {
        content()
    }
}