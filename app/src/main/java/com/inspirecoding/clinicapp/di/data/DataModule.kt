package com.inspirecoding.clinicapp.di.data

import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.inspirecoding.clinicapp.core.remoteconfig.RemoteConfigUtils
import com.inspirecoding.clinicapp.data.repository.GetFeatureToggleImpl
import com.inspirecoding.clinicapp.domain.repository.GetFeatureToggleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single {
        CoroutineScope(Dispatchers.IO)
    }

    factory {
        RemoteConfigUtils()
    }

    factory<GetFeatureToggleRepository> {
        GetFeatureToggleImpl(remoteConfigUtils = get())
    }
}