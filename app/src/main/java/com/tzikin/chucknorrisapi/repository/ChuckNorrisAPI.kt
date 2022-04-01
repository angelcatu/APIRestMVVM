package com.tzikin.chucknorrisapi.repository

import com.tzikin.chucknorrisapi.repository.model.JokeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChuckNorrisAPI {

    @GET("random")
    suspend fun getJoke(): Response<JokeResponse>
}