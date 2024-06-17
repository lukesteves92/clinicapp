package com.inspirecoding.clinicapp.features.login.state

import com.inspirecoding.clinicapp.domain.models.FeatureToggleLoginModel

sealed interface LoginState {
    data object Loading : LoginState
    data class GetLoginFeatureToggleScreen(val featureToggleLoginModel: FeatureToggleLoginModel?) : LoginState
}