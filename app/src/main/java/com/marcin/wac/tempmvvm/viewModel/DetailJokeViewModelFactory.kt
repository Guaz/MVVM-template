package com.marcin.wac.tempmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marcin.wac.tempmvvm.model.repos.JokeRepository

class DetailJokeViewModelFactory (private val repository: JokeRepository):
        ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailJokeViewModel(repository) as T
    }
}