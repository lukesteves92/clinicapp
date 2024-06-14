package com.inspirecoding.clinicapp.main.application

import android.app.Application
import com.google.firebase.FirebaseApp
import com.inspirecoding.clinicapp.di.data.dataModule
import com.inspirecoding.clinicapp.di.navigation.navigationModule
import com.inspirecoding.clinicapp.di.presentation.presentationModule
import com.inspirecoding.clinicapp.di.usecase.useCaseModule
import com.inspirecoding.clinicapp.di.util.utilModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    navigationModule,
                    dataModule,
                    presentationModule,
                    useCaseModule,
                    utilModule
                )
            )
        }
    }
}