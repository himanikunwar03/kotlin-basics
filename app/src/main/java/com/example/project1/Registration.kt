package com.example.project1

import android.icu.util.Calendar
import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project1.ui.theme.Project1Theme

class Registration : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Scaffold { innerPadding ->
                Registration(innerPadding)
            }
        }
    }
}

@Composable
fun Registration(innerPadding: PaddingValues) {
    var firstname by remember { mutableStateOf(value = "") }
    var lastname by remember { mutableStateOf(value = "") }
    var email by remember { mutableStateOf(value = "") }
    val countryList = listOf("India", "Nepal", "China", "canada")
    var expanded by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf("") }
    var termsAccepted by remember { mutableStateOf(false) }
    var gender by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    val context = LocalContext.current


    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)


    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(color = Color.White ),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Register")



        Row(
            modifier = Modifier
//                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
//            horizontalArrangement = Arrangement.SpaceBetween


        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(12.dp),

                value = firstname,
                onValueChange = {

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                label = {
                    Text("firstname")

                },
            )
            OutlinedTextField(
                modifier = Modifier
                    .weight(1f),
                shape = RoundedCornerShape(1.dp),
                value = lastname,
                onValueChange = { lastname = it

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                label = {
                    Text("lastname")}

            )


        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)) {
            OutlinedTextField(
                value = selectedCountry,
                onValueChange = {},
                label = { Text("Select Country") },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(){ expanded = true }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                countryList.forEach { country ->
                    DropdownMenuItem(
                        text = { Text(country) },
                        onClick = {
                            selectedCountry = country
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = if (dob.isEmpty()) "Select Date of birth" else "DOB: $dob")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Select Gender", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("Male", "Female", "Other").forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    androidx.compose.material3.RadioButton(
                        selected = gender == option,
                        onClick = { gender = option }
                    )
                    Text(text = option)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = termsAccepted,
                onCheckedChange = { termsAccepted = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("I accept terms and conditions")
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

            },
            enabled = termsAccepted,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Register")
        }
        Spacer(modifier = Modifier.height(16.dp))

        ClickableText(

            text = buildAnnotatedString {
                append("Already have an account?")
                withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
                    append("Sign in")
                }
            },
            onClick = {

            },
            modifier = Modifier.padding(16.dp)
        )



    }
}


@Preview
@Composable
fun RegistrationP() {
    Registration(innerPadding = PaddingValues(0.dp))
}