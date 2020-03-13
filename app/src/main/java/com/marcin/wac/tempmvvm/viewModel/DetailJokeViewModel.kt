package com.marcin.wac.tempmvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcin.wac.tempmvvm.model.modelClass.Joke
import com.marcin.wac.tempmvvm.model.repos.JokeRepository
import com.marcin.wac.tempmvvm.util.Status

class DetailJokeViewModel(private val repository: JokeRepository) : ViewModel(){
    private val _status = MutableLiveData<Status>()
    val status: LiveData<Status>
        get() = _status

    private val _joke = MutableLiveData<Joke>()
    val joke: LiveData<Joke>
        get() = _joke

    suspend fun getJokeDetails(id: String) {


    }
}