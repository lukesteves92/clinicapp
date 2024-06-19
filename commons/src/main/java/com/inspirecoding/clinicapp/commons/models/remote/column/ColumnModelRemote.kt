package com.inspirecoding.clinicapp.commons.models.remote.column

import com.google.gson.annotations.SerializedName

data class ColumnModelRemote(
    @SerializedName("horizontalAlignment")
    val horizontalAlignment: String,
    @SerializedName("padding")
    val padding: Int,
    @SerializedName("verticalArrangement")
    val verticalArrangement: String
)