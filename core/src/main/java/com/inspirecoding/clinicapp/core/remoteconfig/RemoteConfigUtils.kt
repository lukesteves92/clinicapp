package com.inspirecoding.clinicapp.core.remoteconfig

import android.app.Activity
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings


class RemoteConfigUtils(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
) {

    fun initFirebaseRemoteConfig(activity: Activity) {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)

        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener(activity) {}
    }

    fun getFeatureValueBoolean(featureKey: String): Boolean = firebaseRemoteConfig.getBoolean(featureKey)

    fun getFeatureValueString(featureKey: String): String = firebaseRemoteConfig.getString(featureKey)

}