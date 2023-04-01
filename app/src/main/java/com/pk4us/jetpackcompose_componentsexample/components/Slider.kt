package com.pk4us.jetpackcompose_componentsexample.components

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MySliderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MySliderExample1()
        MySliderExample2()
        MySliderExample3()
        MySliderExample4()
        MySliderExample5()
        MySliderExample6()
        MySliderExample7()
        MySliderExample8()
        MySliderExample9()
        MySliderExample10()
    }
}

@Composable
fun MySliderExample1() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Text(text = sliderPosition.toString())
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it })
    }
}


@Composable
fun MySliderExample2() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Column {
        Text(text = sliderPosition.toString())
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {},
            steps = 5
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySliderExample3() {
    var sliderPosition by remember { mutableStateOf(0f) }
    val interactionSource = MutableInteractionSource()
    val colors = SliderDefaults.colors(thumbColor = Color.Red, activeTrackColor = Color.Red)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = sliderPosition.toString(), fontSize = sliderPosition.sp)
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {},
            interactionSource = interactionSource,
            thumb = {
                SliderDefaults.Thumb(
                    interactionSource = interactionSource,
                    colors = colors
                )
            },
            track = { sliderPositions ->
                SliderDefaults.Track(
                    colors = colors,
                    sliderPositions = sliderPositions
                )
            }
        )
    }
}

@Composable
@ExperimentalMaterial3Api
fun MySliderExample4() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Text(text = sliderPosition.toString(), style = MaterialTheme.typography.labelLarge)
    RangeSlider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        onValueChangeFinished = {},
    )
}

@Composable
@ExperimentalMaterial3Api
fun MySliderExample5() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Text(text = sliderPosition.toString(), style = MaterialTheme.typography.labelLarge)
    RangeSlider(
        steps = 5,
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        onValueChangeFinished = {},
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.secondary
        )
    )
}


@Composable
private fun MySliderExample6() {
    var sliderValue by remember { mutableStateOf(0f) }

    Slider(
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..10f
    )

    Text(text = sliderValue.toString())
}


@Composable
private fun MySliderExample7() {
    var sliderValue by remember { mutableStateOf(0f) }

    Slider(
        modifier = Modifier
            .width(width = 130.dp)
            .rotate(degrees = -90f),
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..5f
    )
}


@Composable
private fun MySliderExample8() {
    var sliderValue by remember { mutableStateOf(0f) }

    Slider(
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..10f,
        colors = SliderDefaults.colors(
            thumbColor = Color.Green,
            activeTrackColor = Color.Magenta
        )
    )

    Text(text = sliderValue.toString())
}


@Composable
private fun MySliderExample9() {
    var sliderValue by remember { mutableStateOf(0f) }

    Slider(
        value = sliderValue,
        onValueChange = { sliderValue_ ->
            sliderValue = sliderValue_
        },
        onValueChangeFinished = {
            Log.d("MainActivity", "sliderValue = $sliderValue")
        },
        valueRange = 0f..10f,
        steps = 4
    )

    Text(text = sliderValue.toString())
}

@Composable
private fun MySliderExample10() {

    var sliderValues by remember {
        mutableStateOf(1f..20f) // pass the initial values
    }

    RangeSlider(
        value = sliderValues,
        onValueChange = { sliderValues_ ->
            sliderValues = sliderValues_
        },
        valueRange = 1f..20f,
        onValueChangeFinished = {
            Log.d(
                "MainActivity",
                "First: ${sliderValues.start}, Last: ${sliderValues.endInclusive}"
            )
        }
    )

    Text(text = "Start: ${sliderValues.start}, End: ${sliderValues.endInclusive}")
}

@Composable
private fun MySliderExample11() {

    var sliderValues by remember {
        mutableStateOf(0f..10f)
    }

    RangeSlider(
        value = sliderValues,
        onValueChange = { sliderValues_ ->
            sliderValues = sliderValues_
        },
        valueRange = 0f..10f,
        onValueChangeFinished = {
            Log.d(
                "MainActivity",
                "First: ${sliderValues.start}, Last: ${sliderValues.endInclusive}"
            )
        },
        steps = 4
    )

    Text(text = "Start: ${sliderValues.start}, End: ${sliderValues.endInclusive}")
}