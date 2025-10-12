package vn.edu.tlu.buicongson.football247_mobile.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.CheckPhone
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.ArticleResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CategoryResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CommentResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.DetailArticleResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.LoginResponse
import kotlin.jvm.Throws

interface Service {
    @Throws(Exception::class)
    @POST("/api/Auth/Login")
    suspend fun checkPhone(@Body rq: CheckPhone) : LoginResponse?

    @Throws(Exception::class)
    @GET("/api/Category")
    suspend fun getCategories() : List<CategoryResponse>?

    @Throws(Exception::class)
    @GET("/api/Article")
    suspend fun getArticles() : List<ArticleResponse>?

    @Throws(Exception::class)
    @GET("/api/Article/list/{articleSlug}")
    suspend fun getArticleBySlug(@Path("articleSlug") articleSlug: String) : DetailArticleResponse?

    @Throws(Exception::class)
    @GET("/api/Comment/{articleId}")
    suspend fun getCommentsByArticleId(@Path("articleId") articleId: String) : List<CommentResponse>?
}