package com.techtribeservices.flashnews.presentation.common

sealed class State<out T> {
    object Loading: State<Nothing>()
    class Success<T>(data: T): State<T>()
    class Error(val message: String): State<Nothing>()
}