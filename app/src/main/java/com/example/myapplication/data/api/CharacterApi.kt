package com.example.myapplication.data.api

import com.example.myapplication.data.dto.CharactersDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun  getCharacters():List<CharactersDto>
}