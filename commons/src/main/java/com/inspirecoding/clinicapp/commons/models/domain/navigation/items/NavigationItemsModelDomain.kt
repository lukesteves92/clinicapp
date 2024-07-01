package com.inspirecoding.clinicapp.commons.models.domain.navigation.items

import android.os.Parcelable
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT
import kotlinx.parcelize.Parcelize

@Parcelize
data class NavigationItemsModelDomain(
    val name: String = KEY_EMPTY_STRING_DEFAULT,
    val redirectTo: String = KEY_EMPTY_STRING_DEFAULT
) : Parcelable
