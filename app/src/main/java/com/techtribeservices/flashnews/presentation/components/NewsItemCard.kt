package com.techtribeservices.flashnews.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.techtribeservices.flashnews.data.model.ArticlesItem
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewsItemCard(newsItem: ArticlesItem) {
    Card(
        modifier = Modifier
            .height(200.dp)
    ) {

        Box(modifier = Modifier) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(newsItem.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            // title
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = newsItem.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(10.dp)
                )
            }

            // author and published date
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomStart
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Black.copy(alpha = 0.5f)),

                ) {
                    CardFooter(newsItem.publishedAt, newsItem.author, newsItem.source.name)
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CardFooter(publishedDate: String,
               author: String,
               source: String) {
    // Parse the ISO date string to ZonedDateTime
    val parsedDate = ZonedDateTime.parse(publishedDate)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            CardFooterItem(
                "By: $author",
                Icons.Filled.Person,
                "Author"
            )

            Text(
                text = "Source: $source",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }

        CardFooterItem(
            parsedDate.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")),
            Icons.Filled.CalendarMonth,
            "Published date"
        )
    }
}

@Composable
fun CardFooterItem(footerTitle: String,
                   iconName: ImageVector,
                   imageContentDescription: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = iconName,
            contentDescription = imageContentDescription,
            tint = Color.White,
            modifier = Modifier
                .padding(end = 5.dp)
        )

        Text(
            text = footerTitle,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}