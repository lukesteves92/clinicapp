package com.inspirecoding.clinicapp.core.data.wrapper

import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT
import com.inspirecoding.clinicapp.commons.generic.GenericException
import com.inspirecoding.clinicapp.core.data.responseapi.ResponseApi
import retrofit2.Response
import java.io.IOException

class RequestWrapperImpl: RequestWrapper {
    override suspend fun <T : Any> wrapper(call: suspend () -> Response<T>): ResponseApi<T> {
        return try {
            val response = call.invoke()
            val errorBody = response.errorBody()?.string() ?: KEY_EMPTY_STRING_DEFAULT

            when {
                response.isSuccessful -> {

                    ResponseApi.Success(
                        data = response.body()
                    )
                }

                else -> ResponseApi.ErrorException(GenericException.ErrorNetworkException)
            }
        } catch (exception: IOException) {
            ResponseApi.ErrorException(GenericException.ErrorNetworkException)
        } catch (exception: GenericException) {
            ResponseApi.ErrorException(exception)
        }
    }
}