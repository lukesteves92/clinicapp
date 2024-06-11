package com.inspirecoding.clinicapp.di.data

import com.inspirecoding.clinicapp.data.util.RemoteConfigUtils
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
}