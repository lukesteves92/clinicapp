package com.inspirecoding.clinicapp.commons.models.remote.divider

import com.google.gson.annotations.SerializedName

data class DividerModelResponse(
    @SerializedName("spacer")
    val spacer: Int
)