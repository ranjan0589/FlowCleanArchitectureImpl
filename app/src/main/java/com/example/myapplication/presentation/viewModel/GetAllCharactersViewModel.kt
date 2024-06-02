package com.example.myapplication.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.common.Resource
import com.example.myapplication.domain.model.Character
import com.example.myapplication.domain.usecase.GetAllCharactersUseCase
import com.example.myapplication.presentation.state.CharactersState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class GetAllCharactersViewModel @Inject constructor(private val useCase: GetAllCharactersUseCase):ViewModel() {



    private val  _characterState = MutableStateFlow(CharactersState())

    val characterState :StateFlow<CharactersState>
        get() = _characterState

    init {
        getAllCharacters()
    }

    fun  getAllCharacters(){
        useCase().onEach {
   when(it){
       is Resource.Error -> {
           _characterState.value = CharactersState().copy(errerMsg = it.msg)
       }
       is Resource.Loading -> {
           _characterState.value = CharactersState().copy(isLoading = true)
       }
       is Resource.Success -> {
           _characterState.value = CharactersState().copy(charracters = it.data)

       }
   }

        }.launchIn(viewModelScope)
    }

}