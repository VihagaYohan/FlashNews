package com.techtribeservices.flashnews.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.techtribeservices.flashnews.data.response.NewsListResponse
import com.techtribeservices.flashnews.presentation.common.State
import com.techtribeservices.flashnews.presentation.components.ErrorMessage
import com.techtribeservices.flashnews.presentation.components.LoadingIndicator
import com.techtribeservices.flashnews.presentation.viewModel.HomeViewModel

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

@Composable
fun NewsList(newsList: State<NewsListResponse>) {
    val data = (newsList as State.Success).data

    Text(
        text = "News list goes here ${data.articles?.size}"
    )
}



