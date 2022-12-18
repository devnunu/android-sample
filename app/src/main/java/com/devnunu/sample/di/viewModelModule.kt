package com.devnunu.sample.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.devnunu.sample.ui.bottomSheetSample.BottomSheetSampleViewModel
import org.koin.dsl.module

val viewModelModule = module {

    factory { BottomSheetSampleViewModel() }

}