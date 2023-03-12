package com.pk4us.jetpackcompose_componentsexample.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyToastMessageScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyToastMessageUI1()
        MyToastMessageUI2()
    }
}

@Composable
private fun MyToastMessageUI1() {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center
    ) {
        // * Toast Sample
        Button(
            onClick = {
                // * Toast
                Toast.makeText(context, "Hi i am toast", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Toast 1")
        }
    }
}


@Composable
private fun MyToastMessageUI2() {
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                // * Toast extension function
                context.showToast("Hi i am extension toast", Toast.LENGTH_LONG)
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(text = "Toast 2 ")
        }
    }
}

fun Context.showToast(message: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, length).show()
}