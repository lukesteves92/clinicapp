package com.inspirecoding.clinicapp.commons.models.remote.row

import com.google.gson.annotations.SerializedName

data class RowModelResponse(
    @SerializedName("checkboxLabel")
    val checkboxLabel: String,
    @SerializedName("firstLabel")
    val firstLabel: String,
    @SerializedName("horizontalArrangement")
    val horizontalArrangement: String,
    @SerializedName("spacer")
    val spacer: Int,
    @SerializedName("verticalAlignment")
    val verticalAlignment: String
)