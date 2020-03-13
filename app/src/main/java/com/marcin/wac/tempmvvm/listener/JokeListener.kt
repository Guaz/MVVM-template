package com.marcin.wac.tempmvvm.listener

import com.marcin.wac.tempmvvm.model.modelClass.JokeResponse

interface JokeListener {
    fun onStarted()
    fun onSuccess(jokeResponse: JokeResponse?)
    fun onFailure(message: String)
}