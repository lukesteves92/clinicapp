package com.inspirecoding.clinicapp.commons.models.domain.divider

import android.os.Parcelable
import com.inspirecoding.clinicapp.commons.constants.Constants.KEY_DEFAULT_SPACER
import kotlinx.parcelize.Parcelize

@Parcelize
data class DividerModelDomain(
    val spacer: Int = KEY_DEFAULT_SPACER
) : Parcelable