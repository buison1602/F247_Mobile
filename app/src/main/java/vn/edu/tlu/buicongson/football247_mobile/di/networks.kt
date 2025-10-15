package vn.edu.tlu.buicongson.football247_mobile.di

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import vn.edu.tlu.buicongson.football247_mobile.constants.DatasourceProperties
import vn.edu.tlu.buicongson.football247_mobile.constants.DatasourceProperties.TIMEOUT_CONNECT
import vn.edu.tlu.buicongson.football247_mobile.constants.DatasourceProperties.TIMEOUT_READ
import vn.edu.tlu.buicongson.football247_mobile.constants.Tags
import vn.edu.tlu.buicongson.football247_mobile.data.Service

val networks = module {
    single {
        androidContext().getSharedPreferences(Tags.MY_APP, Context.MODE_PRIVATE)
    }
    single { AuthInterceptor(get()) }
    single { createOkHttpClient(get() ) }
    single { createRetrofit(get(), DatasourceProperties.getUrl()) }
    single { createApiService(get()) }
}

fun createOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .addInterceptor(authInterceptor)
        .build()
}

fun createRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
    val gson = GsonBuilder().setLenient().create()
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}

fun createApiService(retrofit: Retrofit): Service {
    return retrofit.create(Service::class.java)
}
