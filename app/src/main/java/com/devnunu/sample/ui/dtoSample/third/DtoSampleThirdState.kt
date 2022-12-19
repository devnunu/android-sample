package com.devnunu.sample.ui.dtoSample.third

import com.airbnb.mvrx.MavericksState

data class DtoSampleThirdState(
    val firstData: String? = null,
    val secondData: String? = null
) : MavericksState