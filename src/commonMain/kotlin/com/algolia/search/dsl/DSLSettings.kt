package com.algolia.search.dsl

import com.algolia.search.dsl.attributes.DSLAttributes
import com.algolia.search.dsl.attributes.DSLAttributesForFaceting
import com.algolia.search.dsl.attributes.DSLAttributesToRetrieve
import com.algolia.search.dsl.attributes.DSLSearchableAttributes
import com.algolia.search.dsl.ranking.DSLCustomRanking
import com.algolia.search.dsl.ranking.DSLRanking
import com.algolia.search.dsl.ranking.DSLReplicas
import com.algolia.search.model.settings.Settings


public fun settings(init: Settings.() -> Unit) = Settings().apply(init)

public fun Settings.attributesToRetrieve(block: DSLAttributesToRetrieve.() -> Unit) {
    attributesToRetrieve = DSLAttributesToRetrieve().apply(block).build()
}

public fun Settings.searchableAttributes(block: DSLSearchableAttributes.() -> Unit) {
    searchableAttributes = DSLSearchableAttributes().apply(block).build()
}

public fun Settings.attributesForFaceting(block: DSLAttributesForFaceting.() -> Unit) {
    attributesForFaceting = DSLAttributesForFaceting().apply(block).build()
}

public fun Settings.unretrieveableAttributes(block: DSLAttributes.() -> Unit) {
    unretrievableAttributes = DSLAttributes().apply(block).build()
}

public fun Settings.ranking(block: DSLRanking.() -> Unit) {
    ranking = DSLRanking().apply(block).build()
}

public fun Settings.customRanking(block: DSLCustomRanking.() -> Unit) {
    customRanking = DSLCustomRanking().apply(block).build()
}

public fun Settings.replicas(block: DSLReplicas.() -> Unit) {
    replicas = DSLReplicas().apply(block).build()
}