package com.nbs.adsionsemarang.di.module.feature

import com.nbs.adsionsemarang.domain.main.MainInteractor
import com.nbs.adsionsemarang.presentation.main.MainContract
import com.nbs.adsionsemarang.presentation.main.MainPresenter
import org.koin.dsl.module.module

val mainModule = module {
    single { MainInteractor(get()) }

    factory{ (view: MainContract.View) -> MainPresenter(get(), view) }
}