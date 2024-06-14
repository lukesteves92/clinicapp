package com.inspirecoding.clinicapp.core.remoteconfig

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings


class RemoteConfigUtils {

    private val firebaseRemoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun getFeatureValueBoolean(featureKey: String): Boolean = firebaseRemoteConfig.getBoolean(featureKey)

    fun getFeatureValueString(featureKey: String): String = firebaseRemoteConfig.getString(featureKey)

}