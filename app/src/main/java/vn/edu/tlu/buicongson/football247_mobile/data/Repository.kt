package vn.edu.tlu.buicongson.football247_mobile.data

import retrofit2.http.Body
import retrofit2.http.POST
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.request.CheckPhone
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.LoginResponse
import kotlin.jvm.Throws

interface Service {
    @Throws(Exception::class)
    @POST("/api/Auth/Login")
    suspend fun checkPhone(@Body rq: CheckPhone) : LoginResponse?
}