package com.pk4us.jetpackcompose_componentsexample.components

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ButtonScreen() {
    Column(
        Modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Buttons()
        OutlinedButton()
        MusicButton()
        GradientButton()
        ButtonCount()
        GradientBorderButtonClick()
        ButtonAnimation()
        ButtonsMaterial()
        FloatingActionButtons()
        ExtendedFABs()
        IconButtons()
    }
}


@Preview
@Composable
fun Buttons() {
    Column {
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            content = { Text(text = "Button with gray background", color = Color.White) })

        Button(onClick = {}, content = {
            Text(text = "Click ", color = Color.Magenta)
            Text(text = "Here", color = Color.Green)
        })

        Button(onClick = {}, content = {
            Image(
                painterResource(id = R.drawable.ic_cart),
                contentDescription = "Cart button icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "Add to cart", Modifier.padding(start = 10.dp))
        })

        Button(onClick = {}, shape = RectangleShape, content = { Text(text = "Rectangle shape") })

        Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
            Text(text = "Round corner shape")
        }

        Button(onClick = {}, shape = CutCornerShape(15)) {
            Text(text = "Cut corner shape")
        }

        Button(
            onClick = {},
            border = BorderStroke(1.dp, Color.Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text(text = "Button with border", color = Color.DarkGray)
        }

        Button(
            onClick = {},
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp, pressedElevation = 15.dp, disabledElevation = 0.dp
            ),
            content = { Text(text = "Button with elevation") }
        )
    }
}

@Preview
@Composable
fun OutlinedButton() {
    Column {
        var enabled1 by remember { mutableStateOf(true) }
        OutlinedButton(
            enabled = enabled1,
            onClick = {
                enabled1 = false
            }
        ) {
            Text(
                text = if (enabled1) "Disable Me" else "I'm Disabled",
                style = TextStyle(
                    color = if (enabled1) Color.Cyan else Color.LightGray,
                    fontSize = 20.sp
                )
            )
        }

        val context2: Context = LocalContext.current.applicationContext
        TextButton(
            onClick = {
                Toast.makeText(context2, "Click", Toast.LENGTH_SHORT).show()
            }) {
            Text(text = "Text Button")
        }

        val context3: Context = LocalContext.current.applicationContext
        IconButton(
            onClick = {
                Toast.makeText(context3, "Click", Toast.LENGTH_SHORT).show()
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.Share,
                contentDescription = "Click to share",
                tint = Color.Red
            )
        }

        var checked4 by remember { mutableStateOf(false) }
        val interactionSource4 = remember { MutableInteractionSource() }
        IconToggleButton(
            checked = checked4,
            onCheckedChange = {
                checked4 = it
            }
        ) {
            val tint by animateColorAsState(
                targetValue = if (checked4) Color.Magenta else Color.LightGray
            )

            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Favorite Item",
                modifier = Modifier
                    .clickable(
                        indication = null, // Assign null to disable the ripple effect
                        interactionSource = interactionSource4
                    ) {
                        checked4 = !checked4
                    }
                    .size(48.dp),
                tint = tint
            )
        }
    }
}

//__________________________________________________________________________________________________

private const val playIcon = 1
private const val loadingBar = 2
private const val pauseIcon = 3

