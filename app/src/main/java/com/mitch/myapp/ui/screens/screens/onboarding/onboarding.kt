package com.mitch.myapp.ui.screens.screens.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec.RawRes
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mitch.myapp.R
import com.mitch.myapp.ui.navigation.ROUTES
import com.mitch.myapp.ui.theme.primaryColor
import com.mitch.myapp.ui.theme.secondaryColor


@Composable
fun OnboardingScreen(navController: NavHostController){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        //App name
        Text(
            text = " Siren ",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = secondaryColor
            )
        )


        //lottie animation
        LottieAnimationWidget()

        //welcome text
        Text(
            text = "Welcome to Siren app",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
        )


        OutlinedButton(onClick = { navController.navigate(ROUTES.Login.name)},

            modifier = Modifier.padding(horizontal = 24.dp),
            border =  ButtonDefaults.outlinedButtonBorder(enabled = false),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = primaryColor,
            ),

            ) {
            Text(text ="login")
        }
    }
}

@Composable
fun LottieAnimationWidget() {
    val composition by rememberLottieComposition(spec = RawRes(resId = R.raw.loader))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(350.dp)
    )
}