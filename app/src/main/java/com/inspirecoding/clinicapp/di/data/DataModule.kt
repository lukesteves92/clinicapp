package com.inspirecoding.clinicapp.di.data

import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT
import com.inspirecoding.clinicapp.core.data.retrofit.RetrofitConfig
import com.inspirecoding.clinicapp.core.data.service.ClinicAppService
import com.inspirecoding.clinicapp.core.data.wrapper.RequestWrapper
import com.inspirecoding.clinicapp.core.data.wrapper.RequestWrapperImpl
import com.inspirecoding.clinicapp.core.remoteconfig.RemoteConfigUtils
import com.inspirecoding.clinicapp.data.repository.login.GetLoginScreenImpl
import com.inspirecoding.clinicapp.data.repository.toggle.GetFeatureToggleImpl
import com.inspirecoding.clinicapp.domain.repository.login.GetLoginScreenRepository
import com.inspirecoding.clinicapp.domain.repository.toggle.GetFeatureToggleRepository
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

    single<RequestWrapper> {
        RequestWrapperImpl()
    }

    single<ClinicAppService> {
        RetrofitConfig.createService(get(), KEY_EMPTY_STRING_DEFAULT)
    }

    single {
        RetrofitConfig.provideOkHttpClient()
    }

    factory<GetLoginScreenRepository> {
        GetLoginScreenImpl(wrapper = get(), service = get())
    }
}