package com.mitch.myapp.ui.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec.RawRes
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mitch.myapp.R
import com.mitch.myapp.ui.theme.primaryColor


@Composable
fun OnboardingScreen(navController: NavController) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        //lottie animation
        LottieAnimationWidget()
        //text
        Text(text="welcome to my app",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            ))
        Spacer(modifier= Modifier.height(24.dp))
        //login button
        OutlinedButton(
            onClick = {},
            border = ButtonDefaults.outlinedButtonBorder( enabled = false),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = primaryColor
            ),
        ) {
            Text("LOGIN")
        }
        Spacer(modifier= Modifier.height(24.dp))
        //signup button
        OutlinedButton(
            onClick = {},
            border = ButtonDefaults.outlinedButtonBorder( enabled = false),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFFFFFF),
                containerColor = primaryColor
            ),
        ) {
            Text("SIGNUP")
        }

//        text buttons => back to login , no account?
        Row {
            TextButton(
                onClick = {}
            ) {
                Text(
                    text="back to login",
                    style = TextStyle(
                        fontSize = 11.sp,
                    )
                )
            }
            TextButton(
                onClick = {}
            ) {
                Text(text="no account?",
                    style = TextStyle(
                        fontSize = 11.sp,
                    ))
            }
        }


    }}
@Composable
fun LottieAnimationWidget(){
    val composition by rememberLottieComposition(spec = RawRes(resId = R.raw.loader))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(350.dp)
    )

}
