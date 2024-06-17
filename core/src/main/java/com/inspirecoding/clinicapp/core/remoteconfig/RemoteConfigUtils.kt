package com.inspirecoding.clinicapp.core.remoteconfig

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.remoteconfig.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings

class RemoteConfigUtils {

    fun initFirebaseRemoteConfig(activity: Activity) {

        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0
        }

        Firebase.remoteConfig.setConfigSettingsAsync(configSettings)

        Firebase.remoteConfig.fetch(0)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    Firebase.remoteConfig.activate()
                        .addOnCompleteListener(activity) {
                            Log.e("FirebaseRemoteConfig", "Fetch Success")
                        }
                } else {
                    Log.e("FirebaseRemoteConfig", "Fetch failed: ${task.exception}")
                    Handler(Looper.getMainLooper()).postDelayed({
                        initFirebaseRemoteConfig(activity)
                    }, 5000)
                }
            }
    }

    fun getFeatureValueBoolean(featureKey: String): Boolean {
        return Firebase.remoteConfig.getBoolean(featureKey)
    }

    fun getFeatureValueString(featureKey: String): String {
        return Firebase.remoteConfig.getString(featureKey)
    }

}