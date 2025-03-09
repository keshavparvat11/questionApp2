package com.example.myapplication.sceen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Data.DataOrException
import com.example.myapplication.Repository.QuestionRepository
import com.example.myapplication.questions.QuestionItem
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionVivemodel @Inject constructor(private val repository: QuestionRepository) : ViewModel() {
   val data: MutableState<DataOrException<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))



    val _subject = mutableStateOf("")

    fun setSubject(subject: String) {
        _subject.value = subject
        getAllQuestion(subject)
    }
    private fun getAllQuestion(subject :String){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestions(subject)
            if (data.value.data.toString().isNotEmpty()) {
                data.value.loading = false
                Log.d("ViewModel", "Questions fetched:")
            }
        }

    }
    fun getTotalQuestionCount() : Int {
        return data.value.data?.toMutableList()?.size!!
    }
}