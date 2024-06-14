package com.inspirecoding.clinicapp.features.login.featuretoggle

import com.google.gson.Gson
import com.inspirecoding.clinicapp.core.remoteconfig.RemoteConfigUtils
import com.inspirecoding.clinicapp.domain.models.FeatureToggleLoginModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFeatureToggleLogin(
    private val remoteConfigUtils: RemoteConfigUtils
) {
    fun getLoginFeatureValueBoolean(featureKey: String): Boolean {
        return remoteConfigUtils.getFeatureValueBoolean(featureKey = featureKey)
    }

    fun getLoginFeatureValueString(): FeatureToggleLoginModel {
        remoteConfigUtils.getFeatureValueBoolean("")
        return remoteConfigUtils.getFeatureValueString(featureKey = KEY_FT_LOGIN_SCREEN).toFeatureToggleLoginModel()
    }

    companion object {
        private const val KEY_FT_LOGIN_SCREEN = "ft_clinicapp_login_screen"
    }
}

fun String?.toFeatureToggleLoginModel(): FeatureToggleLoginModel = try {
    Gson().fromJson(this, FeatureToggleLoginModel::class.java)
} catch (ex: Throwable) {
    FeatureToggleLoginModel()
}
