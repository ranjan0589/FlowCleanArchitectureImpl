package com.example.myapplication.data.mapper

import com.example.myapplication.data.dto.CharactersDto
import com.example.myapplication.domain.model.Character

fun CharactersDto.toDomainCharacter() : Character{

    return Character(actor,id,image,name)
}