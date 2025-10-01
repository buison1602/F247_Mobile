package vn.edu.tlu.buicongson.football247_mobile.main

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import vn.edu.tlu.buicongson.football247_mobile.di.modules


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Dùng để Koin có thể ghi log, rất hữu ích khi debug
            androidLogger()
            // Cung cấp application context cho Koin
            androidContext(this@MainApplication)

            modules(modules)
        }
    }
}