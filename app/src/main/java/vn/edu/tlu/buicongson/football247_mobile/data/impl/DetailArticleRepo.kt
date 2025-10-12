package vn.edu.tlu.buicongson.football247_mobile.data.impl

import vn.edu.tlu.buicongson.football247_mobile.data.Service
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.ArticleResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CommentResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.DetailArticleResponse


interface DetailArticleRepo {
    suspend fun getArticleBySlug(slug: String) : DetailArticleResponse?

    suspend fun getCommentsByArticleId(articleId: String) : List<CommentResponse>?
}

class DetailArticleRepoImpl(val service: Service) : DetailArticleRepo {
    override suspend fun getArticleBySlug(slug: String): DetailArticleResponse? = service.getArticleBySlug(slug)

    override suspend fun getCommentsByArticleId(articleId: String): List<CommentResponse>? = service.getCommentsByArticleId(articleId)
}