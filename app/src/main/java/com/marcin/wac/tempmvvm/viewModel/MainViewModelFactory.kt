package com.marcin.wac.tempmvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marcin.wac.tempmvvm.model.repos.JokeRepository

class MainViewModelFactory (
    private val repository: JokeRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}