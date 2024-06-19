package com.inspirecoding.clinicapp.features.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.clinicapp.commons.singleorthrow.singleOrThrow
import com.inspirecoding.clinicapp.domain.usecase.login.GetLoginScreenUseCase
import com.inspirecoding.clinicapp.features.login.action.LoginAction
import com.inspirecoding.clinicapp.features.login.state.LoginState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val getLoginScreenUseCase: GetLoginScreenUseCase
) : ViewModel() {

    private val pendingActions = MutableSharedFlow<LoginAction>()

    private var _state: MutableStateFlow<LoginState> =
        MutableStateFlow(LoginState.Loading)
    var state: StateFlow<LoginState> = _state

    init {
        handleActions()
    }

    private fun getLoginScreenConfig() {
        viewModelScope.launch(Dispatchers.Main) {
            getLoginScreenUseCase.getLoginScreen().singleOrThrow(
                success = { model ->
                    LoginState.GetLoginScreenConfig(screenModelDomain = model).updateState()
                },
                error = {}
            )
        }
    }

    private fun handleActions() {
        viewModelScope.launch(Dispatchers.Main) {
            pendingActions.collect { action ->
                when (action) {
                    is LoginAction.GetLoginScreenConfig -> getLoginScreenConfig()
                }
            }
        }
    }

    fun submitAction(action: LoginAction) {
        viewModelScope.launch(Dispatchers.Main) {
            pendingActions.emit(action)
        }
    }

    private fun LoginState.updateState() = _state.update { this }
}