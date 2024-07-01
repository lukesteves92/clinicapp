package com.inspirecoding.clinicapp.commons.models.remote.button

import com.google.gson.annotations.SerializedName

data class ButtonModelResponse(
    @SerializedName("label")
    val label: String,
    @SerializedName("redirect")
    val redirect: String,
    @SerializedName("spacer")
    val spacer: Int
)