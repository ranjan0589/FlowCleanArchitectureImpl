package com.example.myapplication.presentation.navigation

sealed class Screen(val route:String) {
    object CharacterScreen : Screen("charcter_screen")
}