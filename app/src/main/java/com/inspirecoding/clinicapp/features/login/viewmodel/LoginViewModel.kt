package com.inspirecoding.clinicapp.features.login.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.inspirecoding.clinicapp.commons.constants.Constants.PreferencesKeys.BOTTOMITEMS
import com.inspirecoding.clinicapp.commons.constants.Constants.PreferencesKeys.SHARED_NAME
import com.inspirecoding.clinicapp.commons.models.domain.navigation.main.NavigationModelDomain
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

    private lateinit var sharedPreferences: SharedPreferences

    val gson = Gson()

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
                    saveSharedPreferencesNavigation(navigationModelDomain = model.navigationModelDomain)
                    LoginState.GetLoginScreenConfig(screenModelDomain = model).updateState()
                },
                error = {}
            )
        }
    }

    private fun setupSharedPreferencesNavigation(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    }

    private fun saveSharedPreferencesNavigation(navigationModelDomain: NavigationModelDomain) {
        sharedPreferences.edit().run {
            putString(
                BOTTOMITEMS,
                gson.toJson(navigationModelDomain)
            )
            apply()
        }
    }

    private fun handleActions() {
        viewModelScope.launch(Dispatchers.Main) {
            pendingActions.collect { action ->
                when (action) {
                    is LoginAction.GetLoginScreenConfig -> getLoginScreenConfig()
                    is LoginAction.GetSharedPreferencesNavigation -> setupSharedPreferencesNavigation(context = action.context)
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