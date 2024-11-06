package com.techtribeservices.flashnews.data.mock

import com.techtribeservices.flashnews.data.model.ArticlesItem
import com.techtribeservices.flashnews.data.model.Source
import com.techtribeservices.flashnews.data.response.NewsListResponse

val EveryThingData: NewsListResponse = NewsListResponse(
    status = "ok",
    totalResults = 7220,
    articles = listOf(ArticlesItem(
        "2024-10-09T01:00:00Z",
        "Joel Khalili",
        "https://media.wired.com/photos/6703eb3979f13fda7f04485b/191:100/w_1280,c_limit/Satoshi-Nakamoto-biz-1341874258.jpg",
        "A new HBO documentary takes a swing at uncovering the real identity of Satoshi Nakamoto, inventor of Bitcoin. But without incontrovertible proof, the myth lives on.",
        Source(
            "wired",
            "Wired"
        ),
        "Unmasking Bitcoin Creator Satoshi Nakamoto—Again",
        url = "https://www.wired.com/story/unmasking-bitcoin-creator-satoshi-nakamoto-again/",
        content = "Peter Todd is standing on the upper floor of a dilapidated industrial building somewhere in Czechia, chuckling under his breath. He has just been accused on camera of being Satoshi Nakamoto, the Bitc… [+3043 chars]"
    ))
)