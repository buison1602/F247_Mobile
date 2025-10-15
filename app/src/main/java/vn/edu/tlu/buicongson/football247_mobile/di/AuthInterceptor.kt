package vn.edu.tlu.buicongson.football247_mobile.di

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Response
import vn.edu.tlu.buicongson.football247_mobile.constants.Tags

class AuthInterceptor(private val sharedPref: SharedPreferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        val token = sharedPref.getString(Tags.JWT_TOKEN, null)

        // Nếu không có token, cứ gửi request gốc đi
        if (token.isNullOrEmpty()) {
            return chain.proceed(originalRequest)
        }

        // Nếu có token, tạo một request mới và thêm header Authorization
        val newRequest = originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(newRequest)
    }
}


