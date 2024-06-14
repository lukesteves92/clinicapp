package com.inspirecoding.clinicapp.domain.usecase

import com.inspirecoding.clinicapp.domain.repository.GetFeatureToggleRepository

class GetFeatureToggleUseCase(
    private val getFeatureToggleRepository: GetFeatureToggleRepository
) {
    fun getFeatureToggleValueBoolean(featureKey: String): Boolean = getFeatureToggleRepository.getFeatureToggleValueBoolean(featureKey = featureKey)
    fun <T : Any> getFeatureToggleValueString(featureKey: String, clazz: T): T = getFeatureToggleRepository.getFeatureToggleValueString(featureKey = featureKey, clazz = clazz)
}