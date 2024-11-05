package com.techtribeservices.flashnews.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techtribeservices.flashnews.data.response.NewsListResponse
import com.techtribeservices.flashnews.domain.repository.NewsRepository
import com.techtribeservices.flashnews.presentation.common.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel(){

    private val _uiState = MutableStateFlow<State<NewsListResponse>>(State.Loading)
    val state = _uiState as StateFlow<State<NewsListResponse>>

    init {
        getEveryNews()
    }

    // get all news
    fun getEveryNews() {
        viewModelScope.launch {
            _uiState.tryEmit(State.Loading)
            try {
                val result = newsRepository.getEverything()
                _uiState.tryEmit(State.Success(result))
            } catch (e: Exception) {
                _uiState.tryEmit(State.Error(e.message.toString()))
            }
        }
    }
}