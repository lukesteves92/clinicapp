package com.inspirecoding.clinicapp.commons.models.domain.bottom

import android.os.Parcelable
import androidx.compose.ui.Alignment
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class BottomModelDomain(
    val firstLabel: String = KEY_EMPTY_STRING_DEFAULT,
    val redirect: String = KEY_EMPTY_STRING_DEFAULT,
    val secondLabel: String = KEY_EMPTY_STRING_DEFAULT,
    val verticalAlignment: @RawValue Alignment.Vertical = Alignment.CenterVertically
) : Parcelable