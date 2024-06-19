package com.inspirecoding.clinicapp.di.presentation

import com.inspirecoding.clinicapp.features.login.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { LoginViewModel(getLoginScreenUseCase = get()) }
}