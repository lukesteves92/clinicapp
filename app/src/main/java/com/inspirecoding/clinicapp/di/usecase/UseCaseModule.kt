package com.inspirecoding.clinicapp.di.usecase

import com.inspirecoding.clinicapp.domain.usecase.login.GetLoginScreenUseCase
import com.inspirecoding.clinicapp.domain.usecase.toggle.GetFeatureToggleUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetFeatureToggleUseCase(getFeatureToggleRepository = get())
    }

    factory {
        GetLoginScreenUseCase(repository = get())
    }
}