package com.inspirecoding.clinicapp.di.navigation

import com.inspirecoding.clinicapp.core.redirect.HomeRedirect
import com.inspirecoding.clinicapp.home.redirect.HomeRedirectImpl
import com.inspirecoding.clinicapp.navigation.manager.NavigationManager
import org.koin.dsl.module

val navigationModule = module {
    single {
        NavigationManager(get())
    }

    factory<HomeRedirect> {
        HomeRedirectImpl()
    }
}