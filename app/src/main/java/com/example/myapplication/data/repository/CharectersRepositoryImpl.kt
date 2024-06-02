package com.example.myapplication.data.repository

import com.example.myapplication.core.common.Resource
import com.example.myapplication.data.api.CharacterApi
import com.example.myapplication.data.mapper.toDomainCharacter
import com.example.myapplication.domain.model.Character
import com.example.myapplication.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class CharectersRepositoryImpl  @Inject constructor(private val characterApi:CharacterApi) : CharacterRepository {
    override  fun getAllCharacters(): Flow<Resource<List<Character>>> = flow {
      emit(Resource.Loading())
        val result= characterApi.getCharacters().map {


            it.toDomainCharacter()
        }
        emit(Resource.Success(result))


    }.flowOn(Dispatchers.IO).catch {

        emit(Resource.Error(it.message.toString()))
    }


}