@Preview
@Composable
fun MusicButton(
    viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    context: Context = LocalContext.current.applicationContext
) {
    val songLoaded by viewModel.songLoaded.observeAsState(false)
    var buttonIcon by remember { mutableStateOf(playIcon) }

    OutlinedButton(
        modifier = Modifier
            .size(72.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(12.dp),
        elevation = ButtonDefaults.buttonElevation(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            Color(0xFF35898F)
        ),
        border = BorderStroke(0.dp, Color.Transparent),
        onClick = {
            if (!songLoaded) {
                // Если песня НЕ загружена

                Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()

                viewModel.loadTheSong()

                // Назначаем buttonIcon для loadingBar, чтобы отображался индикатор прогресса
                buttonIcon = loadingBar
            } else {
                // Если песня уже загружена

                if (buttonIcon == playIcon) {
                    // Если текущая иконка — play Icon
                    // изменить его на значок паузы
                    buttonIcon = pauseIcon
                } else if (buttonIcon == pauseIcon) {
                    // Если текущая иконка — иконка паузы
                    // изменить его на значок воспроизведения
                    buttonIcon = playIcon
                }
            }
        }
    ) {

        when (buttonIcon) {
            loadingBar -> {
                if (songLoaded) {
                    // Если песня уже загружена
                    // устанавливаем значок паузы
                    buttonIcon = pauseIcon
                } else {
                    // Если песня НЕ загружена
                    // показать индикатор прогресса
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        color = Color.White
                    )
                }
            }
            playIcon -> {
                // Установите значок воспроизведения
                SetButtonIcon1(
                    icon = Icons.Filled.PlayArrow,
                    iconDescription = "Play Song"
                )

                // Если песня загружена, приостановите фактическую песню
                if (songLoaded) {
                    pauseTheSong(context = context)
                }
            }
            pauseIcon -> {
                // Установить значок паузы
                SetButtonIcon1(icon = Icons.Filled.Check, iconDescription = "Pause Song")

                // Если песня загружена, воспроизвести настоящую песню
                if (songLoaded) {
                    playTheSong(context = context)
                }
            }
        }
    }
}

private fun playTheSong(context: Context) {
    // Здесь играем песню
    Log.i("SemicolonSpace", "playTheSong()")
    Toast.makeText(context, "Playing....", Toast.LENGTH_SHORT).show()
}

private fun pauseTheSong(context: Context) {
    // Здесь пауза в песне
    Log.i("SemicolonSpace", "pauseTheSong")
    Toast.makeText(context, "Paused", Toast.LENGTH_SHORT).show()
}

@Composable
private fun SetButtonIcon1(
    icon: ImageVector,
    iconDescription: String
) {
    Icon(
        modifier = Modifier
            .fillMaxSize(),
        imageVector = icon,
        contentDescription = iconDescription,
        tint = Color.White
    )
}

class MyViewModel : ViewModel() {

    // Музыкальная кнопка
    val songLoaded = MutableLiveData<Boolean>()

    fun loadTheSong() {

        viewModelScope.launch {

            withContext(Dispatchers.Default) {
                // Выполняем фоновую задачу, чтобы получить песню
                // После завершения задачи вызываем songLoadedSuccessful()
                // Вместо фоновой задачи я устанавливаю задержку в 4 секунды
                delay(4000)
            }
            songLoadedSuccessful()
        }
    }

