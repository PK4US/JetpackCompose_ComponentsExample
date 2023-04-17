package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyChartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyChartUI1()
        Spacer(modifier = Modifier.height(32.dp))
        MyChartUI2()
        Spacer(modifier = Modifier.height(32.dp))
        MyChartUI3()
    }
}

@Preview
@Composable
fun MyChartUI1() {
    val sumOfValues = listOf(65f, 40f, 25f, 20f).sum()    // Sum of all the values
    val proportions = listOf(65f, 40f, 25f, 20f).map { it * 100 / sumOfValues }    // Calculate each proportion
    val sweepAngles = proportions.map { 360 * it / 100 }    // Convert each proportion to angle

    Canvas(modifier = Modifier.size(size = 200.dp)) {
        var startAngle = -90f

        for (i in listOf(65f, 40f, 25f, 20f).indices) {
            drawArc(
                color = listOf(
                    Color(0xFFFF6384),
                    Color(0xFFFFCE56),
                    Color(0xFF36A2EB),
                    Color(0xFF448AFF)
                )[i],
                startAngle = startAngle,
                sweepAngle = sweepAngles[i],
                useCenter = false,
                style = Stroke(width = 36.dp.toPx(), cap = StrokeCap.Butt)
            )
            startAngle += sweepAngles[i]
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    Column {
        for (i in listOf(65f, 40f, 25f, 20f).indices) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background( color = listOf(
                            Color(0xFFFF6384),
                            Color(0xFFFFCE56),
                            Color(0xFF36A2EB),
                            Color(0xFF448AFF))[i], shape = CircleShape)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = listOf("Mango", "Banana", "Apple", "Melon")[i],
                    color = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun MyChartUI2() {
    val sweepAngles = listOf(65f, 60f, 55f).map { 360 * it / 100 } // Convert each value to angle

    Canvas(modifier = Modifier.size(280.dp)) {
        var arcRadius = 280.dp.toPx()

        for (i in listOf(65f, 60f, 55f).indices) {
            arcRadius -= 42.dp.toPx()

            drawCircle(
                color = Color.LightGray.copy(alpha = 0.3f),
                radius = arcRadius / 2,
                style = Stroke(width = 16.dp.toPx(), cap = StrokeCap.Butt)
            )

            drawArc(
                color = listOf(
                    Color(0xFFbe1558),
                    Color(0xFFe75874),
                    Color(0xFFfbcbc9)
                )[i],
                startAngle = -90f,
                sweepAngle = sweepAngles[i],
                useCenter = false,
                style = Stroke(width = 16.dp.toPx(), cap = StrokeCap.Round),
                size = Size(arcRadius, arcRadius),
                topLeft = Offset(
                    x = (280.dp.toPx() - arcRadius) / 2,
                    y = (280.dp.toPx() - arcRadius) / 2
                )
            )
        }
    }

    Spacer(modifier = Modifier.height(4.dp))

    Column {
        for (i in listOf(65f, 60f, 55f).indices) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(color = listOf(
                            Color(0xFFbe1558),
                            Color(0xFFe75874),
                            Color(0xFFfbcbc9)
                        )[i], shape = CircleShape)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = listOf("Mango", "Apple", "Melon")[i],
                    color = Color.Black
                )
            }
        }
    }
}


@Preview
@Composable
fun MyChartUI3() {
    val sumOfValues = listOf(15f, 35f, 50f).sum() // Sum of all the values
    val proportions = listOf(15f, 35f, 50f).map { it * 100 / sumOfValues } // Calculate each proportion value
    val sweepAngles = proportions.map { 360 * it / 100 }// Convert each proportions to angle

    Canvas(modifier = Modifier.size(size = 200.dp)) {
        var startAngle = -90f

        for (i in sweepAngles.indices) {
            drawArc(
                color = listOf(
                    Color(0xFF58BDFF),
                    Color(0xFF125B7F),
                    Color(0xFF092D40))[i],
                startAngle = startAngle,
                sweepAngle = sweepAngles[i],
                useCenter = true
            )
            startAngle += sweepAngles[i]
        }
    }

    Spacer(modifier = Modifier.height(4.dp))

    Column {
        for (i in listOf(15f, 35f, 50f).indices) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.width(16.dp),
                    thickness = 4.dp,
                    color = listOf(
                        Color(0xFF58BDFF),
                        Color(0xFF125B7F),
                        Color(0xFF092D40)
                    )[i]
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = listOf("Mango", "Banana", "Apple")[i],
                    color = Color.Black
                )
            }
        }
    }
}
