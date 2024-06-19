package com.inspirecoding.clinicapp.commons.models.domain.bottom

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BottomModelDomain(
    val firstLabel: String,
    val redirect: String,
    val secondLabel: String,
    val verticalAlignment: String
) : Parcelable