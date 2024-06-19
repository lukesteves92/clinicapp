package com.inspirecoding.clinicapp.commons.models.remote.fields

import com.google.gson.annotations.SerializedName

data class FieldsModelRemote(
    @SerializedName("firstLabel")
    val firstLabel: String,
    @SerializedName("secondLabel")
    val secondLabel: String,
    @SerializedName("spacer")
    val spacer: Int
)