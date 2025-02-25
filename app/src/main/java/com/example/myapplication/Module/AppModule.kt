package com.example.myapplication.Module

import com.example.myapplication.util.QuestionApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent :: class)
object AppModule {
    @Singleton
    @Provides
    suspend fun ProvideQuestionApi(): QuestionApi{
        return Retrofit.Builder()
            .baseUrl(Constent.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionApi::class.java)
    }
}