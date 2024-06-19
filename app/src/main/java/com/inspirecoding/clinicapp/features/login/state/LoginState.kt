package com.inspirecoding.clinicapp.features.login.state

import com.inspirecoding.clinicapp.commons.models.domain.screen.ScreenModelDomain

sealed interface LoginState {
    data object Loading : LoginState
    data class GetLoginScreenConfig(val screenModelDomain: ScreenModelDomain?) : LoginState
}