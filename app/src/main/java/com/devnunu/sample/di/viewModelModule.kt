package com.devnunu.sample.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.devnunu.sample.ui.bottomSheetSample.BottomSheetSampleViewModel
import com.devnunu.sample.ui.dtoSample.first.DtoSampleFirstViewModel
import com.devnunu.sample.ui.dtoSample.second.DtoSampleSecondViewModel
import com.devnunu.sample.ui.dtoSample.third.DtoSampleThirdViewModel
import org.koin.dsl.module

val viewModelModule = module {

    factory { BottomSheetSampleViewModel() }

    factory { DtoSampleFirstViewModel(get()) }

    factory { DtoSampleSecondViewModel(get()) }

    factory { DtoSampleThirdViewModel(get()) }

}