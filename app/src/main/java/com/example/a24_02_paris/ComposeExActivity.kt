package com.example.a24_02_paris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.a24_02_paris.ui.screens.SearchScreen
import com.example.a24_02_paris.ui.theme._24_02_parisTheme

class ComposeExActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _24_02_parisTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SearchScreen()
                }
            }
        }
    }
}

@Composable
fun Experience() {
    println("Expericence() : Recomposition")

    var j = remember { 5 }
    var i by remember { mutableIntStateOf(5) }

    var text = "i=$i j=$j"

    Row {
        Button(
            onClick = {
                i++
                j++
                println(text)
            }
        ) {
            println("Button() : Recomposition")
            Text(text)
        }
    }
}