package com.tzikin.chucknorrisapi.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.tzikin.chucknorrisapi.repository.ChuckNorrisRepository
import com.tzikin.chucknorrisapi.repository.model.JokeResponse
import retrofit2.Response

class FirstFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var jokesList: MutableList<JokeResponse> = mutableListOf()
    var repository = ChuckNorrisRepository()

    suspend fun getJoke(): Response<JokeResponse>{
        return repository.getJoke()
    }
}