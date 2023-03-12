package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MyTextFieldScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldExample1()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample3()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample4()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample6()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample7()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample8()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample9()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample10()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample11()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample12()
        Spacer(modifier = Modifier.size(20.dp))
        TextFieldExample13()
        Spacer(modifier = Modifier.size(20.dp))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TextFieldExample0() {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,                                                           // представляет введенное в текстовое поле значение в виде строки, то есть объекта String.
        onValueChange = {
            text = it
        },                                                                      // функция обработки изменения введенного значения.
        modifier = Modifier,                                                    // объект типа Modifier, который задает модификаторы компонента.
        enabled = true,                                                         // устанавливает, будет ли поле доступно для ввода.
        readOnly = false,                                                       // устанавливает, будет ли поле доступно только для чтения.
        textStyle = LocalTextStyle.current,                                     // объект типа TextStyle, который устанавливает стиль текста.
        label = null,                                                           // устанавливает дополнительную метку, которая отображается внутри поля.
        placeholder = null,                                                     // плейсхолдер - временный текст, который отображается внутри поля.
        leadingIcon = null,                                                     // устанавливает иконку, которая отображается перед текстом.
        trailingIcon = null,                                                    // устанавливает иконку, которая отображается после текста.
        isError = false,                                                        // указывает, является ли текущее введенное в поле значение некорректным.
        visualTransformation = VisualTransformation.None,                       // объект типа VisualTransformation, который задает визуальные трансформации для вводимого текста.
        keyboardOptions = KeyboardOptions.Default,                              // объект KeyboardOptions, который задает параметры клавиатуры (например, ее тип).
        keyboardActions = KeyboardActions(),                                    // задает набор функций, которые вызываются в ответ на некоторые действия пользователя.
        singleLine = false,                                                     // устанавливает, будет ли текст однострочным.
        maxLines = Int.MAX_VALUE,                                               // задает максимальное количество строк в поле.
        interactionSource = remember { MutableInteractionSource() },            // задает поток взаимодействий для поля ввода.
        shape = MaterialTheme.shapes.small.copy(                                // задает форму для поля ввода.
            bottomEnd = ZeroCornerSize,
            bottomStart = ZeroCornerSize
        ),
        colors = TextFieldDefaults.textFieldColors()                            // задает цвета для поля ввода.
    )
}

@Preview
@Composable
fun TextFieldExample1() {
    var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(
            TextFieldValue(
                "example",
                TextRange(0, 7)
            )
        )
    }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
    )
}

@Preview
@Composable
fun TextFieldExample2() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email") },
        placeholder = { Text("пример@gmail.com") }
    )
}

@Preview
@Composable
fun TextFieldExample3() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Localized description") },
        trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
    )
}

@Preview
@Composable
fun TextFieldExample4() {
    val errorMessage = "Ввод текста слишком длинный"
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 10

    fun validate(text: String) {
        isError = text.length > charLimit
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            validate(text)
        },
        singleLine = true,
        label = { Text(if (isError) "Username*" else "Username") },
        supportingText = {
            Text(
                text = "Limit: ${text.length}/$charLimit",
                textAlign = TextAlign.End,
            )
        },
        isError = isError,
        keyboardActions = KeyboardActions { validate(text) },
        modifier = Modifier.semantics {
            // Provide localized description of the error
            if (isError) error(errorMessage)
        }
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun TextFieldExample6() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        supportingText = {
            Text("Вспомогательный текст, который является длинным и, возможно, переходит на другую строку.")
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
                // do something here
            }
        )
    )
}


@Preview
@Composable
fun TextFieldExample7() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        label = { Text("Введите пароль") },
        visualTransformation =
        if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = { passwordHidden = !passwordHidden }) {
                val visibilityIcon =
                    if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                // Please provide localized description for accessibility services
                val description = if (passwordHidden) "Show password" else "Hide password"
                Icon(imageVector = visibilityIcon, contentDescription = description)
            }
        }
    )
}

//________________________________________________________


@Preview
@Composable
private fun TextFieldExample8() {
    var value by remember { mutableStateOf("") }
    var isUserBelow18 by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column {
            TextField(
                value = value,
                onValueChange = { newText ->
                    value = newText
                    isUserBelow18 = false
                },
                label = { Text(text = "Возраст") },
                placeholder = { Text(text = "Введите свой возраст") },
                isError = isUserBelow18,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        // validate here
                        isUserBelow18 = validateAge(inputText = value)
                    }
                )
            )

            if (isUserBelow18) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Вам должно быть 18+",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

private fun validateAge(inputText: String): Boolean {
    return inputText.toInt() < 18
}

//__________________________________________________________________

@Preview
@Composable
private fun TextFieldExample9() {
    var value by remember { mutableStateOf("Цвет курсора") }

    BasicTextField(
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        ),
        modifier = Modifier.background(Color.Gray),
        cursorBrush = Brush.verticalGradient(colors = listOf(Color(0xFF2193b0), Color(0xFF6dd5ed)))
    )
}

@Preview
@Composable
private fun TextFieldExample10() {
    var value by remember { mutableStateOf("text") }

    BasicTextField(
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .padding(horizontal = 64.dp) // margin left and right
                    .fillMaxWidth()
                    .background(color = Color(0xFF20E6DF), shape = RoundedCornerShape(size = 16.dp))
                    .border(
                        width = 2.dp,
                        color = Color(0xFF147772),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .padding(all = 16.dp), // inner padding
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Favorite icon",
                    tint = Color.DarkGray
                )
                Spacer(modifier = Modifier.width(width = 8.dp))
                innerTextField()
            }
        }
    )
}


@Preview
@Composable
private fun TextFieldExample11(placeholder: String = "Enter Your Name") {
    var value by remember { mutableStateOf("") }

    BasicTextField(
        value = value,
        onValueChange = { newText ->
            value = newText
        },
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 64.dp) // margin left and right
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color(0xFFAAE9E6),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp), // inner padding
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.LightGray
                    )
                }
                innerTextField()
            }
        }
    )
}

@Preview
@Composable
fun TextFieldExample12() {
    var value by remember { mutableStateOf("Hello\nWorld\nInvisible") }
    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Enter text") },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
    )
}


@Preview
@Composable
fun TextFieldExample13() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}