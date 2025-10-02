package vn.edu.tlu.buicongson.football247_mobile.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepoImpl
import vn.edu.tlu.buicongson.football247_mobile.data.impl.NewsRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.NewsRepoImpl
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.login.LoginViewModel
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.news.NewsViewModel

val models = module {
    viewModel {
        LoginViewModel( get() )
    }

    viewModel {
        NewsViewModel(get() )
    }
}

val impls = module {
    single<LoginRepo> {
        LoginRepoImpl(
            get()
        )
    }

    single<NewsRepo> {
        NewsRepoImpl(
            get()
        )
    }
}

val modules = listOf(models, impls, networks)