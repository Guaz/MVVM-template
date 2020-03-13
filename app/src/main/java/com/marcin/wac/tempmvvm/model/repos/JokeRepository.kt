package com.marcin.wac.tempmvvm.model.repos

import com.marcin.wac.tempmvvm.model.api.JokeAPI
import com.marcin.wac.tempmvvm.model.api.SafeApiRequest
import com.marcin.wac.tempmvvm.model.modelClass.JokeResponse

class JokeRepository(private val jokeAPI: JokeAPI) : SafeApiRequest(){
    suspend fun fetchJokes(): JokeResponse {
        return apiRequest<JokeResponse> { jokeAPI.getJokes() }
    }
}