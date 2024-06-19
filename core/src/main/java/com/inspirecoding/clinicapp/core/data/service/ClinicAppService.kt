package com.inspirecoding.clinicapp.core.data.service

import com.inspirecoding.clinicapp.commons.models.remote.screen.ScreenModelRemote
import retrofit2.Response
import retrofit2.http.GET

interface ClinicAppService {
    @GET("/clinic/login/screen")
    suspend fun getLoginScreen(): Response<ScreenModelRemote>
}