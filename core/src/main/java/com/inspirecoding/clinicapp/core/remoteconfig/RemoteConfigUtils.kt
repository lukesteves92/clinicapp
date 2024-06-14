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

    fun getFeatureValueBoolean(featureKey: String): Boolean {
        var result: Boolean = false
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    result = firebaseRemoteConfig.getBoolean("teste_bool")
                }
            }
        return result
    }

    fun getFeatureValueString(featureKey: String): String {
        var result: String = ""
        firebaseRemoteConfig.fetchAndActivate()
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    result = firebaseRemoteConfig.getString(featureKey)
                }
            }
        return result
    }
}