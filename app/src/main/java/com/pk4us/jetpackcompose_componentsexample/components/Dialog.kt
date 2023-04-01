package com.pk4us.jetpackcompose_componentsexample.components

import android.widget.Toast
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pk4us.jetpackcompose_componentsexample.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyDialogScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyDialogExample1()
        MyDialogExample2()
        MyDialogExample3()
        MyDialogExample4()
        MyDialogExample5()
        MyDialogExample6()
        MyDialogExample7()
        MyDialogExample8()
        MyDialogExample9()
        MyDialogExample10()
    }
}

@Composable
fun MyDialogExample1() {

    var dialogOpen by remember {
        mutableStateOf(false)
    }

    if (dialogOpen) {
        Dialog(onDismissRequest = {
            dialogOpen = false
        }) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(size = 10.dp)
            ) {
                Column(modifier = Modifier.padding(all = 16.dp)) {
                    Text(text = "Диалог")
                }
            }
        }
    }

    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN 1")
    }
}

@Composable
fun MyDialogExample2() {
    var dialogOpen by remember { mutableStateOf(false) }

    if (dialogOpen) {
        AlertDialog(
            onDismissRequest = { dialogOpen = false },
            confirmButton = {
                Button(onClick = {
                    dialogOpen = false
                }) {
                    Text(text = "Подтвердить")
                }
            },
            dismissButton = {
                Button(onClick = {
                    dialogOpen = false
                }) {
                    Text(text = "Отклонить")
                }
            },
            title = {
                Text(text = "Заголовок")
            },
            text = {
                Text(text = "Описание")
            },
            modifier = Modifier // Set the width and padding
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(5.dp),
            containerColor = Color.White,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN 2")
    }
}


@ExperimentalMaterial3Api
@Composable
fun MyDialogExample3() {
    var dialogOpen by remember {
        mutableStateOf(false)
    }
    if (dialogOpen) {
        Dialog(
            onDismissRequest = { dialogOpen = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(90.dp),
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = { dialogOpen = false }) {
                        Text(text = "Закрыть")
                    }
                }
            }
        }
    }
    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN 3")
    }
}


@ExperimentalMaterial3Api
@Composable
fun MyDialogExample4() {
    var dialogOpen by remember {
        mutableStateOf(false)
    }
    if (dialogOpen) {
        AlertDialog(onDismissRequest = {
            dialogOpen = false
        }) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Эта область обычно содержит вспомогательный текст в котором представлены подробности о цели диалога.",
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    TextButton(
                        onClick = {
                            dialogOpen = false
                        }, modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Подтверждать")
                    }
                }
            }
        }
    }
    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN 4")
    }
}


@ExperimentalMaterial3Api
@Composable
fun MyDialogExample5() {
    var dialogOpen by remember {
        mutableStateOf(false)
    }

    if (dialogOpen) {
        AlertDialog(
            onDismissRequest = {

                dialogOpen = false
            },
            icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
            title = {
                Text(text = "Заголовок")
            },
            text = {
                Text(
                    text = "Эта область обычно содержит вспомогательный текст в котором представлены подробности о цели диалога.",
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        dialogOpen = false
                    }
                ) {
                    Text("Подтверждать")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        dialogOpen = false
                    }
                ) {
                    Text("Закрыть")
                }
            }
        )
    }
    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN 5")
    }
}

