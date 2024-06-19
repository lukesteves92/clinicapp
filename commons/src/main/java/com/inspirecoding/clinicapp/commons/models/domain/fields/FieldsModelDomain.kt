package com.inspirecoding.clinicapp.commons.models.domain.fields

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FieldsModelDomain(
    val firstLabel: String,
    val secondLabel: String,
    val spacer: Int
) : Parcelable