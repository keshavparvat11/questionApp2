package com.example.myapplication.util

import com.example.myapplication.questions.Question
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("{subject}.json")
  suspend fun getAllQuestions(@Path("subject") subject: String): Question
}