@Composable
fun MyDialogExample6() {
    var dialogOpen by remember { mutableStateOf(false) }
    val context = LocalContext.current.applicationContext
    if (dialogOpen) {
        Dialog(
            onDismissRequest = {
                dialogOpen = false
            },
            properties = DialogProperties(
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.medal),
                        contentDescription = "Medal icon",
                        tint = Color(0xFF35898F),
                        modifier = Modifier.size(size = 150.dp)
                    )

                    Text(
                        text = "Поздравляем!",
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 26.dp),
                        fontFamily = FontFamily(
                            Font(
                                resId = R.font.roboto_bold,
                                weight = FontWeight.Bold
                            )
                        )
                    )

                    Text(
                        text = "Ты выиграл медаль",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 20.dp),
                        fontFamily = FontFamily(
                            Font(
                                resId = R.font.roboto_regular,
                                weight = FontWeight.Normal
                            )
                        )
                    )

                    Button(
                        onClick = {
                            Toast.makeText(context, "Share Button", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.padding(top = 20.dp),
                        shape = RoundedCornerShape(percent = 25),
                        colors = ButtonDefaults.buttonColors(
                            Color(0xFF35898F), contentColor = Color.White
                        ),
                    ) {
                        Text(
                            text = "Поделиться",
                            fontFamily = FontFamily(
                                Font(
                                    resId = R.font.roboto_medium,
                                    weight = FontWeight.Medium
                                )
                            ),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }

    Button(onClick = {
        dialogOpen = true
    }) {
        Text(text = "OPEN 6")
    }
}


@Composable
fun MyDialogExample7() {
    var openDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current.applicationContext
    val interactionSource = remember { MutableInteractionSource() }

    if (openDialog) {
        Dialog(
            onDismissRequest = {
                openDialog = false
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(size = 12.dp)
            ) {
                Column(modifier = Modifier.padding(all = 16.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 6.dp,
                            alignment = Alignment.Start
                        )
                    ) {

                        Icon(
                            modifier = Modifier.size(26.dp),
                            painter = painterResource(id = R.drawable.trash_2),
                            contentDescription = "Удалить значок",
                            tint = Color(0xFFFF0000)
                        )

                        Text(
                            text = "Удалить пункт?",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                                fontSize = 20.sp
                            )
                        )
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 20.dp),
                        text = "Вы уверены, что хотите удалить этот элемент из списка?",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                            fontSize = 16.sp,
                            lineHeight = 22.sp
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 10.dp,
                            alignment = Alignment.End
                        )
                    ) {

                        Box(
                            modifier = Modifier
                                .clickable(
                                    indication = null,
                                    interactionSource = interactionSource
                                ) {
                                    Toast
                                        .makeText(context, "Отмена", Toast.LENGTH_SHORT)
                                        .show()
                                    openDialog = false
                                }
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF35898F),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .padding(top = 6.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                        ) {
                            Text(
                                text = "Отмена",
                                style = TextStyle(
                                    fontFamily = FontFamily(
                                        Font(
                                            R.font.roboto_medium,
                                            FontWeight.Medium
                                        )
                                    ),
                                    fontSize = 16.sp
                                ),
                                color = Color(0xFF35898F)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .clickable(
                                    // This is to disable the ripple effect
                                    indication = null,
                                    interactionSource = interactionSource
                                ) {
                                    Toast
                                        .makeText(context, "Удалить", Toast.LENGTH_SHORT)
                                        .show()
                                    openDialog = false
                                }
                                .background(
                                    color = Color(0xFFFF0000),
                                    shape = RoundedCornerShape(6.dp)
                                )
                                .padding(top = 6.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                        ) {
                            Text(
                                text = "Удалить",
                                style = TextStyle(
                                    fontFamily = FontFamily(
                                        Font(
                                            R.font.roboto_medium,
                                            FontWeight.Medium
                                        )
                                    ),
                                    fontSize = 16.sp
                                ),
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }

    Button(onClick = {
        openDialog = true
    }) {
        Text(text = "OPEN 7")
    }
}


@Composable
fun MyDialogExample8() {
    var dialogOpen by remember { mutableStateOf(false) }

    if (dialogOpen) {
        Dialog(onDismissRequest = {
            dialogOpen = false
        }
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(0.92f),
                color = Color.Transparent
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Column(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(percent = 10)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(height = 36.dp))

                        Text(
                            text = "Удалить?",
                            fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Bold)),
                            fontSize = 24.sp
                        )

                        Spacer(modifier = Modifier.height(height = 18.dp))

                        Text(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            text = "Вы уверены, что хотите удалить элемент?",
                            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(height = 18.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFF35898F),
                                        shape = RoundedCornerShape(percent = 26)
                                    )
                                    .clickable {
                                        dialogOpen = false
                                    }
                                    .padding(horizontal = 16.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = "Нет",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(
                                        Font(
                                            R.font.roboto_medium,
                                            FontWeight.Medium
                                        )
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .background(
                                        color = Color(0xFFFF0000),
                                        shape = RoundedCornerShape(percent = 26)
                                    )
                                    .clickable {
                                        dialogOpen = false
                                    }
                                    .padding(horizontal = 16.dp, vertical = 6.dp)
                            ) {
                                Text(
                                    text = "Да",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(
                                        Font(
                                            R.font.roboto_medium,
                                            FontWeight.Medium
                                        )
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(height = 18.dp * 2))
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.trash_2),
                        contentDescription = "Удалить значок",
                        tint = Color(0xFFFF0000),
                        modifier = Modifier
                            .background(color = Color.White, shape = CircleShape)
                            .border(width = 2.dp, shape = CircleShape, color = Color(0xFFFF0000))
                            .padding(all = 16.dp)
                            .align(alignment = Alignment.TopCenter)
                    )
                }
            }
        }
    }

    Button(onClick = { dialogOpen = true }) {
        Text(text = "OPEN 8")
    }
}

@Composable
fun MyDialogExample9() {
    val viewModel: MyViewModelDialog = viewModel()
    val openDialog by viewModel.open.observeAsState(false)

    if (openDialog) {
        viewModel.startThread()
        Dialog(
            onDismissRequest = {
            }
        ) {
            Surface(
                shadowElevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 56.dp, end = 56.dp, top = 32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    val infiniteTransition = rememberInfiniteTransition()

                    val angle by infiniteTransition.animateFloat(
                        initialValue = 0f,
                        targetValue = 360f,
                        animationSpec = infiniteRepeatable(
                            animation = keyframes {
                                durationMillis = 600
                            }
                        )
                    )

                    CircularProgressIndicator(
                        progress = 1f,
                        modifier = Modifier
                            .size(80.dp)
                            .rotate(angle)
                            .border(
                                12.dp,
                                brush = Brush.sweepGradient(
                                    listOf(
                                        Color.White,
                                        Color(0xFF35898f).copy(alpha = 0.1f),
                                        Color(0xFF35898f)
                                    )
                                ),
                                shape = CircleShape
                            ),
                        strokeWidth = 1.dp,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    Text(
                        modifier = Modifier
                            .padding(bottom = 32.dp),
                        text = "Пожалуйста, подождите...",
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(
                                Font(R.font.roboto_regular, FontWeight.Normal)
                            )
                        )
                    )
                }
            }
        }
    }
    Button(onClick = { viewModel.open.value = true }) {
        Text(text = "OPEN 9")
    }
}

class MyViewModelDialog : ViewModel() {
    var open = MutableLiveData<Boolean>()
    fun startThread() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                delay(3000)
            }
            open.value = false
        }
    }
}

