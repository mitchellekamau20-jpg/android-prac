package com.mitch.myapp.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mitch.myapp.R
import com.mitch.myapp.ui.login.LottieAnimationWidget


@Composable
fun SignupScreen(modifier: Modifier) {
    var usernameInput by remember { mutableStateOf(value = TextFieldValue("")) }
    var emailInput by remember { mutableStateOf(value = TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(value = TextFieldValue("")) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier
        ) {
        //lottie animation
        LottieAnimationWidget()
        //username
        OutlinedTextField(
        value =usernameInput,
        onValueChange ={usernameInput=it},
        placeholder = {
            Text(text="enter your username")
        },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
         //emailinput
        OutlinedTextField(
        value = emailInput,
        onValueChange = { emailInput=it},
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = "Email"

            )},
        placeholder = {
            Text(text = "eg email@gmail.com")

        },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth()

        )

        //passwordinput
        OutlinedTextField(
            value = passwordInput,
            onValueChange = {passwordInput=it},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Edit"
                )
            },
            placeholder = {
                Text(text = "eg 1234")

            },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )







   @Composable
fun LottieAnimationWidget(){
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loader)
    )

    // 2. Control the animation state (looping, speed, etc.)
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever // Loop indefinitely
    )

    // 3. Display the animation
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(200.dp)
    )
}}}