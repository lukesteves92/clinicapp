package com.inspirecoding.clinicapp.commons.models.domain.navigation.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_DEFAULT_SPACER
import com.inspirecoding.clinicapp.commons.models.domain.navigation.items.NavigationItemsModelDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavigationModelDomain(
    val spacer: Int = KEY_DEFAULT_SPACER,
    val navigationItems: List<NavigationItemsModelDomain> = listOf()
) : Parcelable
