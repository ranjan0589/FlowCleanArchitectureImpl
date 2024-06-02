package com.example.myapplication.presentation.state

import com.example.myapplication.domain.model.Character

data class CharactersState(val charracters:List<Character>?= emptyList(), val errerMsg:String?="",
                           val isLoading:Boolean=false)
