package com.mitch.myapp.ui.Login


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec.RawRes
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.mitch.myapp.R
import com.mitch.myapp.ui.components.LottieAnimationWidget
import com.mitch.myapp.ui.components.pagePadding
import com.mitch.myapp.ui.theme.primaryColor
import com.mitch.myapp.ui.theme.secondaryColor



@Composable
fun LoginScreen(modifier: Modifier){
    //textInput
    var emailInput by remember {mutableStateOf(value = TextFieldValue(""))  }
    var passwordInput by remember {mutableStateOf(value = TextFieldValue(""))  }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(pagePadding)
            .fillMaxSize()

    ){
        //lottie animation
        LottieAnimationWidget(R.raw.login,.300.dp)

        //Welcome message

        Text(
            text="login to get started",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        //email input
        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput=it},
//            leadingIcon = {
//                Icon(
////                    imageVector = Icons,
//                    contentDescription = "Email",
//                    tint = primaryColor
//
//                )},
                placeholder = {
                    Text(text = "eg email@gmail.com")

            },
            maxLines = 1,
            shape = RoundedCornerShape(24.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email ),
            colors  = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = primaryColor,
        ),modifier = Modifier.fillMaxWidth()
        )

        //password input
                    OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput=it},
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.outline_password_24),
                    contentDescription = "email"

                )
//                Icon(
//                    imageVector = Icons.Outlined.Email,
//                    contentDescription ="Email"
//
//                )
                          },
               trailingIcon = {
                   IconButton(
                      onClick = {}
                   ) {
                       Icon(
                           imageVector = ImageVector.vectorResource(R.drawable.outline_visibility_off_24),
                           contentDescription=""
                       )
                   }

            },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth())

        //button



    }
    }


@Composable
fun LottieAnimationWidget(){
    val composition by rememberLottieComposition(
        spec = RawRes( R.raw.login))
    val progress by animateLottieCompositionAsState(
        composition,
    iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(350.dp)
    )
}