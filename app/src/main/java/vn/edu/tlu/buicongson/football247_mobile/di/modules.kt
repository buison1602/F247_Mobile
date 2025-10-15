package vn.edu.tlu.buicongson.football247_mobile.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.edu.tlu.buicongson.football247_mobile.data.impl.CommentRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.CommentRepoImpl
import vn.edu.tlu.buicongson.football247_mobile.data.impl.DetailArticleRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.DetailArticleRepoImpl
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepoImpl
import vn.edu.tlu.buicongson.football247_mobile.data.impl.NewsRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.NewsRepoImpl
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.detailArticle.DetailArticleViewModel
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.login.LoginViewModel
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.news.NewsViewModel

val models = module {
    viewModel {
        LoginViewModel( get(), get() )
    }

    viewModel {
        NewsViewModel(get() )
    }

    viewModel {
        DetailArticleViewModel(get(), get() )
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

    single<DetailArticleRepo> {
        DetailArticleRepoImpl(
            get()
        )
    }

    single<CommentRepo> {
        CommentRepoImpl(
            get()
        )
    }
}

val modules = listOf(models, impls, networks)