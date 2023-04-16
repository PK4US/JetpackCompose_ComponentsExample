package com.pk4us.jetpackcompose_componentsexample.components

import android.view.MotionEvent
import androidx.compose.animation.Animatable
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.EnterExitState
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcompose_componentsexample.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MyAnimationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyAnimationUI1()
//        MyAnimationUI2()
//        MyAnimationUI3()
//        MyAnimationUI4()
//        MyAnimationUI5()
//        MyAnimationUI6()
//        MyAnimationUI7()
//        MyAnimationUI8()
//        MyAnimationUI9()

//        LoadingAnimation1()
//        LoadingAnimation2()
//        LoadingAnimation3()
//        LoadingAnimation4()

//        BoxSizeAnimation1()
//        BoxSizeAnimation2()
//        BoxSizeAnimation3()
//        BoxSizeAnimation4()
//        BoxSizeAnimation5()
//        BoxSizeAnimation6()
//        BoxSizeAnimation7()
//        BoxSizeAnimation8()
//        BoxSizeAnimation9()

//        MyAnimationUI10()
//        MyAnimationUI11()
//        MyAnimationUI12()
//        MyAnimationUI13()
//        MyAnimationUI14()

//        MyAnimationUI15()
//        MyAnimationUI16()

//        MyAnimationUI17()
//        MyAnimationUI18()
//        MyAnimationUI19()
//        MyAnimationUI20()
//        MyAnimationUI21()
//        MyAnimationUI22()

//        MyAnimationUI23()
    }
}

//__________________________________________________________________________________________________
@Preview
@Composable
fun MyAnimationUI1() {
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize by infiniteTransition.animateFloat(
        initialValue = 350.0f,
        targetValue = 450.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, delayMillis = 1000, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.heart),

            contentDescription = "heart",
            modifier = Modifier
                .size(heartSize.dp)
        )
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
private fun MyAnimationUI2() {
    val isNeedExpansion = rememberSaveable { mutableStateOf(false) }
    val animatedHeightDp: Dp by animateDpAsState(targetValue = if (isNeedExpansion.value) 350.dp else 100.dp)
    Column(
        modifier = Modifier
            .background(color = Color.DarkGray)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircleImage(animatedHeightDp)
        Button(
            onClick = { isNeedExpansion.value = !isNeedExpansion.value },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(("animateDpAsState"), color = Color.White)
        }
    }
}

@Composable
fun CircleImage(imageHeight: Dp) {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(imageHeight)
            .clip(CircleShape)                       // clip to the circle shape
            .border(3.dp, Color.Black, CircleShape)   // add a border (optional)
    )
}

//__________________________________________________________________________________________________

