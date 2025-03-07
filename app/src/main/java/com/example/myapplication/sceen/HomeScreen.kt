package com.example.myapplication.sceen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate("java") }) {
            Text("Java Questions")
        }
        Button(onClick = { navController.navigate("compose") }) {
            Text("Compose Questions")
        }
        Button(onClick = { navController.navigate("python") }) {
            Text("Python Questions")
        }
    }
}