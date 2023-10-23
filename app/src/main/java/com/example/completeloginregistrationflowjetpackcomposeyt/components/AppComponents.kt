package com.example.completeloginregistrationflowjetpackcomposeyt.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.completeloginregistrationflowjetpackcomposeyt.R

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
fun TextFieldComponent(labelValue: String, painterResource: Painter) {

    val textValue = remember {mutableStateOf("")}

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},

        colors = TextFieldDefaults.textFieldColors(

            containerColor = androidx.compose.ui.graphics.Color.White,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.DarkGray,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.LightGray,
            focusedLabelColor = androidx.compose.ui.graphics.Color.DarkGray,
            cursorColor = androidx.compose.ui.graphics.Color.DarkGray,

        ),

        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
                value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "" )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(labelValue: String, painterResource: Painter) {

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp)),
        label = {Text(text = labelValue)},

        colors = TextFieldDefaults.textFieldColors(

            containerColor = androidx.compose.ui.graphics.Color.LightGray,
            unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            focusedLabelColor = androidx.compose.ui.graphics.Color.DarkGray,
            cursorColor = androidx.compose.ui.graphics.Color.DarkGray,

            ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        maxLines = 1,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = ""
            )
        },
        trailingIcon = {

            val iconImage = if(passwordVisible.value)  {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if(passwordVisible.value) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }
            
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(
                    imageVector = iconImage,
                    contentDescription = description
                )
            }
            
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else
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

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(
            checked = checkedState.value,
            onCheckedChange = {
            checkedState.value = !checkedState.value
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
fun ButtonComponent(value: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Color.Black, Color.Gray)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center

        ) {
                Text(
                    text = value,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
        }
    }
}

@Preview
@Composable
fun ButtonComponentPreview(){
    ButtonComponent(value= "button")
}

