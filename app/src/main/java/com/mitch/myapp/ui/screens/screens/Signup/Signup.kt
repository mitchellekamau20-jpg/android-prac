package com.mitch.myapp.ui.screens.screens.Signup


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec.RawRes
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mitch.myapp.R
import com.mitch.myapp.ui.theme.primaryColor
import com.mitch.myapp.ui.theme.secondaryColor


@Composable
fun SignupScreen(modifier: NavHostController, modifier1: Modifier) {
    var usernameInput by remember { mutableStateOf(value = TextFieldValue("")) }
    var emailInput by remember { mutableStateOf(value = TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(value = TextFieldValue("")) }
    var isVisible by remember {mutableStateOf(false)}
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
             shape = RoundedCornerShape(24.dp),
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email ),
             colors  = OutlinedTextFieldDefaults.colors(
                 focusedBorderColor = secondaryColor,
                 unfocusedBorderColor = primaryColor,
                 ), modifier = Modifier.fillMaxWidth()
        )

         //emailInput
         OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput=it},
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_password_24),
                    contentDescription = "Email"

                )},
            placeholder = {
                Text(text = "eg email@gmail.com")

            },
            maxLines = 1,
             shape = RoundedCornerShape(24.dp),
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email ),
             colors  = OutlinedTextFieldDefaults.colors(
                 focusedBorderColor = secondaryColor,
                 unfocusedBorderColor = primaryColor,
                 ), modifier = Modifier.fillMaxWidth()

        )


        //passwordInput
         OutlinedTextField(
            value = passwordInput,
            onValueChange = {passwordInput=it},
            leadingIcon = {
                Icon(
                    imageVector =  ImageVector.vectorResource(R.drawable.outline_password_24),
                    contentDescription = "Edit"
                )
            },
             label = {
                 Text(text ="password")
             },
             visualTransformation = if (isVisible){
                 VisualTransformation.None
             } else {
                 PasswordVisualTransformation()
             },
             trailingIcon = {
                 IconButton(
                     onClick = { isVisible =!isVisible}
                 ) {
                     if (isVisible){
                     Icon(
                         imageVector = ImageVector.vectorResource(R.drawable.outline_visibility_off_24),
                         contentDescription=""
                     )
                 } else {
                         Icon(
                             imageVector = ImageVector.vectorResource(R.drawable.outline_visibility_24),
                             contentDescription = "Password"
                         )
                     }
             }

             },


            maxLines = 1,
             shape = RoundedCornerShape(24.dp),
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email ),
             colors  = OutlinedTextFieldDefaults.colors(
                 focusedBorderColor = secondaryColor,
                 unfocusedBorderColor = primaryColor,
                 ),modifier = Modifier.fillMaxWidth()
        )
        //button
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
