package com.inspirecoding.clinicapp.core.data.responseapi

import com.inspirecoding.clinicapp.commons.generic.GenericException

sealed class ResponseApi<out T> {
    class Success<T>(var data: T?) : ResponseApi<T>()
    class ErrorException(var errorException: GenericException) : ResponseApi<Nothing>()
}