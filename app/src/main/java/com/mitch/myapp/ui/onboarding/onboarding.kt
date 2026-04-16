package com.mitch.myapp.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


private val route: Any
    get() {
        TODO()
    }
val navController: NavHostController
    @Composable
    get() = rememberNavController()

@Composable
fun OnboardingScreen(navController: NavHostController) {

    val pages = listOf(
        "Welcome to our App",
        "Track your activities",
        "Stay productive"
    )

    var currentPage by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = pages[currentPage], fontSize = 24.sp)

        Spacer(modifier = Modifier.height(30.dp))

        if (currentPage == pages.lastIndex) {

            Button(onClick = {
                navController.navigate(route)
            }) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                navController.navigate(route)
            }) {
                Text("Signup")
            }

        } else {
            Button(onClick = {
                currentPage++
            }) {
                Text("Next")
            }
        }
    }
}

private fun NavController.Companion.navigate(route: Any) {}
