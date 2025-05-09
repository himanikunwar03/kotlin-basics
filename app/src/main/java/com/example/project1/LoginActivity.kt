package com.example.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project1.ui.theme.Project1Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                LoginBody(innerPadding)
            }

        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBody(innerPadding: PaddingValues) {

    var username by remember { mutableStateOf(value = "") }
    var password by remember {mutableStateOf(value = "")  }

    var passwordVisibility by remember { mutableStateOf(value = false) }
    var rememberMe by remember {
        mutableStateOf(false)
    }



//    var cartItem : Int = 0
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .width(800.dp)
        )



        Spacer(modifier = Modifier.height(50.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),

            placeholder = {
                Text(text = "abc@gmail.com")
            },

            value = username,
            onValueChange = { input ->
                username = input
            }
        )





        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            visualTransformation =
                if (passwordVisibility) PasswordVisualTransformation()
                else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password

            ),

            prefix = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,


                    )
            },

            trailingIcon = {
                Icon(
                    painter = painterResource(
                        if (passwordVisibility)
                            R.drawable.baseline_visibility_24
                        else R.drawable.baseline_visibility_off_24
                    ),
                    contentDescription = null,
                    modifier = Modifier.clickable{
                        passwordVisibility = !passwordVisibility

                    }

                )
            },
            placeholder = {
                Text("********")
            },
            value = password,
            onValueChange = { input ->
                password = input
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { remember ->
                        rememberMe = remember
                    },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Green,
                        checkmarkColor = Color.White
                    )
                )
                Text(text = "Remember me")
            }

            Text(text = "Forget Password")
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.Center
        )
        {

            }




    }
}




@Preview
@Composable
fun LoginBodyP() {
    LoginBody(innerPadding = PaddingValues(0.dp))
}

