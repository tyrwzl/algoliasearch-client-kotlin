package com.algolia.search


expect object Time {

    fun getCurrentTimeMillis(): Long

    fun getCurrentTimeSeconds(): Long
}