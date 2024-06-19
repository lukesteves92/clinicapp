package com.inspirecoding.clinicapp.commons.models.domain.row

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RowModelDomain(
    val checkboxLabel: String,
    val firstLabel: String,
    val horizontalArrangement: String,
    val spacer: Int,
    val verticalAlignment: String
) : Parcelable