package com.inspirecoding.clinicapp.commons.models.domain.row

import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_DEFAULT_SPACER
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class RowModelDomain(
    val checkboxLabel: String = KEY_EMPTY_STRING_DEFAULT,
    val firstLabel: String = KEY_EMPTY_STRING_DEFAULT,
    val horizontalArrangement: @RawValue Arrangement.HorizontalOrVertical = Arrangement.SpaceBetween,
    val spacer: Int = KEY_DEFAULT_SPACER,
    val verticalAlignment: @RawValue Alignment.Vertical = Alignment.CenterVertically
) : Parcelable