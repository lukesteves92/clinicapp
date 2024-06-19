package com.inspirecoding.clinicapp.commons.models.domain.image

import android.os.Parcelable
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_DEFAULT_HEIGHT
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_DEFAULT_SPACER
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_EMPTY_STRING_DEFAULT
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageModelDomain(
    val height: Int = KEY_DEFAULT_HEIGHT,
    val spacer: Int = KEY_DEFAULT_SPACER,
    val value: String = KEY_EMPTY_STRING_DEFAULT
) : Parcelable