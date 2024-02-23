package com.example.a24_02_paris.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorComponent(errorMessage :String ){
    AnimatedVisibility(visible = errorMessage.isNotBlank()){
        Text(
            errorMessage)
    }

}