package vn.edu.tlu.buicongson.football247_mobile.data

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.CheckPhone
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.ArticleResponse
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CategoryResponse
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
}