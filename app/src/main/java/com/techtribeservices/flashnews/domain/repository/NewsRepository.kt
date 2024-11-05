package com.techtribeservices.flashnews.domain.repository

import com.techtribeservices.flashnews.data.response.NewsListResponse
import com.techtribeservices.flashnews.data.web.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApi: NewsApi) {

    suspend fun getEverything(): NewsListResponse {
        val response = newsApi.getEverything()
        if(response.isSuccessful && response.body() != null) {

        }
        return response.body()!!
    }
}