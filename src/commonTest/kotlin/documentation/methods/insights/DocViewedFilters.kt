package documentation.methods.insights

import clientInsights
import com.algolia.search.dsl.filtering.Filter
import com.algolia.search.model.Attribute
import com.algolia.search.model.IndexName
import com.algolia.search.model.insights.EventName
import com.algolia.search.model.insights.UserToken
import runBlocking
import kotlin.test.Test


internal class DocViewedFilters {

//    suspend fun ClientInsights.User.viewedFilters(
//        #{indexName}: __IndexName__,
//        #{eventName}: __EventName__,
//        #{filters}: __List<Filter.Facet>__,
//        timestamp: __Long?__ = null
//    ): HttpResponse

    @Test
    fun viewedFilters() {
        runBlocking {
            val userToken = UserToken("user-id")

            clientInsights.User(userToken).viewedFilters(
                indexName = IndexName("indexName"),
                eventName = EventName("eventName"),
                filters = listOf(Filter.Facet(Attribute("brand"), "apple"))
            )
        }
    }
}