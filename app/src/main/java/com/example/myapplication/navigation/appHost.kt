package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.sceen.HomeScreen
import com.example.myapplication.sceen.MyApp
import com.example.myapplication.sceen.QuestionVivemodel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("java") { QuestionScreen("java") }
        composable("compose") { QuestionScreen("compose") }
        composable("python") { QuestionScreen("python") }
    }
}

@Composable
fun QuestionScreen(subject: String) {
    val viewModel: QuestionVivemodel = hiltViewModel()
    viewModel.setSubject(subject)
    MyApp(viewModel)
}