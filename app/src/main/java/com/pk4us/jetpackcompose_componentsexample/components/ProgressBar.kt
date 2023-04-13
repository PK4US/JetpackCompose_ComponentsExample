package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pk4us.jetpackcompose_componentsexample.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.compose.foundation.*

@Preview
@Composable
fun MyProgressBarScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyProgressBar1()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar2()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar3()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar4()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar5()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar6()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar7()
        Spacer(modifier = Modifier.padding(10.dp))
        CircularProgressbar1()
        Spacer(modifier = Modifier.padding(10.dp))
        CircularProgressbar2()
        Spacer(modifier = Modifier.padding(10.dp))
        CircularProgressbar3()
        Spacer(modifier = Modifier.padding(10.dp))
        GradientProgressbar1()
        Spacer(modifier = Modifier.padding(10.dp))
        CircleProgress()
        Spacer(modifier = Modifier.padding(10.dp))
        LinerProgress()
        Spacer(modifier = Modifier.padding(10.dp))
        LinearExample()
        Spacer(modifier = Modifier.padding(10.dp))
        CircularExample()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar11()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar12()
        Spacer(modifier = Modifier.padding(10.dp))
        MyProgressBar13()
        Spacer(modifier = Modifier.padding(10.dp))
    }
}


@Composable
@Preview
fun MyProgressBar1() {
    LinearProgressIndicator(0.7f)
}


@Preview
@Composable
private fun MyProgressBar2() {
    LinearProgressIndicator(
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .height(4.dp),
        trackColor = Color.LightGray,
        color = Color.Blue
    )
}


@Composable
@Preview
fun MyProgressBar3() {
    CircularProgressIndicator()
}

@Composable
@Preview
fun MyProgressBar4() {
    CircularProgressIndicator(progress = 0.75f)
}


@Preview
@Composable
private fun MyProgressBar5() {
    val infiniteTransition = rememberInfiniteTransition()
    val progressAnimationValue by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 0.75f,
        animationSpec = infiniteRepeatable(animation = tween(10000))
    )
    CircularProgressIndicator(progress = progressAnimationValue)
}


@Preview
@Composable
private fun MyProgressBar6() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = Color.Blue,
        strokeWidth = 4.dp
    )
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyProgressBar7() {
    var dataR by remember { mutableStateOf(-1f) }
    val gapBetweenEnds = (150f - 90) * 2
    val animateNumber = animateFloatAsState(
        targetValue = dataR,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    LaunchedEffect(Unit) {
        dataR = 128f
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = 250.dp)
    ) {
        Canvas(
            modifier = Modifier
                .size(size = 250.dp)
        ) {
            drawArc(
                color = Color.LightGray.copy(alpha = 0.2f),
                startAngle = 150f,
                sweepAngle = 360f - gapBetweenEnds,
                useCenter = false,
                style = Stroke(width = 64.dp.toPx(), cap = StrokeCap.Round)
            )

            drawArc(
                color = Color(0xFF35898f),
                startAngle = 150f,
                sweepAngle = (animateNumber.value / 100f) * (360f - gapBetweenEnds),
                useCenter = false,
                style = Stroke(64.dp.toPx(), cap = StrokeCap.Round)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = (animateNumber.value).toInt().toString() + " GB",
                style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "занято",
                style = TextStyle(fontSize = 16.sp)
            )
        }
    }

    Button(
        onClick = {
            dataR = (0 until 100f.toInt()).random().toFloat()
        },
        colors = ButtonDefaults.buttonColors(
            Color(0xFF35898f)
        )
    ) {
        Text(
            text = "Анимация со случайным значением",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}

//__________________________________________________________________________________________________


@Composable
fun CircularProgressbar1(
    size: Dp = 130.dp,
    foregroundIndicatorColor: Color = Color(0xFF35898f),
    shadowColor: Color = Color.LightGray,
    indicatorThickness: Dp = 24.dp,
    dataUsage: Float = 60f,
    animationDuration: Int = 1000,
    dataTextStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
        fontSize = 24.sp
    ),
    remainingTextStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
        fontSize = 16.sp
    )
) {

    // It remembers the data usage value
    var dataUsageRemember by remember {
        mutableStateOf(-1f)
    }

    // This is to animate the foreground indicator
    val dataUsageAnimate = animateFloatAsState(
        targetValue = dataUsageRemember,
        animationSpec = tween(
            durationMillis = animationDuration
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        dataUsageRemember = dataUsage
    }

    Box(
        modifier = Modifier
            .size(size),
        contentAlignment = Alignment.Center
    ) {

        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .size(size)
        ) {

            // For shadow
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(shadowColor, Color.White),
                    center = Offset(x = this.size.width / 2, y = this.size.height / 2),
                    radius = this.size.height / 2
                ),
                radius = this.size.height / 2,
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // This is the white circle that appears on the top of the shadow circle
            drawCircle(
                color = Color.White,
                radius = (size / 2 - indicatorThickness).toPx(),
                center = Offset(x = this.size.width / 2, y = this.size.height / 2)
            )

            // Convert the dataUsage to angle
            val sweepAngle = (dataUsageAnimate.value) * 360 / 100

            // Foreground indicator
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round),
                size = Size(
                    width = (size - indicatorThickness).toPx(),
                    height = (size - indicatorThickness).toPx()
                ),
                topLeft = Offset(
                    x = (indicatorThickness / 2).toPx(),
                    y = (indicatorThickness / 2).toPx()
                )
            )
        }

        // Display the data usage value
        DisplayText(
            animateNumber = dataUsageAnimate,
            dataTextStyle = dataTextStyle,
            remainingTextStyle = remainingTextStyle
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

    ButtonProgressbar {
        dataUsageRemember = (0 until 100).random().toFloat()
    }

}

