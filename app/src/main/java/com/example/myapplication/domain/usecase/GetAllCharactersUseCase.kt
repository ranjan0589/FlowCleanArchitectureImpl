package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(private val repositoty:CharacterRepository) {

    operator fun invoke() =repositoty.getAllCharacters()
}