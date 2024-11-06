package com.techtribeservices.flashnews.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.techtribeservices.flashnews.data.response.NewsListResponse
import com.techtribeservices.flashnews.presentation.common.State
import com.techtribeservices.flashnews.presentation.components.ErrorMessage
import com.techtribeservices.flashnews.presentation.components.LoadingIndicator
import com.techtribeservices.flashnews.presentation.viewModel.HomeViewModel
import androidx.compose.ui.unit.dp
import com.techtribeservices.flashnews.presentation.components.NewsItemCard

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.state.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            when(uiState.value) {
                State.Loading -> LoadingIndicator()
                is State.Error -> ErrorMessage()
                is State.Success -> NewsList(uiState.value)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsList(newsList: State<NewsListResponse>) {
    val data = (newsList as State.Success).data
    val articles = data.articles ?: emptyList()

    LazyColumn(
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(articles,) { news ->
            NewsItemCard(news)
        }
    }
}



