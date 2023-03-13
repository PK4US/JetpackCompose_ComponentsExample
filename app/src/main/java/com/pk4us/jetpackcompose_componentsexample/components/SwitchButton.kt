package com.pk4us.jetpackcompose_componentsexample.components

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun MySwitchButtonScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch1()
            Switch2()
            Switch3()

        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch4()
            Switch5()
            Switch6()
        }
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch8()
            Switch9()
        }
    }
}

@Preview
@Composable
fun Switch1() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val switchON = remember { mutableStateOf(true) }
        Switch(checked = switchON.value, onCheckedChange = { switchON.value = it })
        Text(text = if (switchON.value) "ON" else "OFF")
    }
}


@Preview
@Composable
fun Switch2() {
    var checked by remember { mutableStateOf(true) }
    Switch(
        modifier = Modifier.semantics { contentDescription = "Demo" },
        checked = checked,
        onCheckedChange = { checked = it })
}


@Preview
@Composable
fun Switch3() {
    var checked by remember { mutableStateOf(true) }
// Icon isn't focusable, no need for content description
    val icon: (@Composable () -> Unit)? = if (checked) {
        {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize),
            )
        }
    } else {
        {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize),
            )
        }
    }

    Switch(
        modifier = Modifier.semantics { contentDescription = "Demo with icon" },
        checked = checked,
        onCheckedChange = { checked = it },
        thumbContent = icon
    )
}

@Preview
@Composable
fun Switch4() {
    Column {
        val switchON = remember { mutableStateOf(true) }
        val thumbRadius = (20.dp / 2) - 4.dp
        val animatePosition = animateFloatAsState(
            targetValue = if (switchON.value)
                with(LocalDensity.current) { (36.dp - thumbRadius - 4.dp).toPx() }
            else
                with(LocalDensity.current) { (thumbRadius + 4.dp).toPx() }
        )
        Canvas(
            modifier = Modifier
                .size(width = 36.dp, height = 20.dp)
                .scale(scale = 2f)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            switchON.value = !switchON.value
                        }
                    )
                }
        ) {
            drawRoundRect(
                color = if (switchON.value) Color(0xFF00FF0A) else Color(0xFFFF0000),
                cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx())
            )
            drawCircle(
                color = Color.White,
                radius = thumbRadius.toPx(),
                center = Offset(
                    x = animatePosition.value,
                    y = size.height / 2
                )
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = if (switchON.value) "ON" else "OFF")
    }
}

@Preview
@Composable
fun Switch5() {
    Column {
        val switchON = remember { mutableStateOf(true) }
        val thumbRadius = (20.dp / 2) - 4.dp
        val animatePosition = animateFloatAsState(
            targetValue = if (switchON.value)
                with(LocalDensity.current) { (36.dp - thumbRadius - 4.dp).toPx() }
            else
                with(LocalDensity.current) { (thumbRadius + 4.dp).toPx() }
        )
        Canvas(
            modifier = Modifier
                .size(width = 36.dp, height = 20.dp)
                .scale(scale = 2f)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            // This is called when the user taps on the canvas
                            switchON.value = !switchON.value
                        }
                    )
                }
        ) {
            drawRoundRect(
                color = if (switchON.value) Color(0xFF00FF0A) else Color(0xFFFF0000),
                cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),
                style = Stroke(width = 2.dp.toPx())
            )

            drawCircle(
                color = if (switchON.value) Color(0xFF00FF0A) else Color(0xFFFF0000),
                radius = thumbRadius.toPx(),
                center = Offset(
                    x = animatePosition.value,
                    y = size.height / 2
                )
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Text(text = if (switchON.value) "ON" else "OFF")
    }
}

@Preview
@Composable
fun Switch6() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val interactionSource = remember { MutableInteractionSource() }
        var switchOn by remember { mutableStateOf(true) }
        val alignment by animateAlignmentAsState(if (switchOn) 1f else -1f)

        Box(
            modifier = Modifier
                .size(width = 72.dp, height = 40.dp)
                .border(
                    width = 4.dp,
                    color = if (switchOn) Color(0xFF00FF0A) else Color(0xFFFF0000),
                    shape = RoundedCornerShape(percent = 50)
                )
                .clickable(
                    indication = null,
                    interactionSource = interactionSource
                ) {
                    switchOn = !switchOn
                },
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    )
                    .fillMaxSize(),
                contentAlignment = alignment
            ) {
                Icon(
                    imageVector = if (switchOn) Icons.Filled.Done else Icons.Filled.Close,
                    contentDescription = if (switchOn) "Enabled" else "Disabled",
                    modifier = Modifier
                        .size(size = 24.dp)
                        .background(
                            color = if (switchOn) Color(0xFF00FF0A) else Color(0xFFFF0000),
                            shape = CircleShape
                        )
                        .padding(all = 4.dp),
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(height = 16.dp))
        Text(text = if (switchOn) "ON" else "OFF")
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
private fun animateAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment> {
    val bias by animateFloatAsState(targetBiasValue)
    return derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) }
}


@Preview
@Composable
private fun Switch8() {
    var switchOn by remember { mutableStateOf(true) }
    Switch(
        checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Magenta
        )
    )
}


@Preview
@Composable
private fun Switch9() {
    var switchOn by remember { mutableStateOf(true) }

    Switch(
        modifier = Modifier.scale(scale = 2f),
        checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_
        }
    )
}

