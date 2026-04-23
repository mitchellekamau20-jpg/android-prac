package com.mitch.myapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mitch.myapp.ui.screens.screens.forgotpassword.ForgotPasswordScreen
import com.mitch.myapp.ui.screens.screens.login.LoginScreen
import com.mitch.myapp.ui.screens.screens.onboarding.OnboardingScreen
import com.mitch.myapp.ui.screens.screens.signup.SignupScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier){
    NavHost(
        navController = navController,
        startDestination = ROUTES.Onboarding.name
    ) {
        composable (ROUTES.Onboarding.name){ OnboardingScreen(navController) }
        composable (ROUTES.Login.name){ LoginScreen(navController, modifier) }
        composable(ROUTES.Forgotpassword.name){ ForgotPasswordScreen(navController,modifier) }
        composable(ROUTES.Signup.name){ SignupScreen(navController,modifier) }
    }
}