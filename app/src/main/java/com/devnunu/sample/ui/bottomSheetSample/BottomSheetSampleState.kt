package com.devnunu.sample.ui.bottomSheetSample

import com.airbnb.mvrx.MavericksState

data class BottomSheetSampleState(
    val temp: String? = null
) : MavericksState {
}