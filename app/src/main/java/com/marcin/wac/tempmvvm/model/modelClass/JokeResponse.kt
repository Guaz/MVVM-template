package com.marcin.wac.tempmvvm.model.modelClass

data class JokeResponse(val type: String, val value: List<Joke>)

data class Joke(val id: Long, val joke: String, val categories: List<String>){
    val idString
        get() = id.toString()
}