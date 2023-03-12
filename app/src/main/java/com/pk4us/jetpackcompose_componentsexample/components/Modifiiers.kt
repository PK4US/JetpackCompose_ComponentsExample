package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MyModifierScreen() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BackgroundColor()
            Spacer(modifier = Modifier.size(50.dp))
            TextWidthPadding()
            Spacer(modifier = Modifier.size(50.dp))
            WidthAndHeightModifier()
            Spacer(modifier = Modifier.size(50.dp))
            SizeModifier()
            Spacer(modifier = Modifier.size(50.dp))
            FillWidthModifier()
            Spacer(modifier = Modifier.size(50.dp))
            FillHeightModifier()
            Spacer(modifier = Modifier.size(50.dp))
            AlphaModifier()
            Spacer(modifier = Modifier.size(50.dp))
            RotateModifier()
            Spacer(modifier = Modifier.size(50.dp))
            ScaleModifier()
            Spacer(modifier = Modifier.size(50.dp))
            WeightModifier()
            Spacer(modifier = Modifier.size(50.dp))
            BorderModifier()
            Spacer(modifier = Modifier.size(50.dp))
            BorderWithShape()
            Spacer(modifier = Modifier.size(50.dp))
            ClipModifierRectangleShape()
            Spacer(modifier = Modifier.size(50.dp))
            ClipModifierCircleShape()
            Spacer(modifier = Modifier.size(50.dp))
            ClipModifierRoundedCornerShape()
            Spacer(modifier = Modifier.size(50.dp))
            ClipModifierCutCornerShape()
        }
    }
}

@Preview
@Composable
fun BackgroundColor() {
    Text(
        "Text with green background color", Modifier.background(color = Green)
    )
}


@Preview
@Composable
fun TextWidthPadding() {
    Text(
        "Padding and margin!",
        Modifier
            .padding(32.dp) // Outer padding (margin)
            .background(color = Green)
            .padding(16.dp) // Inner padding
    )
}

@Preview
@Composable
fun WidthAndHeightModifier() {
    Text(
        text = "Width and Height",
        modifier = Modifier
            .background(color = Green)
            .width(200.dp)
            .height(200.dp)
    )
}


@Preview
@Composable
fun SizeModifier() {
    Text(
        text = "Text with Size",
        modifier = Modifier
            .background(Green)
            .size(width = 200.dp, height = 200.dp)
    )
}


@Preview
@Composable
fun FillWidthModifier() {
    Text(
        text = "Text Width Match Parent",
        modifier = Modifier
            .background(Green)
            .fillMaxWidth(1f)
    )
}


@Preview()
@Composable
fun FillHeightModifier() {
    Text(
        text = " Text with 75% Height ",
        modifier = Modifier
            .background(Green)
            .fillMaxHeight(0.75f) //75% area fill
    )
}


@Preview
@Composable
fun AlphaModifier() {
    Box(
        Modifier
            .size(250.dp)
            .alpha(0.5f)//50% opacity
            .background(Green)
    )
}


@Preview
@Composable
fun RotateModifier() {
    Box(
        Modifier
            .rotate(45f)
            .size(200.dp)
            .background(Green)
    )
}


@Preview
@Composable
fun ScaleModifier() {
    Box(
        Modifier
            .scale(scaleX = 2f, scaleY = 3f)
            .size(200.dp, 200.dp)
    )
}


@Preview
@Composable
fun WeightModifier() {
    Row() {
        Column(
            Modifier
                .weight(1f)
                .background(Red)
        ) {
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            Modifier
                .weight(1f)
                .background(Blue)
        ) {
            Text(text = "Weight = 1", color = Color.White)
        }
        Column(
            Modifier
                .weight(2f)
                .background(Green)
        ) {
            Text(text = "Weight = 2")
        }
    }
}


@Preview
@Composable
fun BorderModifier() {
    Text(
        text = "Text with Red Border",
        modifier = Modifier
            .border(2.dp, Red)
    )
}


@Preview
@Composable
fun BorderWithShape() {
    Text(
        text = "Text with round border",
        modifier = Modifier
            .border(2.dp, SolidColor(Green), RoundedCornerShape(20.dp))
    )
}


@Preview
@Composable
fun ClipModifierRectangleShape() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(Dp(10f))
            .clip(RectangleShape)
            .background(Blue)
            .padding(Dp(15f))
    )
}


@Preview
@Composable
fun ClipModifierCircleShape() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(Dp(10f))
            .clip(CircleShape)
            .background(Blue)
            .padding(Dp(15f))
    )
}


@Preview
@Composable
fun ClipModifierRoundedCornerShape() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(Dp(10f))
            .clip(RoundedCornerShape(10.dp))
            .background(Blue)
            .padding(Dp(15f))
    )
}


@Preview
@Composable
fun ClipModifierCutCornerShape() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(Dp(10f))
            .clip(CutCornerShape(25.dp))
            .background(Blue)
            .padding(Dp(15f))
    )
}