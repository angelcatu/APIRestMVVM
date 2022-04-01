package com.tzikin.chucknorrisapi.repository

import com.tzikin.chucknorrisapi.repository.model.JokeResponse
import retrofit2.Response

class ChuckNorrisRepository {

    suspend fun getJoke(): Response<JokeResponse>{
        return ChuckNorrisService.create().getJoke()
    }

}