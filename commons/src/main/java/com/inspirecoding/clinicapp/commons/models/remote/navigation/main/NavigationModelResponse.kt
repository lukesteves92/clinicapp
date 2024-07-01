package com.inspirecoding.clinicapp.commons.models.remote.navigation.main

import com.google.gson.annotations.SerializedName
import com.inspirecoding.clinicapp.commons.models.domain.navigation.items.NavigationItemsModelDomain
import com.inspirecoding.clinicapp.commons.models.remote.navigation.items.NavigationItemsModelResponse

data class NavigationModelResponse(
    @SerializedName("spacer")
    val spacer: Int,
    @SerializedName("navigationItems")
    val navigationItems: List<NavigationItemsModelResponse>
)
