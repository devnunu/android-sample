package com.devnunu.sample.ui.bottomSheetSample

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.devnunu.sample.model.BottomSheetState
import org.koin.android.ext.android.inject

class BottomSheetSampleViewModel(
    initialState: BottomSheetSampleState = BottomSheetSampleState()
) : MavericksViewModel<BottomSheetSampleState>(initialState) {

    fun onCloseBottomSheet() = withState { state ->
        setState {
            copy(bottomSheetState = BottomSheetState.Closed(state.bottomSheetState.tag))
        }
    }

    fun onClickOpenBottomSheet(tag: BottomSheetSampleTag) {
        setState {
            copy(bottomSheetState = BottomSheetState.Opened(tag))
        }
    }

    companion object :
        MavericksViewModelFactory<BottomSheetSampleViewModel, BottomSheetSampleState> {

        override fun create(
            viewModelContext: ViewModelContext,
            state: BottomSheetSampleState
        ): BottomSheetSampleViewModel {
            val viewModel: BottomSheetSampleViewModel by viewModelContext.activity.inject()
            return viewModel
        }
    }
}