    private fun songLoadedSuccessful() {
        songLoaded.value = true
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
private fun GradientButton(
) {
    Column {
        val gradientColors1 = listOf(Color(0xFFFFF000), Color(0xFFFF0000))
        var clickCount1 by remember { mutableStateOf(0) }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            onClick = { clickCount1++ },
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            shape = RoundedCornerShape(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(colors = gradientColors1),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Click $clickCount1",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }


        val gradientColors2 = listOf(Color(0xFFFFF000), Color(0xFFFF0000))
        var enabled2 by remember { mutableStateOf(true) }
        val disabledColors2 = listOf(Color.Transparent, Color.Transparent)
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp),
            onClick = {
                enabled2 = false
            },
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                Color.Transparent
            ),
            shape = RoundedCornerShape(16.dp),
            enabled = enabled2,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(colors = if (enabled2) gradientColors2 else disabledColors2),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (enabled2) "Disable Me" else "I'm Disabled!",
                    fontSize = 20.sp,
                    color = if (enabled2) Color.White else Color.Black.copy(alpha = 0.6F)
                )
            }
        }

        val gradientColors3 = listOf(Color(0xFFFFF000), Color(0xFFFF0000))
        val interactionSource3 = remember { MutableInteractionSource() }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp)
                .background(
                    brush = Brush.linearGradient(colors = gradientColors3),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .clickable(
                    indication = null, // Assign null to disable the ripple effect
                    interactionSource = interactionSource3
                ) {},
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No Ripple",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview
@Composable
fun ButtonCount() {
    Column {
        var clickCount1 by remember { mutableStateOf(0) }
        Box(
            modifier = Modifier
                .background(
                    color = Color.Blue,
                    shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp)
                )
                .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
                .clickable {
                    clickCount1++
                }
                .padding(PaddingValues(horizontal = 80.dp, vertical = 30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Click $clickCount1",
            )
        }

        var enabled2 by remember { mutableStateOf(true) }
        Box(
            modifier = Modifier
                .background(
                    color = if (enabled2) Color.Green else Color.Gray,
                    shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp)
                )
                .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
                .clickable(enabled = enabled2) { enabled2 = false }
                .padding(PaddingValues(horizontal = 80.dp, vertical = 30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (enabled2) "Disable Me!" else "I'm Disabled!",
            )
        }

        val context3: Context = LocalContext.current.applicationContext
        val interactionSource3 = MutableInteractionSource()
        Box(
            modifier = Modifier
                .background(
                    color = Color.Magenta,
                    shape = RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp)
                )
                .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 50.dp))
                .clickable(indication = null, interactionSource = interactionSource3) {
                    Toast
                        .makeText(context3, "No Ripple", Toast.LENGTH_SHORT)
                        .show()
                }
                .padding(PaddingValues(horizontal = 80.dp, vertical = 30.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No touch",
            )
        }
    }
}

