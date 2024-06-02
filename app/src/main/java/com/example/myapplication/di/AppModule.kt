package com.example.myapplication.di

import com.example.myapplication.core.utils.Constant.baseUrl
import com.example.myapplication.data.api.CharacterApi
import com.example.myapplication.data.repository.CharectersRepositoryImpl
import com.example.myapplication.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
class AppModule {


    @Provides
    @Singleton
    fun provideRetrofitInstance() : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    @Provides
    @Singleton
    fun provideCharactersApi(retrofit: Retrofit):
            CharacterApi=retrofit.create(CharacterApi::class.java)


    @Provides
    @Singleton
    fun provideCharcterReposetiry(api: CharacterApi)
    :CharacterRepository{
        return CharectersRepositoryImpl(api)
    }
}