package com.inspirecoding.clinicapp.di.navigation

import com.inspirecoding.clinicapp.navigation.manager.NavigationManager
import org.koin.dsl.module

val navigationModule = module {
    single {
        NavigationManager(get())
    }
}