@Preview
@Composable
fun GradientBorderButtonClick() {

    Column {
        var clickCount1 by remember { mutableStateOf(0) }
        val interactionSource1 = remember { MutableInteractionSource() }
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.7f)
                .border(
                    width = 4.dp,
                    brush = Brush.horizontalGradient(colors = listOf(Color.Yellow, Color.Red)),
                    shape = RectangleShape
                )
                .clickable(
                    interactionSource = interactionSource1,
                    indication = null // To disable ripple
                ) {
                    clickCount1++
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Click $clickCount1",
                fontSize = 26.sp,
                modifier = Modifier.padding(PaddingValues(horizontal = 24.dp, vertical = 12.dp)),
                fontWeight = FontWeight.Medium
            )
        }


        val context2 = LocalContext.current.applicationContext
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.7f)
                .border(
                    width = 4.dp,
                    brush = Brush.horizontalGradient(colors = listOf(Color.Yellow, Color.Red)),
                    shape = RoundedCornerShape(percent = 50)
                )
                // To make the ripple round
                .clip(shape = RoundedCornerShape(percent = 50))
                .clickable {
                    Toast
                        .makeText(context2, "Round Button Click", Toast.LENGTH_SHORT)
                        .show()
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Round Button",
                fontSize = 26.sp,
                modifier = Modifier.padding(PaddingValues(horizontal = 24.dp, vertical = 12.dp)),
                fontWeight = FontWeight.Medium
            )
        }

        val disabledColor3 = Color.Gray.copy(alpha = 0.3f)
        var enabled3 by remember { mutableStateOf(true) }
        Box(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.68f)
                .border(
                    width = 4.dp,
                    brush = Brush.horizontalGradient(
                        colors = if (enabled3) listOf(Color.Yellow, Color.Red)
                        else listOf(disabledColor3, disabledColor3)
                    ),
                    shape = RectangleShape
                )
                .clickable(enabled = enabled3) {
                    enabled3 = false
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (enabled3) "Disable Me" else "I'm Disabled",
                fontSize = 26.sp,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp),
                fontWeight = FontWeight.Medium,
                color = if (enabled3) Color.Black else disabledColor3
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun ButtonAnimation() {
    Column {
        val interactionSource = MutableInteractionSource()
        val coroutineScope = rememberCoroutineScope()
        val scale = remember { Animatable(1f) }
        Box(
            modifier = Modifier
                .scale(scale = scale.value)
                .background(
                    color = Color(0xFF35898F),
                    shape = RoundedCornerShape(size = 12f)
                )
                .clickable(interactionSource = interactionSource, indication = null) {
                    coroutineScope.launch {
                        scale.animateTo(
                            0.9f,
                            animationSpec = tween(100),
                        )
                        scale.animateTo(
                            1f,
                            animationSpec = tween(100),
                        )
                    }
                }
        ) {
            Text(
                text = "Button Animation",
                modifier = Modifier.padding(horizontal = 36.dp, vertical = 12.dp),
                fontSize = 26.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        }


        val coroutineScope2 = rememberCoroutineScope()
        var enabled2 by remember { mutableStateOf(false) }
        val scale2 = remember { Animatable(1f) }

        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Like the product",
            tint = if (enabled2) Color.Red else Color.LightGray,
            modifier = Modifier
                .scale(scale = scale2.value)
                .size(size = 100.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    enabled2 = !enabled2
                    coroutineScope2.launch {
                        scale2.animateTo(
                            0.8f,
                            animationSpec = tween(100),
                        )
                        scale2.animateTo(
                            1f,
                            animationSpec = tween(100),
                        )
                    }
                }
        )

        var count3 by remember { mutableStateOf(0) }
        var oldCount3 by remember { mutableStateOf(count3) }
        SideEffect { oldCount3 = count3 }
        Row(
        ) {
            Button(onClick = { count3++ }) {
                Text(text = "Увеличить")
            }
            val countString = count3.toString()
            val oldCountString = oldCount3.toString()
            for (i in countString.indices) {
                val oldChar = oldCountString.getOrNull(i)
                val newChar = countString[i]
                val char = if (oldChar == newChar) {
                    oldCountString[i]
                } else {
                    countString[i]
                }
                AnimatedContent(
                    targetState = char,
                    transitionSpec = {
                        slideInVertically { it } with slideOutVertically { -it }
                    }
                ) { char ->
                    Text(
                        text = char.toString(),
                        softWrap = false,
                        fontSize = 46.sp
                    )
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ButtonsMaterial() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedButton(onClick = { /* Do something! */ }) { Text("Elevated Button") }
        Button(onClick = { /* Do something! */ }) { Text("Filled Button") }
        FilledTonalButton(onClick = { /* Do something! */ }) { Text("Filled Tonal Button") }
        OutlinedButton(onClick = { /* Do something! */ }) { Text("Outlined Button") }
        TextButton(onClick = { /* Do something! */ }) { Text("Text Button") }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun FloatingActionButtons() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(Icons.Filled.Add, "Localized description")
        }

        SmallFloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Localized description",
            )
        }

        LargeFloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Localized description",
                modifier = Modifier.size(FloatingActionButtonDefaults.LargeIconSize)
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun ExtendedFABs() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ExtendedFloatingActionButton(
            onClick = { /* do something */ },
            icon = { Icon(Icons.Filled.Add, "Localized description") },
            text = { Text(text = "Extended FAB") },
        )

        ExtendedFloatingActionButton(onClick = { /* do something */ }) {
            Text(text = "Extended FAB")
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun IconButtons() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            //1. Standard icon button
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            var checked by remember { mutableStateOf(false) }
            IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                if (checked) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }
        }

        Row {
            //2. Contained icon button (including filled, filled tonal, and outlined styles)
            var checked by remember { mutableStateOf(false) }
            var checked2 by remember { mutableStateOf(false) }

            FilledIconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            FilledIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                if (checked) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }

            FilledTonalIconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            FilledTonalIconToggleButton(checked = checked2, onCheckedChange = { checked2 = it }) {
                if (checked2) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }
            }
        }


        Row {
            var checked by remember { mutableStateOf(false) }

            OutlinedIconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
            }

            OutlinedIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                if (checked) {
                    Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                } else {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")

                }
            }
        }
    }
}