@Composable
fun CircularProgressbar2(
    number: Float = 60f,
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    size: Dp = 120.dp,
    thickness: Dp = 16.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    foregroundIndicatorColor: Color = Color(0xFF35898f),
    backgroundIndicatorColor: Color = foregroundIndicatorColor.copy(alpha = 0.5f),
    extraSizeForegroundIndicator: Dp = 12.dp
) {

    // It remembers the number value
    var numberR by remember {
        mutableStateOf(-1f)
    }

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = numberR,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        numberR = number
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
    ) {
        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .size(size = size)
        ) {

            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = size.toPx() / 2,
                style = Stroke(width = thickness.toPx(), cap = StrokeCap.Round)
            )

            val sweepAngle = (animateNumber.value / 100) * 360

            // Foreground circle
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(
                    (thickness + extraSizeForegroundIndicator).toPx(),
                    cap = StrokeCap.Butt
                )
            )
        }

        // Text that shows number inside the circle
        Text(
            text = (animateNumber.value).toInt().toString(),
            style = numberStyle
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

    ButtonProgressbar {
        numberR = (1..100).random().toFloat()
    }
}

@Composable
fun CircularProgressbar3(
    number: Float = 70f,
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    size: Dp = 120.dp,
    indicatorThickness: Dp = 28.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    foregroundIndicatorColor: Color = Color(0xFF35898f),
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f)
) {

    // It remembers the number value
    var numberR by remember {
        mutableStateOf(0f)
    }

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = numberR,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        numberR = number
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
    ) {
        androidx.compose.foundation.Canvas(
            modifier = Modifier
                .size(size = size)
        ) {

            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = size.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )

            val sweepAngle = (animateNumber.value / 100) * 360

            // Foreground circle
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
        }

        // Text that shows number inside the circle
        Text(
            text = (animateNumber.value).toInt().toString(),
            style = numberStyle
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

    ButtonProgressbar {
        numberR = (1..100).random().toFloat()
    }
}


@Composable
private fun DisplayText(
    animateNumber: State<Float>,
    dataTextStyle: TextStyle,
    remainingTextStyle: TextStyle
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Text that shows the number inside the circle
        Text(
            text = (animateNumber.value).toInt().toString() + " GB",
            style = dataTextStyle
        )
    }
}

@Composable
private fun ButtonProgressbar(
    backgroundColor: Color = Color(0xFF35898f),
    onClickButton: () -> Unit
) {
    Button(
        onClick = {
            onClickButton()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(
            text = "Animate",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}


@Composable
fun GradientProgressbar1(
    viewModel: MyViewModelProgressBar = androidx.lifecycle.viewmodel.compose.viewModel(),
    indicatorHeight: Dp = 24.dp,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f),
    indicatorPadding: Dp = 24.dp,
    gradientColors: List<Color> = listOf(
        Color(0xFF6ce0c4),
        Color(0xFF40c7e7),
        Color(0xFF6ce0c4),
        Color(0xFF40c7e7)
    ),
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
        fontSize = 32.sp
    ),
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    val downloadedPercentage by viewModel.downloadedPercentage.observeAsState(initial = 0f)

    val animateNumber = animateFloatAsState(
        targetValue = downloadedPercentage,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    LaunchedEffect(Unit) {
        viewModel.startThreadGradient()
    }

    androidx.compose.foundation.Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(indicatorHeight)
            .padding(start = indicatorPadding, end = indicatorPadding)
    ) {

        // Background indicator
        drawLine(
            color = backgroundIndicatorColor,
            cap = StrokeCap.Round,
            strokeWidth = size.height,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f)
        )

        // Convert the downloaded percentage into progress (width of foreground indicator)
        val progress =
            (animateNumber.value / 100) * size.width // size.width returns the width of the canvas

        // Foreground indicator
        drawLine(
            brush = Brush.linearGradient(
                colors = gradientColors
            ),
            cap = StrokeCap.Round,
            strokeWidth = size.height,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = progress, y = 0f)
        )

    }

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = downloadedPercentage.toInt().toString() + "%",
        style = numberStyle
    )

}

