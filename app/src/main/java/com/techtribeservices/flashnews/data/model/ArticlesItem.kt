package com.techtribeservices.flashnews.data.model

data class ArticlesItem(val publishedAt: String = "",
                        val author: String = "",
                        val urlToImage: String? = null,
                        val description: String? = null,
                        val source: Source,
                        val title: String = "",
                        val url: String = "",
                        val content: String? = null)