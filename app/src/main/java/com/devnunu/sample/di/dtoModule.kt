package com.devnunu.sample.di

import com.devnunu.sample.model.SampleDtoProvider
import org.koin.dsl.module

val dtoModule = module {
    single { SampleDtoProvider() }
}