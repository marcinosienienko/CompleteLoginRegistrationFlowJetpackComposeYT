package com.example.completeloginregistrationflowjetpackcomposeyt.screens

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.completeloginregistrationflowjetpackcomposeyt.R
import com.example.completeloginregistrationflowjetpackcomposeyt.components.ButtonComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.CheckBoxComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.ClickableLoginTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.DividerTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.GoogleButtonComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.HeadingTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.NormalTextComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.PasswordTextFieldComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.components.TextFieldComponent
import com.example.completeloginregistrationflowjetpackcomposeyt.navigation.PostOfficeAppRouter
import com.example.completeloginregistrationflowjetpackcomposeyt.navigation.Screen


@Composable
fun SignUpScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
        color = Color.White


    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            NormalTextComponent(value = stringResource(R.string.hello))
            HeadingTextComponent(value = stringResource(R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent(
                labelValue = stringResource(R.string.first_name), 
                painterResource = painterResource(id = R.drawable.outline_person_24))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent(
                labelValue = stringResource(R.string.last_name),
                painterResource = painterResource(id = R.drawable.outline_person_24))
            Spacer(modifier = Modifier.height(20.dp))
            TextFieldComponent(
                labelValue = stringResource(R.string.e_mail),
                painterResource = painterResource(id = R.drawable.outline_email_24))
            Spacer(modifier = Modifier.height(20.dp))
            PasswordTextFieldComponent(
                labelValue = stringResource(R.string.password),
                painterResource = painterResource(id = R.drawable.outline_lock_24
            ))
            CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                })
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(defaultText = stringResource(R.string.register))
            Spacer(modifier = Modifier.height(20.dp))
            GoogleButtonComponent{

            }
            DividerTextComponent()
            
            ClickableLoginTextComponent(onTextSelected = {

            })
        }

    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}