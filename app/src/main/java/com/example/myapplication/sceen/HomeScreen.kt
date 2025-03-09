package com.example.myapplication.sceen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.util.AppColors
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(modifier = Modifier.fillMaxHeight(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "CodeQuizzer")
                        Spacer(Modifier.width(210.dp))
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notification"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(AppColors.mLightBlue),
                modifier = Modifier
                    .padding(top = 18.dp)
                    .height(60.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight().background(color = AppColors.mDarkPurple),
        containerColor = AppColors.mDarkPurple
    ) { innerPadding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(top = innerPadding.calculateTopPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = { navController.navigate("java") }) {
                Text("Java Questions")
            }
            Spacer(modifier = Modifier.height(85.dp))
            Button(onClick = { navController.navigate("compose") }) {
                Text("Compose Questions")
            }
            Spacer(modifier = Modifier.height(85.dp))
            Button(onClick = { navController.navigate("python") }) {
                Text("Python Questions")
            }
        }
    }
}