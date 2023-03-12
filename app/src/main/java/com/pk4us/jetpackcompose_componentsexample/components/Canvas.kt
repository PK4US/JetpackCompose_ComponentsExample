package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Canvas() {
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
            MyUI1()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI2()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI3()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI4()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI5()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI6()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI7()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI8()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI9()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI10()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI11()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI13()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI14()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI15()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI16()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI17()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI18()
            Spacer(modifier = Modifier.size(50.dp))
            MyUI19()
            Spacer(modifier = Modifier.size(50.dp))
        }
    }
}

@Preview
@Composable
private fun MyUI1() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta, shape = RectangleShape)
        ) {
            drawLine(
                color = Color.Blue,
                strokeWidth = 2.dp.toPx(),
                start = Offset(x = size.width / 2, y = 0f),
                end = Offset(x = size.width / 2, y = size.height)
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawCircle(
                color = Color.Green.copy(alpha = 0.1f),
                radius = 90.dp.toPx() // bigger than Canvas
            )
        }
    }
}

@Preview
@Composable
private fun MyUI2() {
    Row {

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = true
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = -45f,
                sweepAngle = -90f,
                useCenter = true
            )
        }
    }
}

@Preview
@Composable
private fun MyUI3() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = 90f,
                sweepAngle = 180f,
                useCenter = true
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                brush = Brush.horizontalGradient(colors = listOf(Color.Yellow, Color.Green)),
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(x = 20.dp.toPx(), y = 20.dp.toPx()),
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI4() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = 45f,
                sweepAngle = -90f,
                useCenter = true
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = 45f,
                sweepAngle = -90f,
                useCenter = false
            )
        }
    }
}

@Preview
@Composable
private fun MyUI5() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = true
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(x = 35.dp.toPx(), y = 35.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI6() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                color = Color.Cyan,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = true,
                size = Size(width = 40.dp.toPx(), height = 40.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawArc(
                brush = Brush.horizontalGradient(colors = listOf(Color.Yellow, Color.Green)),
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = true
            )
        }
    }
}

@Preview
@Composable
private fun MyUI7() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawCircle(
                color = Color.Cyan
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawCircle(
                color = Color.Cyan,
                radius = 50.dp.toPx()
            )
        }
    }
}

@Preview
@Composable
private fun MyUI8() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawCircle(
                color = Color.Cyan,
                radius = 20.dp.toPx(),
                center = Offset(x = 30.dp.toPx(), y = 30.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawCircle(
                brush = Brush.horizontalGradient(colors = listOf(Color.Green, Color.Yellow)),
                radius = 50.dp.toPx()
            )
        }
    }
}

@Preview
@Composable
private fun MyUI9() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(color = Color.Magenta, width = 2.dp)
        ) {
            drawCircle(
                brush = Brush.horizontalGradient(colors = listOf(Color.Green, Color.Yellow)),
                radius = 25.dp.toPx(),
                style = Stroke(width = 2.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Spacer(modifier = Modifier.size(100.dp))
    }
}

@Preview
@Composable
private fun MyUI10() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRoundRect(
                color = Color.Red,
                size = Size(width = 50.dp.toPx(), height = 32.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRoundRect(
                color = Color.Red,
                size = Size(width = 50.dp.toPx(), height = 32.dp.toPx()),
                cornerRadius = CornerRadius(x = 16.dp.toPx(), 16.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI11() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRoundRect(
                color = Color.Red,
                size = Size(width = 50.dp.toPx(), height = 32.dp.toPx()),
                cornerRadius = CornerRadius(x = 36.dp.toPx(), 36.dp.toPx()),
                topLeft = Offset(x = 25.dp.toPx(), y = 35.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRoundRect(
                color = Color.Red,
                size = Size(width = 50.dp.toPx(), height = 32.dp.toPx()),
                cornerRadius = CornerRadius(x = 36.dp.toPx(), 36.dp.toPx()),
                topLeft = Offset(x = 25.dp.toPx(), y = 35.dp.toPx()),
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI12() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRoundRect(
                brush = Brush.horizontalGradient(colors = listOf(Color.Cyan, Color.Magenta)),
                size = Size(width = 50.dp.toPx(), height = 32.dp.toPx()),
                cornerRadius = CornerRadius(x = 36.dp.toPx(), 36.dp.toPx()),
                topLeft = Offset(x = 25.dp.toPx(), y = 35.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Spacer(modifier = Modifier.size(100.dp))
    }
}

@Preview
@Composable
private fun MyUI13() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRect(color = Color.Yellow)
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRect(
                color = Color.Yellow,
                size = Size(width = 65.dp.toPx(), height = 50.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI14() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRect(
                color = Color.Yellow,
                size = Size(width = 75.dp.toPx(), height = 50.dp.toPx()),
                topLeft = Offset(x = 15.dp.toPx(), y = 20.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRect(
                color = Color.Yellow,
                size = Size(width = 60.dp.toPx(), height = 30.dp.toPx()),
                topLeft = Offset(x = 50.dp.toPx(), y = 50.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI15() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRect(
                color = Color.Yellow,
                size = Size(width = 60.dp.toPx(), height = 50.dp.toPx()),
                topLeft = Offset(x = 30.dp.toPx(), y = 50.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRect(
                color = Color.Yellow,
                size = Size(width = 50.dp.toPx(), height = 40.dp.toPx()),
                topLeft = Offset(x = 30.dp.toPx(), y = 30.dp.toPx()),
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI16() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawRect(
                brush = Brush.horizontalGradient(listOf(Color.Magenta, Color.Yellow)),
                size = Size(width = 50.dp.toPx(), height = 40.dp.toPx()),
                topLeft = Offset(x = 25.dp.toPx(), y = 30.dp.toPx()),
                style = Stroke(width = 3.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Spacer(modifier = Modifier.size(100.dp))

    }
}

@Preview
@Composable
private fun MyUI17() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawOval(
                color = Color.Green,
                size = Size(width = 70.dp.toPx(), height = 40.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawOval(
                color = Color.Green,
                size = Size(width = 60.dp.toPx(), height = 63.dp.toPx()),
                topLeft = Offset(x = 20.dp.toPx(), y = 20.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI18() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawOval(
                color = Color.Green,
                size = Size(width = 60.dp.toPx(), height = 30.dp.toPx()),
                topLeft = Offset(x = 50.dp.toPx(), y = 50.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawOval(
                color = Color.Green,
                size = Size(width = 60.dp.toPx(), height = 20.dp.toPx()),
                topLeft = Offset(x = 20.dp.toPx(), y = 20.dp.toPx())
            )
        }
    }
}

@Preview
@Composable
private fun MyUI19() {
    Row {
        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawOval(
                color = Color.Green,
                size = Size(width = 60.dp.toPx(), height = 30.dp.toPx()),
                topLeft = Offset(x = 30.dp.toPx(), y = 20.dp.toPx()),
                style = Stroke(width = 2.dp.toPx())
            )
        }

        Spacer(modifier = Modifier.size(50.dp))

        Canvas(
            modifier = Modifier
                .size(size = 100.dp)
                .border(width = 2.dp, color = Color.Magenta)
        ) {
            drawOval(
                brush = Brush.horizontalGradient(listOf(Color.Cyan, Color.Blue)),
                size = Size(width = 40.dp.toPx(), height = 30.dp.toPx()),
                topLeft = Offset(x = 20.dp.toPx(), y = 20.dp.toPx()),
                style = Stroke(width = 2.dp.toPx())
            )
        }
    }
}