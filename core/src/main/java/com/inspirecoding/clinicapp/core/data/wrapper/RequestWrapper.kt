package com.inspirecoding.clinicapp.core.data.wrapper

import com.inspirecoding.clinicapp.core.data.responseapi.ResponseApi
import retrofit2.Response

interface RequestWrapper {
    suspend fun <T : Any> wrapper(call: suspend () -> Response<T>): ResponseApi<T>
}