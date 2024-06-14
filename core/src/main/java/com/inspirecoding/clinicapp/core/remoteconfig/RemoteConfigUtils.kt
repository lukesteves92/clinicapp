package com.inspirecoding.clinicapp.core.remoteconfig

import android.app.Activity
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings


class RemoteConfigUtils {

    private lateinit var firebaseRemoteConfig: FirebaseRemoteConfig
    private lateinit var activity: Activity

    fun initFirebaseRemoteConfig(activity: Activity) {
        this.activity = activity
        firebaseRemoteConfig = Firebase.remoteConfig

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }

    fun getFeatureValueBoolean(featureKey: String): Boolean = firebaseRemoteConfig.getBoolean(featureKey)

    fun getFeatureValueString(featureKey: String): String = firebaseRemoteConfig.getString(featureKey)

}