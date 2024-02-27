package com.example.managinstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.managinstate.ui.theme.ManaginStateTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManaginStateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Manage()
                }
            }
        }
    }
}

@Composable
fun Manage() {
    val Green = Color.Green;
    val Red = Color.Red;

    val backgroundColor = remember {
        mutableStateOf(Green)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (backgroundColor.value == Red) {
                    backgroundColor.value = Green
                }
                else{
                    backgroundColor.value = Red
                }
            }, colors = ButtonDefaults.buttonColors(backgroundColor.value)
        ) {
            Text(text = "Click")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManagePreview() {
    ManaginStateTheme {
        Manage()
    }
}