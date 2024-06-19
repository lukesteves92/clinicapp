package com.inspirecoding.clinicapp.features.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_FT_LOGIN_SCREEN
import com.inspirecoding.clinicapp.domain.models.toggle.FeatureToggleLoginModel
import com.inspirecoding.clinicapp.domain.usecase.toggle.GetFeatureToggleUseCase
import com.inspirecoding.clinicapp.features.login.action.LoginAction
import com.inspirecoding.clinicapp.features.login.state.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getFeatureToggleUseCase: GetFeatureToggleUseCase
): ViewModel() {

    private val pendingActions = MutableSharedFlow<LoginAction>()

    private var _state: MutableStateFlow<LoginState> =
        MutableStateFlow(LoginState.Loading)
    var state: StateFlow<LoginState> = _state

    init {
        handleActions()
        getLoginFeatureToggleScreen()
    }

    private fun handleActions() {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is LoginAction.GetLoginFeatureToggleScreen -> getLoginFeatureToggleScreen()
                }
            }
        }
    }

    private fun getLoginFeatureToggleScreen() {
        viewModelScope.launch {
            LoginState.GetLoginFeatureToggleScreen(featureToggleLoginModel = getFeatureToggleUseCase.getFeatureToggleValueString(featureKey = KEY_FT_LOGIN_SCREEN, clazz = FeatureToggleLoginModel())).updateState()
        }
    }

    fun submitAction(action: LoginAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    private fun LoginState.updateState() = _state.update { this }
}