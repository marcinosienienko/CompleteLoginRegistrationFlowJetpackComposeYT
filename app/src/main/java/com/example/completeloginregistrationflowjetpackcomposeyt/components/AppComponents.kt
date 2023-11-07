package com.example.completeloginregistrationflowjetpackcomposeyt.components

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.completeloginregistrationflowjetpackcomposeyt.R
import com.example.completeloginregistrationflowjetpackcomposeyt.ui.theme.Shapes

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        color = androidx.compose.ui.graphics.Color.DarkGray
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
            ),
        color = androidx.compose.ui.graphics.Color.DarkGray,

        )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(labelValue: String, painterResource: Painter, onTextSelected: (String) -> Unit) {

    val textValue = remember {mutableStateOf("")}

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        label = {Text(
            text = labelValue)
                },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = androidx.compose.ui.graphics.Color.White,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.DarkGray,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.LightGray,
            focusedLabelColor = androidx.compose.ui.graphics.Color.DarkGray,
            cursorColor = androidx.compose.ui.graphics.Color.DarkGray,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text
        ),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextSelected(it)
        },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "" )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(labelValue: String, painterResource: Painter, onTextSelected: (String) -> Unit) {

//    val password = remember {
//        mutableStateOf("")
//    }

    val localFocusManager = LocalFocusManager.current
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},
        placeholder = {Text(text = "Password")},
        colors = TextFieldDefaults.textFieldColors(

            containerColor = androidx.compose.ui.graphics.Color.White,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.DarkGray,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.LightGray,
            focusedLabelColor = androidx.compose.ui.graphics.Color.DarkGray,
            cursorColor = androidx.compose.ui.graphics.Color.DarkGray,

            ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        value = password,
        onValueChange = {
            password = it
            onTextSelected(it)
        },
        singleLine = true,
        maxLines = 1,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = ""
            )
        },
        trailingIcon = {

            val iconImage =
                if(passwordVisible)  {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if(passwordVisible) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }
            
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description
                )
            }
            
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else
                PasswordVisualTransformation()

    )
}

@Composable
fun CheckBoxComponent(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        ) {

        var checkedState by rememberSaveable {
            mutableStateOf(false)
        }

        Checkbox(
            checked = checkedState,
            onCheckedChange = {
            checkedState = !checkedState
        })
        
        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected : (String) -> Unit) {

    val initialText = stringResource(R.string.by_continuing_you_accept_our)
    val privacyPolicyText = stringResource(R.string.privacy_policy)
    val andText = stringResource(R.string.and)
    val termsOfUse = stringResource(R.string.terms_of_use)

    //val nonClickableTextColor = Color.LightGray

    val annotatedString = buildAnnotatedString {

            append(initialText)
        withStyle(style = SpanStyle(color = Color.DarkGray)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }

            append(andText)

        withStyle(style = SpanStyle(color = Color.DarkGray)) {
            pushStringAnnotation(tag = termsOfUse, annotation = termsOfUse)
            append(termsOfUse)
        }
    }
    
    ClickableText(text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if((span.item == termsOfUse) || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }
            }

    })

}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically)
    {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp)

        Text(modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.or),
            fontSize = 18.sp, color = Color.Black)

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = Color.Gray,
            thickness = 1.dp)
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin:Boolean = true, onTextSelected: (String) -> Unit) {

    val initialText =

        if (tryingToLogin)
            stringResource(R.string.already_have_an_account)
        else
            stringResource(R.string.don_t_have_an_account_yet
    )

    val loginText =

        if (tryingToLogin)
            stringResource(R.string.login)
        else
            stringResource(id = R.string.register)

    val annotatedString = buildAnnotatedString {

        append(initialText)
        withStyle(SpanStyle(color = Color.DarkGray)){
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
        
        
    }
    ClickableText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
       text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset ,offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if (span.item == loginText) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun UnderLinedTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = Color.LightGray,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,

    )
}
@Composable
fun ButtonComponent(
    colors: ButtonColors = ButtonDefaults.buttonColors(Color.Transparent),
    shape: CornerBasedShape = Shapes.medium,
    fontWeight: FontWeight = FontWeight.Bold,
    defaultText: String = stringResource(id = R.string.register),
    loadingText: String = stringResource(id = R.string.creating_account),
    progressIndicator: Color = MaterialTheme.colorScheme.surface,
//    onClicked: () -> Unit,
    onButtonClicked: () -> Unit
) {

    var clicked by remember { mutableStateOf(false) }

    Button(
        onClick = {
            clicked = !clicked
            onButtonClicked.invoke()
                  },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        shape = shape,
        contentPadding = PaddingValues(),
        colors = colors

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Color.Black, Color.Gray)),
                    shape = Shapes.medium
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,


            )
        { if (!clicked) {
            Text(
                text = defaultText,
                fontSize = 18.sp,
                fontWeight = fontWeight)
        } else {
            Text (
                text = loadingText,
                fontSize = 18.sp,
                fontWeight = fontWeight,
            )
            Spacer(modifier = Modifier.width(8.dp))
            CircularProgressIndicator(
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp),
                strokeWidth = 2.dp,
                color = progressIndicator
            )
            //onClicked()
        }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoogleButtonComponent(
    defaultText : String = stringResource(id = R.string.sign_up_with_google),
    loadingText : String = stringResource(R.string.creating_account),
    icon : Painter = painterResource(id = R.drawable.ic_google_logo),
    shape : Shape = Shapes.medium,
    fontWeight: FontWeight = FontWeight.Bold,
    borderColor : Color = Color.LightGray,
    backgroundColor : Color = MaterialTheme.colorScheme.surface,
    progressIndicator: Color = MaterialTheme.colorScheme.primary,
    onClicked: () -> Unit
) {

    var clicked by remember { mutableStateOf(false) }

    Surface (
        modifier = Modifier.fillMaxWidth(),
        onClick = {clicked = !clicked},
        shape = shape,
        border = BorderStroke(width = 1.dp, color = borderColor),
        color = backgroundColor,
    ) {
        Row (
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Icon(
                painter = icon,
                    contentDescription = stringResource(R.string.google_button),
                    tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))

            if (!clicked) {
                Text(text = defaultText, fontWeight = fontWeight, fontSize = 18.sp)
            } else {
                Text(text = loadingText, fontWeight = fontWeight, fontSize = 18.sp)
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicator
                )
                onClicked()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)

@Preview
@Composable
fun ButtonComponentPreview() {
    ButtonComponent (
        defaultText = stringResource(id = R.string.register),
        loadingText = stringResource(id = R.string.creating_account),
        onButtonClicked = {
            Log.d("buttonRegister", "Clicked")
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun GoogleButtonComponentPreview(){
    GoogleButtonComponent(
        defaultText = stringResource(id = R.string.sign_up_with_google),
        loadingText = stringResource(id = R.string.creating_account),
        onClicked = {
            Log.d("googleButton","Clicked")
        }
    )
}

