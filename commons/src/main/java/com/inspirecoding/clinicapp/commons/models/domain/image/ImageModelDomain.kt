package com.inspirecoding.clinicapp.commons.models.domain.image

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageModelDomain(
    val height: Int,
    val spacer: Int,
    val value: String
) : Parcelable