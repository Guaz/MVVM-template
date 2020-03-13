package com.marcin.wac.tempmvvm.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marcin.wac.tempmvvm.listener.JokeListener
import com.marcin.wac.tempmvvm.model.modelClass.Joke
import com.marcin.wac.tempmvvm.model.repos.JokeRepository
import com.marcin.wac.tempmvvm.util.ApiException
import com.marcin.wac.tempmvvm.util.Coroutines
import com.marcin.wac.tempmvvm.util.NoInternetException
import com.marcin.wac.tempmvvm.util.Status

class MainViewModel(private val repository: JokeRepository): ViewModel() {
    var jokeListener: JokeListener? = null
    private var jokeList: List<Joke>? = null
    private val _jokes = MutableLiveData<List<Joke>>()
    val jokes: LiveData<List<Joke>>?
        get() = _jokes
    private val _status = MutableLiveData<Status>()
    val status : LiveData<Status>
        get() = _status

    fun onRandomClick(view: View){
        jokeListener?.onStarted()

        Coroutines.main {
            try {
                jokeList = repository.fetchJokes().value
                _status.value = Status.LOADING
                _jokes.value = jokeList
                _status.value = Status.DONE
            }
            catch (e : ApiException){
                _status.value = Status.ERROR
                jokeListener?.onFailure(e.message!!)
            }
            catch (e : NoInternetException){
                _status.value = Status.ERROR
                jokeListener?.onFailure(e.message!!)
            }
        }
    }


}