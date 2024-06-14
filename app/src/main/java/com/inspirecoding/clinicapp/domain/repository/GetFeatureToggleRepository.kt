package com.inspirecoding.clinicapp.domain.repository

import com.inspirecoding.clinicapp.domain.models.FeatureToggleLoginModel

interface GetFeatureToggleRepository {
    fun getFeatureToggleValueBoolean(featureKey: String): Boolean
    fun <T : Any> getFeatureToggleValueString(featureKey: String, clazz: T): T
}