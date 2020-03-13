package com.marcin.wac.tempmvvm.model.api

import com.marcin.wac.tempmvvm.listener.Constant
import com.marcin.wac.tempmvvm.model.modelClass.JokeResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface JokeAPI {

    @GET("/jokes/random/15")
    suspend fun getJokes() : Response<JokeResponse>

    @GET("/jokes/{id}")
    suspend fun getJokeById(@Path("id") jokeId: String) : Response<JokeResponse>

    companion object{
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor
        ): JokeAPI {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokeAPI::class.java)
        }
    }
}