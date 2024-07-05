package com.mint.newsapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mint.newsapp.data.model.Article
import com.mint.newsapp.viewmodel.NewsViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewsListScreen(navController: NavController, viewModel: NewsViewModel = viewModel()) {

    var query by remember { mutableStateOf("") }
    val articles by viewModel.articles.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color(0xFF00897B),
                contentColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("News", color = Color.White, style = TextStyle(fontSize = 24.sp))
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = query,
                    onValueChange = { query = it },
                    label = { Text("Search") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                    }
                )
                LazyColumn {
                    items(articles.filter {
                        it.title.contains(query, ignoreCase = true) ||
                                it.description?.contains(query, ignoreCase = true) == true
                    }) { article ->
                        NewsItem(article) {
                            navController.navigate("detail/${article.title}/${article.description}/${article.urlToImage}/${article.author}/${article.publishedAt}")
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun NewsItem(article: Article, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)

        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center // จัดกึ่งกลางแนวนอน
            ) {
                Image(
                    painter = painterResource(id = article.urlToImage),
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(article.title, style = MaterialTheme.typography.h6, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(8.dp))
            Text(article.description ?: "No description available", style = MaterialTheme.typography.body2, maxLines = 3, overflow = TextOverflow.Ellipsis)
        }
    }
}
