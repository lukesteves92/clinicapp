package com.inspirecoding.clinicapp.domain.repository.toggle

interface GetFeatureToggleRepository {
    fun getFeatureToggleValueBoolean(featureKey: String): Boolean
    fun <T : Any> getFeatureToggleValueString(featureKey: String, clazz: T): T
}