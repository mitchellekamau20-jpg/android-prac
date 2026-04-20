package com.mitch.myapp.ui.screens.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mitch.myapp.R




@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier) {
//     inputs
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }
    var isVisible by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(pagePadding)
            .fillMaxSize()
    ) {
        //        lottie animation
        LottieAnimationWidget(R.raw.auth_login, 300.dp)

//           welcome message
        Text(
            text = "Login to get started",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = primaryColor
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        //        email input
        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email",
                    tint = primaryColor
                )
            },
            placeholder = {
                Text(text = "eg. jd@example.com")
            },
            maxLines = 1,
            shape = RoundedCornerShape(24.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = primaryColor
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
        //        password input
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.password_icon),
                    contentDescription = "Email",
                    tint = primaryColor
                )
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = if (isVisible) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = { isVisible = !isVisible }
                ) {
                    if (isVisible) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.outline_visibility_off_24),
                            contentDescription = "Password"
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
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = secondaryColor,
                unfocusedBorderColor = primaryColor
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))
        //        button
        OutlinedButton(
            onClick = {},
            border = ButtonDefaults.outlinedButtonBorder(enabled = false),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = darkColor,
                containerColor = primaryColor,
            ),
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            Text(
                text = "login",
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }

//         row
        Row() {
            Text(text = "Forgot Password"
                , style = TextStyle(
                    fontSize = 12.sp
                ))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "No account?", style = TextStyle(
                fontSize = 12.sp
            ))
        }
    }
}