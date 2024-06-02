package com.example.myapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.components.CharactersScreen
import com.example.myapplication.presentation.state.CharactersState
import com.example.myapplication.presentation.viewModel.GetAllCharactersViewModel

@Composable
fun Navigation(){

     val navController= rememberNavController()
     NavHost(navController = navController, startDestination = Screen.CharacterScreen.route){
          composable(Screen.CharacterScreen.route) {
               val characterViewModel = hiltViewModel<GetAllCharactersViewModel>()
               val characterState = characterViewModel.characterState.collectAsStateWithLifecycle().value
              CharactersScreen(modifier = Modifier, charactersState = characterState)
          }
     }

}