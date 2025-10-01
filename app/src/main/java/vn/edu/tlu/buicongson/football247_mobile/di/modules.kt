package vn.edu.tlu.buicongson.football247_mobile.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepo
import vn.edu.tlu.buicongson.football247_mobile.data.impl.LoginRepoIml
import vn.edu.tlu.buicongson.football247_mobile.ui.activities.login.LoginViewModel

val models = module {
    viewModel {
        LoginViewModel( get() )
    }
}

val impls = module {
    single<LoginRepo> {
        LoginRepoIml(
            get()
        )
    }
}

val modules = listOf(models, impls, networks)