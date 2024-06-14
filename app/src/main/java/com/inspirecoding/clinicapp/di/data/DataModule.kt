package com.inspirecoding.clinicapp.di.data

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
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
        RemoteConfigUtils(firebaseRemoteConfig = Firebase.remoteConfig)
    }

    factory<GetFeatureToggleRepository> {
        GetFeatureToggleImpl(remoteConfigUtils = get())
    }
}