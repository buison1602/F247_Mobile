package vn.edu.tlu.buicongson.football247_mobile.ui.activities.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vn.edu.tlu.buicongson.football247_mobile.data.impl.NewsRepo
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.ArticleResponse
import vn.edu.tlu.buicongson.football247_mobile.mappers.toCategoryWrapper
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.Category

class NewsViewModel (val newsRepo: NewsRepo) : ViewModel() {

    fun getArticles(onComplete: ((success: List<ArticleResponse>) -> Unit)?) {
        viewModelScope.launch {
            val response = newsRepo.getArticles()

            if (response != null) {
                onComplete?.invoke(response)
            }
        }
    }

    fun getCategories(onComplete: ((success: List<Category>) -> Unit)?) {
        viewModelScope.launch {
            val response = newsRepo.getCategories()

            if (response != null) {
                val wrappedCategories = response.map { it.toCategoryWrapper() }

                onComplete?.invoke(wrappedCategories)
            }
        }
    }

}