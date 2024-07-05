package com.mint.newsapp.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NewsApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "news_list") {
        composable("news_list") { NewsListScreen(navController) }
        composable(
            route = "detail/{title}/{description}/{urlToImage}/{author}/{publishedAt}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("urlToImage") { type = NavType.IntType },
                navArgument("author") { type = NavType.StringType },
                navArgument("publishedAt") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            NewsDetailScreen(
                navController = navController,
                title = backStackEntry.arguments?.getString("title") ?: "",
                description = backStackEntry.arguments?.getString("description"),
                urlToImage = backStackEntry.arguments?.getInt("urlToImage") ?: 0,
                author = backStackEntry.arguments?.getString("author") ?: "",
                publishedAt = backStackEntry.arguments?.getString("publishedAt") ?: ""
            )
        }
    }
}
