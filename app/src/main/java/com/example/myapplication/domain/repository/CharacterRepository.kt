package com.example.myapplication.domain.repository

import com.example.myapplication.core.common.Resource
import com.example.myapplication.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {


     fun getAllCharacters():Flow<Resource<List<Character>>>;


}