package com.devnunu.sample.ui.dtoSample.third

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.devnunu.sample.model.SampleDtoProvider
import org.koin.android.ext.android.inject

class DtoSampleThirdViewModel(
    private val dtoProvider: SampleDtoProvider,
    initialState: DtoSampleThirdState = DtoSampleThirdState()
) : MavericksViewModel<DtoSampleThirdState>(initialState) {

    init {
        setState {
            copy(
                firstData = dtoProvider.dto?.firstData,
                secondData = dtoProvider.dto?.secondData
            )
        }
    }

    companion object :
        MavericksViewModelFactory<DtoSampleThirdViewModel, DtoSampleThirdState> {

        override fun create(
            viewModelContext: ViewModelContext,
            state: DtoSampleThirdState
        ): DtoSampleThirdViewModel {
            val viewModel: DtoSampleThirdViewModel by viewModelContext.activity.inject()
            return viewModel
        }
    }
}