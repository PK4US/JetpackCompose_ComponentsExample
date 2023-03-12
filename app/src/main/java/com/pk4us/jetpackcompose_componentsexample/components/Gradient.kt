package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyGradientScreen() {
    Row(
        Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        MyGradientUI1()
        MyGradientUI2()
    }
}

@Preview
@Composable
fun MyGradientUI1() {
    Column() {
        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Cyan,
                            Color.Magenta
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "horizontal Gradient", color = Color.White, fontSize = 22.sp)
        }

        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(   //Список цветов. Вы должны указать не менее двух.
                            Color.Cyan,
                            Color.Magenta
                        ),
                        startX = 200f,      //начальная позиция x градиента. Его значение по умолчанию равно 0, что означает слева от области рисования.
                        endX = 400f         //конечная позиция x градиента. Его значение по умолчанию — Float.POSITIVE_INFINITY , что указывает на левую часть области рисования.
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Поменяли начальную и конечную позицию на startX = 200f  endX = 400f",
                color = Color.White,
                fontSize = 22.sp
            )
        }


        val pxStart = with(LocalDensity.current) { 100.dp.toPx() }
        val pxEnd = with(LocalDensity.current) { 250.dp.toPx() }
        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Cyan,
                            Color.Magenta
                        ),
                        startX = pxStart,
                        endX = pxEnd
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "установили точные позиции в dp на 100.dp и 250.dp",
                color = Color.White,
                fontSize = 22.sp
            )
        }

        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        0.0f to Color.Yellow,
                        0.5f to Color.Cyan,
                        1.0f to Color.Magenta,
                        startX = 0f,
                        endX = Float.POSITIVE_INFINITY
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Другой HorizontalGradient , который принимает цветовые точки 0.0f-Yellow 0.5f-Cyan 1.0f-Magenta",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}


@Preview
@Composable
fun MyGradientUI2() {

    Column {


        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Red, Color.Yellow)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "vertical Gradient", color = Color.White, fontSize = 22.sp)
        }

        // преобразовать размер окна в пиксели
        val boxSize1 = with(LocalDensity.current) { 300.dp.toPx() }
        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Green, Color.Yellow),
                        start = Offset(0f, 0f), // верхний левый угол
                        end = Offset(boxSize1, boxSize1) //правый нижний угол
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "linear Gradient", color = Color.White, fontSize = 22.sp)
        }

        // convert the box size to pixels
        val boxSize2 = with(LocalDensity.current) { 300.dp.toPx() }
        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color.Green, Color.Yellow),
                        center = Offset(x = boxSize2 / 2, y = boxSize2 / 2) // center
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "radial Gradient", color = Color.White, fontSize = 22.sp)
        }

        Box(
            modifier = Modifier
                .size(size = 150.dp)
                .background(
                    brush = Brush.sweepGradient(
                        colors = listOf(Color.Green, Color.Yellow),
                        center = Offset(x = boxSize2 / 2, y = boxSize2 / 2) // center
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "sweep Gradient", color = Color.White, fontSize = 22.sp)
        }
    }
}