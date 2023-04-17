package com.pk4us.jetpackcompose_componentsexample.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pk4us.jetpackcompose_componentsexample.R

@Composable
fun MyTinderMatchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MatchScreenDatingApp()
    }
}

@Preview
@Composable
private fun MatchScreenDatingApp(
    primaryColor: Color = Color(0xFFF518A0),
    backgroundColors: List<Color> =
        listOf(
            primaryColor,
            Color(0xFFB232BD)
        )
) {

    // change status bar color
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(color = primaryColor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(backgroundColors))
            .padding(vertical = 64.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MatchScreenTopText()
        }

        MatchScreenImagesBox(primaryColor = primaryColor)

        Row(
            modifier = Modifier.fillMaxWidth(),
            // Gap between two buttons = 24.dp
            horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally)
        ) {
            MatchScreenButtons(primaryColor = primaryColor)
        }

    }
}

@Composable
private fun MatchScreenTopText() {

    Text(
        text = "It’s a Match!", style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
    )

    Text(
        text = "You and Grace like each other", style = TextStyle(
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        )
    )
}

@Composable
private fun MatchScreenImagesBox(primaryColor: Color) {
    Box(contentAlignment = Alignment.Center) {

        Row {
            MatchScreenImageStyle(imageId = R.drawable.people_john)
            MatchScreenImageStyle(imageId = R.drawable.people_grace_1)
        }

        Icon(
            modifier = Modifier
                .background(color = primaryColor, shape = CircleShape)
                .border(width = 3.dp, color = Color.White, shape = CircleShape)
                .padding(12.dp),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Match",
            tint = Color.White
        )

    }
}

@Composable
private fun MatchScreenImageStyle(imageId: Int) {
    Image(
        modifier = Modifier
            .size(120.dp)
            .shadow(
                elevation = 4.dp,
                shape = CircleShape,
                clip = true
            )
            .clip(CircleShape)
            .border(width = 3.dp, color = Color.White, shape = CircleShape),
        painter = painterResource(id = imageId),
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun MatchScreenButtons(primaryColor: Color) {
    ButtonStyles(
        imageVector = Icons.Outlined.Email,
        text = "Message Her",
        primaryColor = primaryColor
    )
    ButtonStyles(
        imageVector = Icons.Outlined.Info,
        text = "Info",
        primaryColor = primaryColor
    )
}

@Composable
private fun ButtonStyles(
    context: Context = LocalContext.current.applicationContext,
    imageVector: ImageVector,
    text: String,
    primaryColor: Color
) {
    OutlinedButton(
        modifier = Modifier.size(56.dp),
        shape = CircleShape,
        border = BorderStroke(0.dp, Color.Transparent),
        contentPadding = PaddingValues(6.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp),
        onClick = {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        }) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = imageVector,
            contentDescription = text,
            tint = primaryColor
        )
    }
}