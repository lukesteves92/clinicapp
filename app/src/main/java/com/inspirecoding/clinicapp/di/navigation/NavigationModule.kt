package com.inspirecoding.clinicapp.di.navigation

import com.inspirecoding.clinicapp.core.redirect.HomeRedirect
import com.inspirecoding.clinicapp.home.navigation.manager.HomeNavigationManager
import com.inspirecoding.clinicapp.home.redirect.HomeRedirectImpl
import com.inspirecoding.clinicapp.navigation.manager.MainNavigationManager
import org.koin.dsl.module

val navigationModule = module {
    single {
        MainNavigationManager(get())
    }

    single {
        HomeNavigationManager(get())
    }

    factory<HomeRedirect> {
        HomeRedirectImpl()
    }
}