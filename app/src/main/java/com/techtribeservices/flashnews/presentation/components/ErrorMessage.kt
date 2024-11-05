package com.techtribeservices.flashnews.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorMessage() {
    Text(text = "Error occurred",
        color = MaterialTheme.colorScheme.error)
}