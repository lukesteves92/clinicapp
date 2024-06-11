package com.inspirecoding.clinicapp.domain.exception

sealed class GenericException(
    override val message: String? = "",
    val code: String? = ""
) : Throwable() {
    class ErrorGeneric(message: String, code: String) : GenericException(message, code)
    object ErrorNetworkException : GenericException()
}