package com.techtribeservices.flashnews.data.web

import com.techtribeservices.flashnews.BuildConfig
import com.techtribeservices.flashnews.data.response.NewsListResponse
import com.techtribeservices.flashnews.utils.everything
import com.techtribeservices.flashnews.utils.topHeadlines
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET(everything)
    fun getEverything(
        @Query("country") country: String = "us",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response<NewsListResponse>

    @GET(topHeadlines)
    fun getTopHeadlines(): Response<NewsListResponse>
}