package vn.edu.tlu.buicongson.football247_mobile.networks.entities.news

import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.ArticleResponse

sealed class News {
    data class FirstArticle (val article: ArticleResponse) : News()
    data class NormalArticle (val article: ArticleResponse) : News()
}