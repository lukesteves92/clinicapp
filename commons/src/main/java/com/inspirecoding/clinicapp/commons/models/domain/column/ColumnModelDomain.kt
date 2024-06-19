package com.inspirecoding.clinicapp.commons.models.domain.column

import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_DEFAULT_PADDING
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ColumnModelDomain(
    val horizontalAlignment: @RawValue Alignment.Horizontal = Alignment.CenterHorizontally,
    val padding: Int = KEY_DEFAULT_PADDING,
    val verticalArrangement: @RawValue Arrangement.HorizontalOrVertical = Arrangement.SpaceBetween
) : Parcelable