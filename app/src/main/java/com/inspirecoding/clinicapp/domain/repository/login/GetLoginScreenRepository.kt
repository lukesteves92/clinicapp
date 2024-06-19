package com.inspirecoding.clinicapp.domain.repository.login

import com.inspirecoding.clinicapp.commons.models.domain.screen.ScreenModelDomain
import kotlinx.coroutines.flow.Flow

interface GetLoginScreenRepository {
    fun getLoginScreen() : Flow<ScreenModelDomain>
}