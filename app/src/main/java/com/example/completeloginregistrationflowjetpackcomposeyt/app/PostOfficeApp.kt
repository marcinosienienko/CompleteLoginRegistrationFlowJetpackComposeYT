package com.example.completeloginregistrationflowjetpackcomposeyt.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.completeloginregistrationflowjetpackcomposeyt.navigation.PostOfficeAppRouter
import com.example.completeloginregistrationflowjetpackcomposeyt.navigation.Screen
import com.example.completeloginregistrationflowjetpackcomposeyt.screens.SignInScreen
import com.example.completeloginregistrationflowjetpackcomposeyt.screens.SignUpScreen
import com.example.completeloginregistrationflowjetpackcomposeyt.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White
            ){

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState->
                                    when(currentState.value){
                                        is Screen.SignUpScreen ->{
                                            SignUpScreen()
                                        }
                                        is Screen.TermsAndConditionsScreen ->{
                                            TermsAndConditionsScreen()
                                        }
                                        is Screen.SignInScreen -> {
                                            SignInScreen()
                                        }
                                    }
        }

    }
}
