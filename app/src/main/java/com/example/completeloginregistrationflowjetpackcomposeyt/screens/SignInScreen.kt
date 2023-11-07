package com.example.completeloginregistrationflowjetpackcomposeyt.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.completeloginregistrationflowjetpackcomposeyt.R
import com.example.completeloginregistrationflowjetpackcomposeyt.components.ButtonComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.ClickableLoginTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.DividerTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.GoogleButtonComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.HeadingTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.NormalTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.UnderLinedTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.navigation.PostOfficeAppRouter
import com.example.completeloginregistrationflowjetpackcomposeyt.navigation.Screen
import com.example.completeloginregistrationflowjetpackcomposeyt.navigation.SystemBackButtonHandler

@Composable
fun SignInScreen() {
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            NormalTextComponent(value = stringResource(id = R.string.hello))

            HeadingTextComponent(value = stringResource(R.string.welcome_back))

            Spacer(modifier = Modifier.height(20.dp))

//            TextFieldComponent(
//                labelValue = stringResource(id = R.string.e_mail),
//                painterResource = (painterResource (id = R.drawable.outline_email_24)))
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            PasswordTextFieldComponent(
//                labelValue = stringResource(id = R.string.password),
//                painterResource = (painterResource(id = R.drawable.outline_lock_24)))

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponent (
                defaultText = stringResource(id = R.string.login),
                loadingText = stringResource(R.string.logging_in),
                onButtonClicked = {
                    Log.d("loginButton", "Clicked")
                }
            )

            DividerTextComponent()

            GoogleButtonComponent (
                defaultText = stringResource(R.string.sign_in_with_google),
                loadingText = stringResource(R.string.signing_with_google),
                onClicked = {})

            Spacer(modifier = Modifier.height(20.dp))

            UnderLinedTextComponent(
                value = "Forgot your password?"
            )

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            })

            SystemBackButtonHandler {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
            }

        }

    }
}
@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}