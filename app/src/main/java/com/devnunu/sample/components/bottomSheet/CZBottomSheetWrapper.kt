package com.devnunu.sample.components.bottomSheet

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.devnunu.sample.components.scaffold.ScaffoldBottomSheetView
import com.devnunu.sample.model.BottomSheetState
import com.devnunu.sample.ui.bottomSheetSample.BottomSheetSampleTag

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun rememberScaffoldBottomSheetView(
    viewModelSheetState: BottomSheetState<BottomSheetSampleTag>,
    onCloseBottomSheet: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
): ScaffoldBottomSheetView {
    val modalBottomSheetState = rememberSampleBottomSheetState(
        onDismissBottomSheet = onCloseBottomSheet
    )
    return ScaffoldBottomSheetView(
        viewModelSheetState = viewModelSheetState,
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
    ) {
        CZBottomSheetWrapper(
            modalBottomSheetState = modalBottomSheetState,
            onClickBack = onCloseBottomSheet
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun rememberSampleBottomSheetState(
    onDismissBottomSheet: () -> Unit
) = rememberModalBottomSheetState(
    initialValue = ModalBottomSheetValue.Hidden,
    confirmStateChange = {
        if (it == ModalBottomSheetValue.Hidden) {
            onDismissBottomSheet()
            return@rememberModalBottomSheetState false
        }
        if (it == ModalBottomSheetValue.HalfExpanded) {
            return@rememberModalBottomSheetState false
        }
        true
    })

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CZBottomSheetWrapper(
    modalBottomSheetState: ModalBottomSheetState,
    onClickBack: () -> Unit,
    content: @Composable () -> Unit
) {
    // bottomSheet ?????? ????????? ????????? ????????? ?????? ????????? ?????? ??????????????? padding ?????? ?????? ????????? ????????????
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