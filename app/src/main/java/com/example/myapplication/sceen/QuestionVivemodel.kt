package com.example.myapplication.sceen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.Data.DataOrException
import com.example.myapplication.Repository.QuestionRepository
import com.example.myapplication.questions.QuestionItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionVivemodel @Inject constructor(
    private val repository: QuestionRepository) : ViewModel() {
   val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))
    init {
        getAllQuestion()
    }
    private fun getAllQuestion(){
        data.value.loading = true
        data.value = repository.getAllQuestions()
        if(data.value.data.toString().isNotEmpty()) data.value.loading = false

    }
}