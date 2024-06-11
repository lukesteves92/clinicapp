package com.inspirecoding.clinicapp.features.login.featuretoggle

import com.google.gson.Gson
import com.inspirecoding.clinicapp.data.util.RemoteConfigUtils
import com.inspirecoding.clinicapp.domain.models.FeatureToggleLoginModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class GetFeatureToggleLogin(
    private val remoteConfigUtils: RemoteConfigUtils
) {
    fun getLoginFeatureValueBoolean(featureKey: String, defaultValue: Boolean): Flow<Boolean> {
        return flow {
            emit(remoteConfigUtils.getFeatureValueBoolean(featureKey = featureKey, defaultValue))
        }
    }

    fun getLoginFeatureValueString(featureKey: String, defaultValue: String): Flow<FeatureToggleLoginModel> {
        return flow {
            emit(remoteConfigUtils.getFeatureValueString(featureKey = featureKey, defaultValue).toFeatureToggleLoginModel())
        }
    }
}

fun String?.toFeatureToggleLoginModel(): FeatureToggleLoginModel = try {
    Gson().fromJson(this, FeatureToggleLoginModel::class.java)
} catch (ex: Throwable) {
    FeatureToggleLoginModel()
}