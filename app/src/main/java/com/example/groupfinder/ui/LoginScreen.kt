package com.example.groupfinder.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.groupfinder.R
import com.example.groupfinder.data.LoginUiState

/*
* TODO:
*  fix spacing
*  use correct logo
*  make sure username and password are being managed correctly
*  create an account button
* */



@Composable
fun LoginScreen(onLoginClick: (String, String) -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, top = 80.dp, 16.dp, 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier

        ) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp),

                painter = painterResource(id = R.drawable.lplaceholder),
                contentDescription = "logo placeholder"
            )
        }

        // Username TextField
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Password TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Login Button
        Button(
            onClick = { onLoginClick(email, password) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    //val loginUiState = LoginUiState()
    LoginScreen() { email, password ->
        println("Login clicked with username: $email and password: $password")
    }
}
