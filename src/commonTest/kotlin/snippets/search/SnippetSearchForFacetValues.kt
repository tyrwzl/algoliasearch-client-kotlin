package snippets.search

import com.algolia.search.helper.requestOptionsBuilder
import com.algolia.search.model.Attribute
import com.algolia.search.model.search.FacetValuesQuery
import com.algolia.search.model.search.Query
import io.ktor.client.features.ResponseException
import runBlocking
import shouldFailWith
import snippets.index
import kotlin.test.Test


internal class SnippetSearchForFacetValues {

//    suspend fun Index.searchForFacetValues(
//        #{attribute}: __Attribute__,
//        #{facetQuery}: __String__? = null,
//        #{query}: __Query?__ = null,
//        #{requestOptions}: __RequestOptions?__ = null
//    ): ResponseSearchForFacetValue
//
//    // any #{searchParameters} can be set on the Query object

    @Test
    fun example() {
        shouldFailWith<ResponseException> {
            runBlocking {
                val attribute = Attribute("category")
                val query = FacetValuesQuery(facetQuery = "phone")

                index.searchForFacetValues(attribute, query)
            }
        }
    }

    @Test
    fun exampleAdditional() {
        shouldFailWith<ResponseException> {
            runBlocking {
                val attribute = Attribute("category")
                val query = FacetValuesQuery(
                    facetQuery = "phone",
                    query = Query(filters = "brand:Apple")
                )

                index.searchForFacetValues(attribute, query)
            }
        }
    }

    @Test
    fun exampleExtraHeader() {
        shouldFailWith<ResponseException> {
            runBlocking {
                val attribute = Attribute("category")
                val query = FacetValuesQuery(
                    facetQuery = "phone",
                    query = Query(filters = "brand:Apple")
                )
                val requestOptions = requestOptionsBuilder {
                    header("X-Algolia-User-ID", "user123")
                }

                index.searchForFacetValues(attribute, query, requestOptions)
            }
        }
    }
}