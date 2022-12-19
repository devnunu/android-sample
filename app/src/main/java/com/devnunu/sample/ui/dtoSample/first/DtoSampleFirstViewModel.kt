package com.devnunu.sample.ui.dtoSample.first

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.devnunu.sample.model.Dispatcher
import com.devnunu.sample.model.SampleDtoProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import org.koin.android.ext.android.inject

class DtoSampleFirstViewModel(
    private val dtoProvider: SampleDtoProvider,
    initialState: DtoSampleFirstState = DtoSampleFirstState()
) : MavericksViewModel<DtoSampleFirstState>(initialState) {

    private val _eventFlow = MutableSharedFlow<Dispatcher>(extraBufferCapacity = 1)
    val eventFlow = _eventFlow.asSharedFlow()

    object Event {
        object StartSampleSecondActivity : Dispatcher
    }

    fun onValueChange(inputValue: String) {
        setState { copy(inputValue = inputValue) }
    }

    fun onClickNextBtn() = withState { state ->
        dtoProvider.clearDto().setSampleFirstData(firstData = state.inputValue.orEmpty())
        _eventFlow.tryEmit(Event.StartSampleSecondActivity)
    }

    companion object :
        MavericksViewModelFactory<DtoSampleFirstViewModel, DtoSampleFirstState> {

        override fun create(
            viewModelContext: ViewModelContext,
            state: DtoSampleFirstState
        ): DtoSampleFirstViewModel {
            val viewModel: DtoSampleFirstViewModel by viewModelContext.activity.inject()
            return viewModel
        }
    }
}