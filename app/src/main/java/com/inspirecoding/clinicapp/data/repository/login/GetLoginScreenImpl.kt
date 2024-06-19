package com.inspirecoding.clinicapp.data.repository.login

import com.inspirecoding.clinicapp.commons.generic.GenericException
import com.inspirecoding.clinicapp.commons.mapping.mapToDomain
import com.inspirecoding.clinicapp.commons.models.domain.screen.ScreenModelDomain
import com.inspirecoding.clinicapp.core.data.responseapi.ResponseApi
import com.inspirecoding.clinicapp.core.data.service.ClinicAppService
import com.inspirecoding.clinicapp.core.data.wrapper.RequestWrapper
import com.inspirecoding.clinicapp.domain.repository.login.GetLoginScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetLoginScreenImpl(
    private val wrapper: RequestWrapper,
    private val service: ClinicAppService
) : GetLoginScreenRepository {
    override fun getLoginScreen(): Flow<ScreenModelDomain> {
        return flow {
            val result = wrapper.wrapper {
                service.getLoginScreen()
            }
            when (result) {
                is ResponseApi.Success -> result.data?.let { dataResponse -> emit(dataResponse.mapToDomain()) }
                    ?: throw GenericException.ErrorNetworkException

                is ResponseApi.ErrorException -> throw GenericException.ErrorGeneric(
                    result.errorException.message.orEmpty(),
                    result.errorException.code.orEmpty()
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}