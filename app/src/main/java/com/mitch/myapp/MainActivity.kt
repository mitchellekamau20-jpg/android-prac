@file:Suppress("ComposePreviewMustBeTopLevelFunction")

package com.mitch.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.mitch.myapp.ui.Login.LoginScreen
import com.mitch.myapp.ui.authentication.signup.SignupScreen
import com.mitch.myapp.ui.onboarding.OnboardingScreen
import com.mitch.myapp.ui.onboarding.navController
import com.mitch.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {

                    Scaffold { innerPadding ->   // ✅ FIXED padding usage

                        NavHost(
                            navController = navController,
                            startDestination = Screen.Onboarding.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {

                            composable(Screen.Onboarding.route) {
                                OnboardingScreen(navController)
                            }

                            composable(Screen.Login.route) {
                                LoginScreen(navController as Modifier)
                            }

                            composable(Screen.Signup.route) {
                                SignupScreen(navController as Modifier)
                            }

                        }
        }
    }
}








@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {

    }
}}

    fun composable(route: Any, function: @Composable () -> Unit) {}
}
