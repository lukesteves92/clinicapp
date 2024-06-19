package com.inspirecoding.clinicapp.commons.models.domain.button

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ButtonModelDomain(
    val label: String,
    val redirect: String,
    val spacer: Int
) : Parcelable