package com.mint.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mint.newsapp.R
import com.mint.newsapp.data.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> get() = _articles

    init {
        fetchMockNews()
    }

    private fun fetchMockNews() {
        viewModelScope.launch {
            val mockArticles = listOf(
                Article(
                    title = "Tranquil Sunset Over Serene Landscape",
                    description = "\t\tThis image captures the serene beauty of a tranquil landscape at dusk. The sky is painted in soft hues of orange and pink, reflecting the last light of the setting sun. Silhouetted against this colorful backdrop are bare trees, their branches reaching upwards in delicate patterns. In the distance, hazy mountains rise, adding depth and majesty to the scene.\n\t\tThe stillness of the water in the foreground mirrors the sky and trees perfectly, creating a harmonious and peaceful composition. The gentle transition of colors and the calm atmosphere evoke a sense of quiet reflection and natural beauty, making it a perfect moment frozen in time.",
                    url = "https://example.com/1",
                    urlToImage = R.drawable.image_1,
                    author = "Author 1",
                    publishedAt = "Dec 07, 03:04"
                ),
                Article(
                    title = "The Vibrant Beauty of a Pineapple",
                    description = "\t\tThis close-up image captures the vibrant and intricate details of a pineapple. The fruit's tough, textured skin forms a geometric pattern of interlocking segments, each adorned with small spikes and subtle variations in color, ranging from green to golden brown. The crown of the pineapple, with its thick, green leaves, rises majestically from the top, adding a touch of tropical elegance.\n\t\tThe background, a soft, muted peach color, perfectly complements the rich tones of the pineapple, allowing the fruit's natural beauty to stand out. The photograph highlights the pineapple's unique structure and the complexity of its design, making it a visually striking representation of this beloved tropical fruit. The close-up perspective invites viewers to appreciate the pineapple's intricate details and the artistry of nature.",
                    url = "https://example.com/2",
                    urlToImage = R.drawable.image_2,
                    author = "Author 2",
                    publishedAt = "Dec 07, 03:00"
                )
            )
            _articles.value = mockArticles
        }
    }
}
