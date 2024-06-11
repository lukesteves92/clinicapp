package com.inspirecoding.clinicapp.di.util

import com.inspirecoding.clinicapp.features.login.featuretoggle.GetFeatureToggleLogin
import org.koin.dsl.module

val utilModule = module {
    single {
        GetFeatureToggleLogin(remoteConfigUtils = get())
    }
}