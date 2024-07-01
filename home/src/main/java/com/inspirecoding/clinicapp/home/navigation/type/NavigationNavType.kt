package com.inspirecoding.clinicapp.home.navigation.type

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.inspirecoding.clinicapp.commons.extensions.decode

class NavigationNavType<T : Parcelable>(
    private val type: Class<T>,
    isNullableAllowed: Boolean = false
) : NavType<T>(isNullableAllowed = isNullableAllowed) {

    override fun get(bundle: Bundle, key: String): T? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, type)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): T {
        return Gson().fromJson(value.decode(), type)
    }

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putParcelable(key, value)
    }
}