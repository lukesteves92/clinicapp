package com.inspirecoding.clinicapp.commons.models.remote.navigation.items

import com.google.gson.annotations.SerializedName

data class NavigationItemsModelResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("redirectTo")
    val redirectTo: String
)
