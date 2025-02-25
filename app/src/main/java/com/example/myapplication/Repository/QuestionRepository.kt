package com.example.myapplication.Repository

import com.example.myapplication.Data.DataOrException
import com.example.myapplication.questions.QuestionItem
import com.example.myapplication.util.QuestionApi
import javax.inject.Inject


class QuestionRepository @Inject constructor(private val api: QuestionApi)  {
    private val questionList  = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

}