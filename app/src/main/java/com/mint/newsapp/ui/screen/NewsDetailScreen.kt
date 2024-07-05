package com.mint.newsapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun NewsDetailScreen(
    navController: NavController,
    title: String,
    description: String?,
    urlToImage: Int,
    author: String,
    publishedAt: String
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF00897B),
                contentColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier.weight(6f),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Details", color = Color.White, style = TextStyle(fontSize = 24.sp))
                    }
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                Image(
                    painter = painterResource(id = urlToImage),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(title, style = MaterialTheme.typography.h6, textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(description ?: "No description available", style = MaterialTheme.typography.body1)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("By $author", style = MaterialTheme.typography.body2)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Published at $publishedAt", style = MaterialTheme.typography.body2)
                }
            }
        }
    )
}