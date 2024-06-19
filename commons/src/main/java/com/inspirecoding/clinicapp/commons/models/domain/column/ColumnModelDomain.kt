package com.inspirecoding.clinicapp.commons.models.domain.column

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ColumnModelDomain(
    val horizontalAlignment: String,
    val padding: Int,
    val verticalAlignment: String
) : Parcelable