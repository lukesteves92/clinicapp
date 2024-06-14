package com.inspirecoding.clinicapp.commons.extensions

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

fun String.decode(): String = URLDecoder.decode(this, StandardCharsets.UTF_8.toString())

fun String?.convertBase64ToBitmap(): Bitmap? {
    return runCatching {
        val decodedBytes = Base64.decode(this, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }.getOrNull()
}