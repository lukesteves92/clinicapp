package com.inspirecoding.clinicapp.di.usecase

import com.inspirecoding.clinicapp.domain.usecase.GetFeatureToggleUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetFeatureToggleUseCase(getFeatureToggleRepository = get())
    }
}