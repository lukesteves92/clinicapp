package com.inspirecoding.clinicapp.features.login.action

sealed interface LoginAction {
    data object GetLoginFeatureToggleScreen : LoginAction
}