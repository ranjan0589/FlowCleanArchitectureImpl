package com.example.myapplication.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.presentation.state.CharactersState
import dagger.Component

@Composable
fun CharactersScreen(modifier: Modifier,charactersState: CharactersState) {
   if(charactersState.isLoading){
       Box(modifier = modifier.fillMaxSize()){
           CircularProgressIndicator(modifier = modifier.align(Alignment.Center))
       }
   }else if (charactersState.errerMsg.isNullOrEmpty()){
       Box(modifier= modifier.fillMaxSize()) {
           Text(
               text = charactersState.errerMsg.toString(),
               modifier = modifier.align(Alignment.Center)
           )
       }
   }

    if (charactersState.charracters?.isNotEmpty()!!){
        LazyColumn {

            items(charactersState.charracters){
                CharactersItem(modifier = modifier, character = it)

            }
        }
    }

}