class MyViewModelProgressBar : ViewModel() {

    var downloadedPercentage = MutableLiveData<Float>()

    fun startThreadGradient() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {

                val totalDownloadSize = 1024f
                var downloadedSize = 0f

                while (true) {

                    downloadedSize += ((1..100).random().toFloat())

                    if (downloadedSize < totalDownloadSize) {
                        withContext(Dispatchers.Main) {
                            downloadedPercentage.value =
                                ((downloadedSize / totalDownloadSize) * 100)
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            downloadedPercentage.value = 100f
                        }
                        break
                    }

                    delay(1000)
                }

            }
        }
    }
}


@Preview
@Composable
fun CircleProgress() {
    var progress by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Card(Modifier.size(width = 300.dp, height = 200.dp)) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Статус: $progress", fontSize = 22.sp)
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            while (progress < 1f) {
                                progress += 0.1f
                                delay(1000L)
                            }
                        }
                    }
                ) {
                    Text("Запустить", fontSize = 22.sp)
                }
                CircularProgressIndicator(progress = progress)
            }
        }
    }
}

@Preview
@Composable
fun LinerProgress() {
    var progress by remember { mutableStateOf(0.0f) }
    val scope = rememberCoroutineScope()

    Column(
    ) {
        Card(Modifier.size(width = 300.dp, height = 200.dp)) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Статус: $progress", fontSize = 22.sp)
                OutlinedButton(
                    modifier = Modifier.padding(20.dp),
                    onClick = {
                        scope.launch {
                            while (progress < 1f) {
                                progress += 0.1f
                                delay(1000L)
                            }
                        }
                    }
                ) {
                    Text("Запустить", fontSize = 22.sp)
                }
                LinearProgressIndicator(progress = progress)
            }
        }
    }
}


@Preview
@Composable
fun LinearExample() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var progress by remember { mutableStateOf(0.1f) }
        val animatedProgress by animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LinearProgressIndicator(
                modifier = Modifier
                    .semantics(mergeDescendants = true) {}
                    .padding(10.dp),
                progress = animatedProgress,
            )
            Spacer(Modifier.requiredHeight(30.dp))
            OutlinedButton(
                modifier = Modifier.semantics {
                    val progressPercent = (progress * 100).toInt()
                    stateDescription = "Progress $progressPercent%"
                },
                onClick = {
                    if (progress < 1f) progress += 0.1f
                }
            ) {
                Text("Increase")
            }
        }
    }
}

@Preview
@Composable
fun CircularExample() {

    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(progress = animatedProgress)
        Spacer(Modifier.requiredHeight(30.dp))
        OutlinedButton(
            modifier = Modifier.semantics {
                val progressPercent = (progress * 100).toInt()

                stateDescription = "Progress $progressPercent%"

            },
            onClick = {
                if (progress < 1f) progress += 0.1f
            }
        ) {
            Text("Increase")
        }
    }
}


@Preview
@Composable
fun MyProgressBar11() {
    CircularProgressIndicator(
        progress = 0.6f,
        modifier = Modifier.size(size = 64.dp),
        color = Color.Magenta,
        strokeWidth = 6.dp
    )
}

@Preview
@Composable
fun MyProgressBar12() {
    Column {
        // progress value
        var progress by remember {
            mutableStateOf(0f) // initially 0f
        }

        // For animation
        val progressAnimate by animateFloatAsState(
            targetValue = progress,
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
        )

        CircularProgressIndicator(
            progress = progressAnimate,
            modifier = Modifier.size(size = 64.dp),
            color = Color.Magenta,
            strokeWidth = 6.dp
        )

        // This is called when the Activity is launched
        LaunchedEffect(Unit) {
            progress = 0.6f
        }

        // Add space between indicator and button
        Spacer(modifier = Modifier.height(height = 16.dp))

        Button(
            onClick = {
                progress = (0 until 100).random().toFloat() / 100
            },
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(
                text = "Random",
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun MyProgressBar13() {

    CircularProgressIndicator(
        progress = 0.6f,
        modifier = Modifier
            .size(size = 64.dp)
            .rotate(degrees = 45f),
        color = Color.Magenta,
        strokeWidth = 6.dp
    )
}