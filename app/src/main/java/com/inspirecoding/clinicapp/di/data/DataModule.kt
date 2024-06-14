package com.inspirecoding.clinicapp.di.data

import com.inspirecoding.clinicapp.core.remoteconfig.RemoteConfigUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single {
        CoroutineScope(Dispatchers.IO)
    }

    single {
        RemoteConfigUtils()
    }
}