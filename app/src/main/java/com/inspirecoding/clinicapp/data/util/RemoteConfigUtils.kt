package com.inspirecoding.clinicapp.data.util

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.firebase.remoteconfig.ktx.remoteConfig
import kotlinx.coroutines.tasks.await


class RemoteConfigUtils {

    private val firebaseRemoteConfig: FirebaseRemoteConfig = Firebase.remoteConfig

    init {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()

        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
    }
    suspend fun getFeatureValueBoolean(featureKey: String, defaultValue: Boolean): Boolean {
        return try {
            firebaseRemoteConfig.fetchAndActivate().await()
            firebaseRemoteConfig.getBoolean(featureKey)
        } catch (e: Exception) {
            Log.e("RemoteConfigUtils", "Erro ao buscar valor da feature: $featureKey", e)
            throw Exception()
        }
    }

    suspend fun getFeatureValueString(featureKey: String, defaultValue: String): String {
        return try {
            firebaseRemoteConfig.fetchAndActivate().await()
            firebaseRemoteConfig.getString(featureKey)
        } catch (e: Exception) {
            Log.e("RemoteConfigUtils", "Erro ao buscar valor da feature: $featureKey", e)
            throw Exception()
        }
    }
}