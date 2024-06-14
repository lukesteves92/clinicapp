package com.inspirecoding.clinicapp.data.repository

import com.google.gson.Gson
import com.inspirecoding.clinicapp.core.remoteconfig.RemoteConfigUtils
import com.inspirecoding.clinicapp.domain.repository.GetFeatureToggleRepository

class GetFeatureToggleImpl(
    private val remoteConfigUtils: RemoteConfigUtils
) : GetFeatureToggleRepository {
    override fun getFeatureToggleValueBoolean(featureKey: String): Boolean {
        return remoteConfigUtils.getFeatureValueBoolean(featureKey = featureKey)
    }

    override fun <T : Any> getFeatureToggleValueString(featureKey: String, clazz: T): T {
        val jsonValue = remoteConfigUtils.getFeatureValueString(featureKey = featureKey)
        return jsonValue.toFeatureToggleModel(clazz)
    }

    private fun <T : Any> String?.toFeatureToggleModel(clazz: T): T {
        return try {
            Gson().fromJson(this, clazz::class.java)
        } catch (ex: Throwable) {
            clazz
        }
    }
}