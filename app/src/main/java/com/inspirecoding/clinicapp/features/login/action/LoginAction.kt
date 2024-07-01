package com.inspirecoding.clinicapp.features.login.action

import android.content.Context

sealed interface LoginAction {
    data object GetLoginScreenConfig : LoginAction
    data class GetSharedPreferencesNavigation(val context: Context) : LoginAction
}