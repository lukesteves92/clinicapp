package com.inspirecoding.clinicapp.commons.models.domain.button

import android.os.Parcelable
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_DEFAULT_SPACER
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT
import kotlinx.parcelize.Parcelize

@Parcelize
data class ButtonModelDomain(
    val label: String = KEY_EMPTY_STRING_DEFAULT,
    val redirect: String = KEY_EMPTY_STRING_DEFAULT,
    val spacer: Int = KEY_DEFAULT_SPACER
) : Parcelable