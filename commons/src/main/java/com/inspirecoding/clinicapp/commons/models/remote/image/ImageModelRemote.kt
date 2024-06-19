package com.inspirecoding.clinicapp.commons.models.remote.image

import com.google.gson.annotations.SerializedName

data class ImageModelRemote(
    @SerializedName("height")
    val height: Int,
    @SerializedName("spacer")
    val spacer: Int,
    @SerializedName("value")
    val value: String
)