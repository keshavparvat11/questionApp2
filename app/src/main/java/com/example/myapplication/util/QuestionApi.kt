package com.example.myapplication.util

import com.example.myapplication.questions.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("geography.json")
   fun getAllQuestions(): Question
}