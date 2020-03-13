package com.marcin.wac.tempmvvm

import android.app.Application
import com.marcin.wac.tempmvvm.model.api.JokeAPI
import com.marcin.wac.tempmvvm.model.api.NetworkConnectionInterceptor
import com.marcin.wac.tempmvvm.model.repos.JokeRepository
import com.marcin.wac.tempmvvm.viewModel.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }

        bind() from singleton { JokeAPI(instance()) }
        bind() from singleton { JokeRepository(instance()) }


        bind() from provider { MainViewModelFactory(instance()) }
    }
}