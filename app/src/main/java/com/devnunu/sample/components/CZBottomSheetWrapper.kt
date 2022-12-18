package com.devnunu.sample.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CZBottomSheetWrapper(
    modalBottomSheetState: ModalBottomSheetState,
    onClickBack: () -> Unit,
    content: @Composable () -> Unit
) {
    // bottomSheet 내부 영역이 없으면 앵커를 잡지 못해서 에러 발생하므로 padding 으로 일정 영역을 확보해줌
    Box(
        modifier = Modifier.padding(top = 1.dp)
    ) {
        content()
        BackHandler(
            enabled = modalBottomSheetState.isVisible,
            onBack = onClickBack
        )
    }
}