@Preview
@Composable
private fun MyAnimationUI3() {
    var isNeedColorChange by remember { mutableStateOf(false) }
    val startColor = Color.Blue
    val endColor = Color.Green
    val backgroundColor by animateColorAsState(
        if (isNeedColorChange) endColor else startColor,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 100,
            easing = LinearEasing
        )
    )
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(backgroundColor)
        )
        Button(
            onClick = { isNeedColorChange = !isNeedColorChange },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Switch Color")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyAnimationUI4() {
    val selected = remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (selected.value) 2f else 1f)

    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { },
            modifier = Modifier
                .scale(scale.value)
                .height(40.dp)
                .width(200.dp)
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            selected.value = true
                        }

                        MotionEvent.ACTION_UP -> {
                            selected.value = false
                        }
                    }
                    true
                }
        ) {
            Text(text = "Scale Animation", fontSize = 15.sp, color = Color.White)
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
private fun MyAnimationUI5() {
    var isAnimated by remember { mutableStateOf(false) }

    // Start with gray color and animate to green/red based on `button click`
    val color = remember { Animatable(Color.DarkGray) }
    LaunchedEffect(isAnimated) {
        color.animateTo(if (isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
    }
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
                .background(color.value)
        )
        Button(
            onClick = { isAnimated = !isAnimated },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Animate Color")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
private fun MyAnimationUI6() {
    var isAnimated by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isAnimated, label = "transition")

    val rocketOffset by transition.animateOffset(transitionSpec = {
        if (this.targetState) {
            tween(1000) // launch duration

        } else {
            tween(1500) // land duration
        }
    }, label = "rocket offset") { animated ->
        if (animated) Offset(200f, 0f) else Offset(200f, 500f)
    }

    val rocketSize by transition.animateDp(transitionSpec = {
        tween(1000)
    }, "") { animated ->
        if (animated) 75.dp else 150.dp
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rocket),
            contentDescription = "Rocket",
            modifier = Modifier
                .size(rocketSize)
                .alpha(1.0f)
                .offset(rocketOffset.x.dp, rocketOffset.y.dp)
        )
        Button(
            onClick = { isAnimated = !isAnimated },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = if (isAnimated) "Land rocket" else "Launch rocket")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
private fun MyAnimationUI7() {
    var isRotated by rememberSaveable { mutableStateOf(false) }
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360F else 0f,
        animationSpec = tween(durationMillis = 2500)
    )
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.fan),
            contentDescription = "fan",
            modifier = Modifier
                .rotate(rotationAngle)
                .size(150.dp)
        )

        Button(
            onClick = { isRotated = !isRotated },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(200.dp)
        ) {
            Text(text = "Rotate Fan")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@ExperimentalAnimationApi
@Composable
private fun MyAnimationUI8() {
    var isVisible by rememberSaveable { mutableStateOf(false) }
    Column {
        AnimatedVisibility(
            visible = isVisible,
            enter = expandIn(animationSpec = tween(2000)),
            exit = shrinkVertically(
                animationSpec = tween(
                    durationMillis = 1000,
                )
            )
        ) {
            CircleImage(300.dp)
        }
        Button(
            onClick = { isVisible = !isVisible },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp)
        ) {
            if (isVisible) {
                Text(text = "AnimatedVisibility \n(Press for Exit Animation)")
            } else {
                Text(text = "AnimatedVisibility \n(Press for Enter Animation)")

            }
        }

    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
private fun MyAnimationUI9() {
    var currentPage by remember { mutableStateOf("A") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Crossfade(targetState = currentPage, animationSpec = tween(3000)) { screen ->
            when (screen) {
                "A" -> Text(
                    "Page A", modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .background(Color.Red)
                )

                "B" -> Text(
                    "Page B", modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.85f)
                        .background(Color.Green)
                )
            }
        }
        Button(
            onClick = {
                if (currentPage.equals("A")) {
                    currentPage = "B"
                } else {
                    currentPage = "A"

                }
            },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp)
        ) {
            Text(text = "Cross fade Animation")
        }

    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun LoadingAnimation1() {

    // circle's scale state
    var circleScale by remember {
        mutableStateOf(0f)
    }

    // animation
    val circleScaleAnimate = animateFloatAsState(
        targetValue = circleScale,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000
            )
        )
    )

    // This is called when the app is launched
    LaunchedEffect(Unit) {
        circleScale = 1f
    }

    // animating circle
    Box(
        modifier = Modifier
            .size(size = 64.dp)
            .scale(scale = circleScaleAnimate.value)
            .border(
                width = 4.dp,
                color = Color.Magenta.copy(alpha = 1 - circleScaleAnimate.value),
                shape = CircleShape
            )
    ) {

    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun LoadingAnimation2() {

    // 3 circles
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            // Используем задержку сопрограммы для синхронизации анимации
            // делим задержку анимации на количество кругов
            delay(timeMillis = (1500 / 3L) * (index + 1))

            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 1500,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    // outer circle
    Box(
        modifier = Modifier
            .size(size = 200.dp)
            .background(color = Color.Transparent)
    ) {
        // animating circles
        circles.forEachIndexed { index, animatable ->
            Box(
                modifier = Modifier
                    .scale(scale = animatable.value)
                    .size(size = 200.dp)
                    .clip(shape = CircleShape)
                    .background(
                        color = Color.Magenta
                            .copy(alpha = (1 - animatable.value))
                    )
            ) {
            }
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun LoadingAnimation3() {

    // 3 circles
    val circles = listOf(
        remember { Animatable(initialValue = 0.3f) },
        remember { Animatable(initialValue = 0.3f) },
        remember { Animatable(initialValue = 0.3f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(Unit) {
            // Use coroutine delay to sync animations
            delay(timeMillis = (400 / circles.size).toLong() * index)

            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 400
                    ),
                    repeatMode = RepeatMode.Reverse
                )
            )
        }
    }

    // container for circles
    Row(
        modifier = Modifier
        //.border(width = 2.dp, color = Color.Magenta)
    ) {

        // adding each circle
        circles.forEachIndexed { index, animatable ->

            // gap between the circles
            if (index != 0) {
                Spacer(modifier = Modifier.width(width = 6.dp))
            }

            Box(
                modifier = Modifier
                    .size(size = 24.dp)
                    .clip(shape = CircleShape)
                    .background(
                        color = Color.Magenta
                            .copy(alpha = animatable.value)
                    )
            ) {
            }
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun LoadingAnimation4() {
    val infiniteTransition = rememberInfiniteTransition()
    val rotateAnimation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 360,
                easing = LinearEasing
            )
        )
    )

    CircularProgressIndicator(
        modifier = Modifier
            .size(size = 70.dp)
            .rotate(degrees = rotateAnimation)
            .border(
                width = 2.dp,
                brush = Brush.sweepGradient(
                    listOf(
                        Color(0xFF5851D8),
                        Color(0xFF833AB4),
                        Color(0xFFC13584),
                        Color(0xFFE1306C),
                        Color(0xFFFD1D1D),
                        Color(0xFFF56040),
                        Color(0xFFF77737),
                        Color(0xFFFCAF45),
                        Color(0xFFFFDC80),
                        Color(0xFF5851D8)
                    )
                ),
                shape = CircleShape
            ),
        progress = 1f,
        strokeWidth = 1.dp,
        color = MaterialTheme.colorScheme.background // Set background color
    )
}

//__________________________________________________________________________________________________
@Preview
@Composable
fun BoxSizeAnimation1() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(targetValue = 4f)
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation2() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = tween(
                            durationMillis = 2000,                  // продолжительность анимации в миллисекундах.
                            delayMillis = 1000,                     // вы можете отложить (или задержать) анимацию.
                            easing = FastOutLinearInEasing          // позволяет изменить скорость изменения анимации.
                            //FastOutSlowInEasing
                            //LinearOutSlowInEasing
                            //FastOutLinearEasing
                            //LinearEasing
                            //CubicBezierEasing
                        )
                    )
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation3() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioHighBouncy,        //определяет отскок анимации.
                            //Spring.DampingRatioNoBouncy
                            //Spring.DampingRatioLowBouncy
                            //Spring.DampingRatioMediumBouncy
                            //Spring.DampingRationHighBouncy
                            stiffness = Spring.StiffnessHigh                     //определяет, насколько быстро пружина должна двигаться к конечному значению.
                            //Spring.StiffnessHigh
                            //Spring.StiffnessMedium
                            //Spring.StiffnessMediumLow
                            //Spring.StiffnessLow
                            //Spring.StiffnessVeryLow
                        )
                    )
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation4() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = keyframes {
                            durationMillis = 4000
                            1f at 1000 with LinearOutSlowInEasing // 0 - 1000 ms
                            2f at 1100 with FastOutLinearInEasing // 1000 - 1100 ms
                            3f at 1200 // 1100 - 1200 ms
                            4f at 4000 // 1200 - 4000 ms
                        }
                    )
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation5() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = repeatable(
                            iterations = 3,                                 //сколько раз должна повторяться анимация (целочисленное значение).
                            animation = tween(durationMillis = 1000),       //это анимация, которая должна повторяться. Вы можете указать анимацию на основе продолжительности (например, tween или ключевые кадры ) .
                            repeatMode = RepeatMode.Reverse                 //должна ли анимация повторяться, начиная с начала ( RepeatMode.Restart ) или с конца ( RepeatMode.Reverse ).
                        )
                    )
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation6() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = infiniteRepeatable(
                            animation = tween(durationMillis = 1000),       //это анимация, которая должна повторяться. Вы можете указать анимацию на основе продолжительности (например, tween или ключевые кадры ) .
                            repeatMode = RepeatMode.Reverse                 //должна ли анимация повторяться, начиная с начала ( RepeatMode.Restart ) или с конца ( RepeatMode.Reverse ).
                        )
                    )
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation7() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = Color.Red)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = snap(delayMillis = 1000)
                    )
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation8() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }
    val color = remember { androidx.compose.animation.Animatable(initialValue = Color.Red) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = color.value)
            .clickable {
                coroutineScope.launch {
                    scale.animateTo(
                        targetValue = 4f,
                        animationSpec = tween(durationMillis = 2000)
                    )

                    color.animateTo(
                        targetValue = Color.Yellow,
                        animationSpec = tween(durationMillis = 2000)
                    )
                }
            }
    )
}

