package com.techtribeservices.flashnews.data.response

import com.techtribeservices.flashnews.data.model.ArticlesItem

data class NewsListResponse(val totalResults: Int = 0,
                            val articles: List<ArticlesItem>?,
                            val status: String = "")