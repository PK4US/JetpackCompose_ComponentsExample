package com.pk4us.jetpackcompose_componentsexample.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcompose_componentsexample.R


@Preview
@Composable
fun MyIconScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyIconUI1()
        MyIconUI2()
        MyIconUI3()
    }
}

@Preview
@Composable
fun MyIconUI1() {
    Icon(
        modifier = Modifier.size(size = 120.dp),
        imageVector = Icons.Default.Person,
        contentDescription = "Person Icon",
        tint = Color.LightGray
    )
}


@Preview
@Composable
fun MyIconUI2() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.Verified,
            contentDescription = null,
            tint = Color.Green,
            modifier = Modifier.size(28.dp)
        )

        // gap between icon and text
        Spacer(modifier = Modifier.width(width = 6.dp))

        Text(
            text = "Проверено",
            color = Color.Green,
            fontSize = 20.sp
        )
    }
}


@Preview
@Composable
fun MyIconUI3() {
    Icon(
        painter = painterResource(id = R.drawable.fingerprint),
        contentDescription = null,
        tint = Color.Green,
        modifier = Modifier.size(size = 60.dp)
    )
}