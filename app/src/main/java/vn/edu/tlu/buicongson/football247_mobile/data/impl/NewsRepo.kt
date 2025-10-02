package vn.edu.tlu.buicongson.football247_mobile.data.impl

import vn.edu.tlu.buicongson.football247_mobile.data.Service
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.ArticleResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CategoryResponse

interface NewsRepo {
    suspend fun getCategories() : List<CategoryResponse>?

    suspend fun getArticles() : List<ArticleResponse>?
}

class NewsRepoImpl(val service: Service) : NewsRepo {
    override suspend fun getCategories(): List<CategoryResponse>? = service.getCategories()

    override suspend fun getArticles(): List<ArticleResponse>? = service.getArticles()
}