package com.algolia.search.endpoint

import com.algolia.search.client.RequestOptions
import com.algolia.search.model.IndexName
import com.algolia.search.model.settings.Settings
import com.algolia.search.model.settings.SettingsKey
import com.algolia.search.model.settings.SettingsResponse


interface EndpointSettings {

    val indexName: IndexName

    suspend fun getSettings(requestOptions: RequestOptions? = null): Settings

    suspend fun setSettings(
        settings: Settings,
        resetToDefault: List<SettingsKey> = listOf(),
        forwardToReplicas: Boolean? = null,
        requestOptions: RequestOptions? = null
    ): SettingsResponse.Update

    suspend fun copySettings(destination: IndexName, requestOptions: RequestOptions? = null): SettingsResponse.Update
}