@Preview
@Composable
fun BoxSizeAnimation9() {
    val coroutineScope = rememberCoroutineScope()
    val scale = remember { Animatable(initialValue = 1f) }
    val color = remember { androidx.compose.animation.Animatable(initialValue = Color.Red) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .size(size = 40.dp)
            .background(color = color.value)
            .clickable {
                coroutineScope.launch {
                    launch {
                        scale.animateTo(
                            targetValue = 4f,
                            animationSpec = tween(durationMillis = 2000)
                        )
                    }

                    launch {
                        color.animateTo(
                            targetValue = Color.Yellow,
                            animationSpec = tween(durationMillis = 2000)
                        )
                    }
                }
            }
    )
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI10() {
    var size by remember { mutableStateOf(1f) }
    val animateScale by animateFloatAsState(targetValue = size)

    Box(
        modifier = Modifier
            .scale(scale = animateScale)
            .size(size = 50.dp)
            .background(color = Color.Red)
            .clickable {
                size = if (size == 2f) 1f else 2f
            }
    ) {

    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI11() {
    var size by remember { mutableStateOf(1f) }
    val animateScale by animateFloatAsState(
        targetValue = size,
        animationSpec = tween(durationMillis = 3000)
    )

    Box(
        modifier = Modifier
            .scale(scale = animateScale)
            .size(size = 50.dp)
            .background(color = Color.Red)
            .clickable {
                size = if (size == 2f) 1f else 2f
            }
    ) {
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI12() {
    var color by remember { mutableStateOf(Color.Red) }
    val animateColor by animateColorAsState(
        targetValue = color,
        animationSpec = tween(durationMillis = 3000)
    )

    Box(
        modifier = Modifier
            .size(size = 100.dp)
            .background(color = animateColor)
            .clickable {
                color = if (color == Color.Red) Color.Yellow else Color.Red
            }
    ) {
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI13() {
    var sizeDp by remember { mutableStateOf(50.dp) }
    val animateSize by animateDpAsState(
        targetValue = sizeDp,
        animationSpec = tween(durationMillis = 3000)
    )

    Box(
        modifier = Modifier
            .size(size = animateSize)
            .background(color = Color.Red)
            .clickable {
                sizeDp = if (sizeDp == 50.dp) 100.dp else 50.dp
            }
    ) {
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI14() {
    val transition = rememberInfiniteTransition()

    val scale by transition.animateFloat(
        initialValue = 1f,                                 //начальное значение анимации
        targetValue = 2f,                                //конечное значение анимации
        animationSpec = infiniteRepeatable(                //спецификация анимации.
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Icon(
        imageVector = Icons.Outlined.Favorite,
        contentDescription = "Favorite",
        tint = Color.Red,
        modifier = Modifier
            .scale(scale = scale)
            .size(size = 50.dp)
    )
}

//__________________________________________________________________________________________________

@ExperimentalAnimationApi
@Preview
@Composable
private fun MyAnimationUI15() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(true) }
        val visibleState = remember {
            MutableTransitionState(false).apply {
                targetState = true // start the animation immediately
            }
        }

        Box(modifier = Modifier.align(Alignment.TopStart)) {
            if (visible) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }

        }

        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            AnimatedVisibility(visible) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.TopEnd)) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .size(size = 120.dp)
                            .clip(shape = CircleShape)
                            .animateEnterExit(
                                enter = expandVertically(),
                                exit = shrinkHorizontally()
                            ),
                        painter = painterResource(id = R.drawable.dog),
                        contentDescription = "Dog",
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .animateEnterExit(
                                enter = slideInHorizontally(),
                                exit = slideOutHorizontally()
                            ),
                        text = "Frankie"
                    )
                }
            }
        }

        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                // this: AnimatedVisibilityScope
                // Use AnimatedVisibilityScope#transition to add a custom animation

                val backgroundColor by transition.animateColor(label = "ColorAnimation") { enterExistState ->
                    if (enterExistState == EnterExitState.Visible) Color.Green else Color.Yellow
                }

                Box(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .background(color = backgroundColor)
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(
                    visibleState = visibleState,
                    enter = fadeIn() + slideInHorizontally(),
                    exit = fadeOut() + slideOutHorizontally()
                ) {
                    Image(
                        modifier = Modifier
                            .size(size = 120.dp)
                            .clip(shape = CircleShape),
                        painter = painterResource(id = R.drawable.dog),
                        contentDescription = "Dog",
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = when {
                        visibleState.isIdle && visibleState.currentState -> "Visible" // enter transition is completed
                        !visibleState.isIdle && visibleState.currentState -> "Disappearing" // exit transition is running
                        visibleState.isIdle && !visibleState.currentState -> "Invisible" // exit transition is completed
                        else -> "Appearing" // enter transition is running
                    }
                )
            }
        }

        Box(modifier = Modifier.align(Alignment.Center)) {
            Column {
                Button(
                    onClick = { visible = !visible },
                    content = { Text(text = "Toggle Visibility") }
                )
                Button(
                    onClick = { visibleState.targetState = !visibleState.targetState },
                    content = { Text(text = "Toggle Visibility") }
                )
            }

        }
    }
}

//_________________________________________________________________________________________________________________________

@Preview
@ExperimentalAnimationApi
@Composable
private fun MyAnimationUI16() {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        var visible by remember { mutableStateOf(true) }

        Box(modifier = Modifier.align(Alignment.TopStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "fade")
        }

        Box(modifier = Modifier.align(Alignment.TopCenter)) {
            AnimatedVisibility(
                visible = visible,
                enter = slideInHorizontally(),
                exit = slideOutHorizontally()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "slideHorizontally")
        }

        Box(modifier = Modifier.align(Alignment.TopEnd)) {
            AnimatedVisibility(
                visible = visible,
                enter = slideInVertically(),
                exit = slideOutVertically()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "slideVertically")
        }

        Box(modifier = Modifier.align(Alignment.CenterStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = scaleIn(),
                exit = scaleOut()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "scale")
        }

        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            AnimatedVisibility(
                visible = visible,
                enter = expandIn(),
                exit = shrinkOut()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "expand")
        }

        Box(modifier = Modifier.align(Alignment.BottomStart)) {
            AnimatedVisibility(
                visible = visible,
                enter = expandHorizontally(),
                exit = shrinkHorizontally()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "expandHorizontally")
        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            AnimatedVisibility(
                visible = visible,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Image(
                    modifier = Modifier
                        .size(size = 120.dp)
                        .clip(shape = CircleShape),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "Dog",
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = "expandVertically")
        }

        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = { visible = !visible },
            content = { Text(text = "Click") }
        )
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI17() {

    var count by remember {
        mutableStateOf(0)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "$count", fontSize = 20.sp)

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@ExperimentalAnimationApi
@Composable
fun MyAnimationUI18() {
    var count by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedContent(targetState = count) { targetState ->
            Text(text = "$targetState", fontSize = 20.sp)
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@ExperimentalAnimationApi
@Composable
fun MyAnimationUI19() {
    var count by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                fadeIn() with fadeOut()
            }
        ) { targetCount ->
            Text(
                text = "$targetCount",
                fontSize = 20.sp
            )
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@ExperimentalAnimationApi
@Composable
fun MyAnimationUI20() {
    var count by remember { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                EnterTransition.None with ExitTransition.None
            }
        ) { targetCount ->
            Text(
                modifier = Modifier.animateEnterExit(
                    enter = scaleIn(),
                    exit = scaleOut()
                ),
                text = "$targetCount",
                fontSize = 20.sp
            )
        }

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                count++
            }
        ) {
            Text(text = "+")
        }
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI21() {

    val smallText = "Hello"
    val largeText = "Hello Android"

    var text by remember {
        mutableStateOf(smallText)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .animateContentSize()
                .background(color = Color.Yellow)
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable {
                    text = if (text == smallText) {
                        largeText
                    } else {
                        smallText
                    }
                },
            text = text,
            fontSize = 20.sp
        )
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyAnimationUI22() {

    val smallText = "Hello"
    val largeText =
        "Hello Android Hello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello AndroidHello Android"

    var text by remember {
        mutableStateOf(smallText)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = tween(durationMillis = 2000)
                )
                .background(color = Color.Yellow)
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable {
                    text = if (text == smallText) {
                        largeText
                    } else {
                        smallText
                    }
                },
            text = text,
            fontSize = 20.sp
        )
    }
}

//__________________________________________________________________________________________________

private enum class ImageState {
    Small, Large
}

@Preview
@Composable
fun MyAnimationUI23() {

    var imageState by remember {
        mutableStateOf(ImageState.Small)
    }

    val transition = updateTransition(targetState = imageState, label = "BoxState Transition")

    val borderColor by
    transition.animateColor(label = "BoxState Color Transition") {
        when (it) {
            ImageState.Small -> Color.Green
            ImageState.Large -> Color.Magenta
        }
    }

    val size by transition.animateDp(label = "BoxState Size Transition") {
        when (it) {
            ImageState.Small -> 90.dp
            ImageState.Large -> 130.dp
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .size(size = size)
                .clip(shape = CircleShape)
                .border(color = borderColor, shape = CircleShape, width = 3.dp),
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "Dog"
        )

        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                imageState =
                    if (imageState == ImageState.Small)
                        ImageState.Large
                    else
                        ImageState.Small
            }
        ) {
            Text(text = "Toggle State")
        }
    }
}

//__________________________________________________________________________________________________