package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.Data.DataOrException
import com.example.myapplication.questions.QuestionItem
import com.example.myapplication.util.QuestionApi
import javax.inject.Inject


class QuestionRepository @Inject constructor(private val api: QuestionApi)  {
    private val questionList  = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()


    suspend fun getAllQuestions(subject :String): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
          try {
              questionList.loading = true
              questionList.data = api.getAllQuestions(subject)
              if (questionList.data.toString().isNotEmpty()) questionList.loading = false
          }catch (exception: Exception){
              questionList.exception = exception
              questionList.loading = false
              Log.e("API_ERROR", "Failed to fetch questions: ", exception)
          }
        return questionList
    }

}