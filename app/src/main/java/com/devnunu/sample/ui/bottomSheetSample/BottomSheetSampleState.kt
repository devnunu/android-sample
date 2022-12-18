package com.devnunu.sample.ui.bottomSheetSample

import com.airbnb.mvrx.MavericksState
import com.devnunu.sample.model.BottomSheetState

enum class BottomSheetSampleTag {
    SAMPLE_1,
    SAMPLE_2,
    SAMPLE_3,
}

data class BottomSheetSampleState(
    val bottomSheetState: BottomSheetState<BottomSheetSampleTag> =
        BottomSheetState.Closed(BottomSheetSampleTag.SAMPLE_1)
) : MavericksState {
}