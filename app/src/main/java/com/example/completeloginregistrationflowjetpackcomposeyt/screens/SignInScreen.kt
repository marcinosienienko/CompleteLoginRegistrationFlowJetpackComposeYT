package com.example.completeloginregistrationflowjetpackcomposeyt.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.completeloginregistrationflowjetpackcomposeyt.R
import com.example.completeloginregistrationflowjetpackcomposeyt.components.ButtonComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.DividerTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.GoogleButtonComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.HeadingTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.NormalTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.PasswordTextFieldComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.TextFieldComponent
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(R.string.welcome_back))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent(labelValue = stringResource(id = R.string.e_mail), painterResource = (painterResource (id = R.drawable.outline_email_24)))
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password), painterResource = (painterResource(id = R.drawable.outline_lock_24)))
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent (
                defaultText = "Login",
                loadingText = "Logging in...",
                onClicked = {
                    Log.d("loginButton", "Clicked")
                }
            )
            DividerTextComponent()
            GoogleButtonComponent (defaultText = "Sign In with google",
                loadingText = "Signing with google", onClicked = {})
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