@Composable
fun MyDialogExample10() {
    var openDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current.applicationContext

    if (openDialog) {
        Dialog(
            onDismissRequest = {
                openDialog = false
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                tonalElevation = 4.dp
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(color = Color(0xFF35898f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(top = 16.dp, bottom = 16.dp),
                            painter = painterResource(id = R.drawable.security),
                            contentDescription = "Двухэтапная проверка",
                            alignment = Alignment.Center
                        )
                    }

                    Text(
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                        text = "Двухэтапная проверка",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                            fontSize = 20.sp
                        )
                    )

                    Text(
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                        text = "Настройте двухэтапную аутентификацию, чтобы добавить дополнительные уровни безопасности вашей учетной записи.",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontFamily = FontFamily(
                                Font(
                                    R.font.roboto_regular,
                                    FontWeight.Normal
                                )
                            ),
                            fontSize = 14.sp
                        )
                    )

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 36.dp, start = 36.dp, end = 36.dp, bottom = 8.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFF35898f)),
                        onClick = {
                            openDialog = false
                            Toast.makeText(
                                context,
                                "Нажмите: Настроить сейчас",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                        Text(
                            text = "Настроить сейчас",
                            color = Color.White,
                            style = TextStyle(
                                fontFamily = FontFamily(
                                    Font(
                                        R.font.roboto_medium,
                                        FontWeight.Medium
                                    )
                                ),
                                fontSize = 16.sp
                            )
                        )
                    }

                    TextButton(
                        onClick = {
                            openDialog = false
                            Toast.makeText(
                                context,
                                "Нажмите: я сделаю это позже",
                                Toast.LENGTH_SHORT
                            ).show()
                        }) {
                        Text(
                            text = "Я сделаю это позже",
                            color = Color(0xFF35898f),
                            style = TextStyle(
                                fontFamily = FontFamily(
                                    Font(
                                        R.font.roboto_regular,
                                        FontWeight.Normal
                                    )
                                ),
                                fontSize = 14.sp
                            )
                        )
                    }
                }
            }
        }
    }
    Button(onClick = {
        openDialog = true
    }) {
        Text(text = "OPEN 10")
    }
}