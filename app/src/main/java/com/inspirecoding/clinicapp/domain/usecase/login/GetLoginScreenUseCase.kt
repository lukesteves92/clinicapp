package com.inspirecoding.clinicapp.domain.usecase.login

import com.inspirecoding.clinicapp.commons.models.domain.screen.ScreenModelDomain
import com.inspirecoding.clinicapp.domain.repository.login.GetLoginScreenRepository
import kotlinx.coroutines.flow.Flow

class GetLoginScreenUseCase(
    private val repository: GetLoginScreenRepository
) {
    fun getLoginScreen() : Flow<ScreenModelDomain> = repository.getLoginScreen()
}