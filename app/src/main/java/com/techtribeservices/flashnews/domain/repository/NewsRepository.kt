package com.techtribeservices.flashnews.domain.repository

import com.techtribeservices.flashnews.data.response.NewsListResponse
import com.techtribeservices.flashnews.data.web.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi) {

    suspend fun getEverything(): NewsListResponse {
        val response = newsApi.getEverything()
        if(response.body() != null) {
            when(response.code()) {
                400 -> throw Exception("Bad request")
                401 -> throw Exception("Unauthorized")
                404 -> throw Exception("There are no news found")
                500 -> throw Exception("Something went wrong\nTry again later")
            }
        }
        return response.body()!!
    }
}