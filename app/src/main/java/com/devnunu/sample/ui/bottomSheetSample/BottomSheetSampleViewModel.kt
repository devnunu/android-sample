package com.devnunu.sample.ui.bottomSheetSample

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import org.koin.android.ext.android.inject

class BottomSheetSampleViewModel(
    initialState: BottomSheetSampleState = BottomSheetSampleState()
) : MavericksViewModel<BottomSheetSampleState>(initialState) {




    companion object : MavericksViewModelFactory<BottomSheetSampleViewModel, BottomSheetSampleState> {

        override fun create(viewModelContext: ViewModelContext, state: BottomSheetSampleState): BottomSheetSampleViewModel? {
            val viewModel: BottomSheetSampleViewModel by viewModelContext.activity.inject()
            return viewModel
        }
    }
}