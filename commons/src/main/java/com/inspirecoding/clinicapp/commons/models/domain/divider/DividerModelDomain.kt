package com.inspirecoding.clinicapp.commons.models.domain.divider

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DividerModelDomain(
    val spacer: Int
) : Parcelable