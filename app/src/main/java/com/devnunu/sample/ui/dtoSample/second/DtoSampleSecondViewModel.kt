package com.devnunu.sample.ui.dtoSample.second

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.devnunu.sample.model.Dispatcher
import com.devnunu.sample.model.SampleDtoProvider
import com.devnunu.sample.ui.dtoSample.first.DtoSampleFirstState
import com.devnunu.sample.ui.dtoSample.first.DtoSampleFirstViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.koin.android.ext.android.inject

class DtoSampleSecondViewModel(
    private val dtoProvider: SampleDtoProvider,
    initialState: DtoSampleSecondState = DtoSampleSecondState()
) : MavericksViewModel<DtoSampleSecondState>(initialState) {

    private val _eventFlow = MutableSharedFlow<Dispatcher>(extraBufferCapacity = 1)
    val eventFlow = _eventFlow.asSharedFlow()

    object Event {
        object StartSampleThirdActivity : Dispatcher
    }

    fun onValueChange(inputValue: String) {
        setState { copy(inputValue = inputValue) }
    }

    fun onClickNextBtn() = withState { state ->
        dtoProvider.setSampleSecondData(secondData = state.inputValue.orEmpty())
        _eventFlow.tryEmit(Event.StartSampleThirdActivity)
    }

    companion object :
        MavericksViewModelFactory<DtoSampleSecondViewModel, DtoSampleSecondState> {

        override fun create(
            viewModelContext: ViewModelContext,
            state: DtoSampleSecondState
        ): DtoSampleSecondViewModel {
            val viewModel: DtoSampleSecondViewModel by viewModelContext.activity.inject()
            return viewModel
        }
    }
}