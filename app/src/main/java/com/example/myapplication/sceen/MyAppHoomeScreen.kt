package com.example.myapplication.sceen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.component.Questions

@Composable
fun MyApp(viewMode: QuestionVivemodel = hiltViewModel()){
    Questions(viewMode)
}