package com.example.myinterationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myinterationapp.ui.theme.MyInterationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyInterationAppTheme {
                var text by remember { mutableStateOf("") }
                var results by remember { mutableStateOf("") }
                Column() {
                    Text("Day Track")
                    OutlinedTextField(
                        value = text,
                        onValueChange = {text = it },
                        label = {Text("Enter time of  day")}
                    )
                    Row() {
                        Button(
                            onClick ={
                                results = when(text){
                                    "Morning"-> "Take dog out for walk"
                                    "Mid-morning"-> "Make plans with friends"
                                    "Afternoon"-> "Go for brunch"
                                    "Mid-afternoon"-> "Finish work task"
                                    "Evening"->"Go for dinner"
                                    "Mid-evening"->"Relax"

                                    else -> "Invalid input"
                                }
                            }
                        ) {
                            Text("suggestion")
                        }
                        Button(
                            onClick = {
                                text = ""
                                results =""
                            }
                        ) {
                            Text("Reset")
                        }
                    }
                    Text(results)
                }

            }
        }
    }
}

