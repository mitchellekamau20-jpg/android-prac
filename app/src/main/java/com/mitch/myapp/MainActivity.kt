package com.mitch.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mitch.myapp.ui.authentication.signup.SignupScreen
import com.mitch.myapp.ui.forgotpassword.forgotpassword.ForgotPasswordScreen
import com.mitch.myapp.ui.login.LoginScreen
import com.mitch.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
                    SignupScreen(modifier = Modifier.padding(innerPadding))

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
