package com.inspirecoding.clinicapp.commons.singleorthrow

import com.inspirecoding.clinicapp.commons.generic.GenericException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single

suspend inline fun <T> Flow<T>.singleOrThrow(
    success: ((T) -> Unit),
    error: ((GenericException) -> Unit)
) {
    try {
        success.invoke(single())
    } catch (e: GenericException) {
        error.invoke(e)
    }
}