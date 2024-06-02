package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName

data class Character(
    val actor: String,
    val id: String,
    val image: String,
    val name: String,
)