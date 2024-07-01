package com.inspirecoding.clinicapp.commons.models.remote.bottom

import com.google.gson.annotations.SerializedName

data class BottomModelResponse(
    @SerializedName("firstLabel")
    val firstLabel: String,
    @SerializedName("redirect")
    val redirect: String,
    @SerializedName("secondLabel")
    val secondLabel: String,
    @SerializedName("verticalAlignment")
    val verticalAlignment: String
)