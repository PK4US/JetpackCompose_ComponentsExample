package com.pk4us.jetpackcompose_componentsexample.components

import android.Manifest.permission.*
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState

@Composable
fun MyCameraScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Example1() // запросить данные использовать камеру
        Example2() // запросить данные использовать фото и видео
//                Example3() // запросить данные использовать несколько разрешений (камеры звонков и данных)
//                ExampleWithApi4() // Используя Accompanist API запросить данные использовать фото и видео
//                ExampleWithApi5() // Используя Accompanist API запросить данные использовать несколько разрешений (камеры звонков и данных)
//                Example6(this) //открывает страницу настроек приложения
//                Example7() // проверяет результат индивидуального согласия приложения
    }
}

//__________________________________________________________________________________________________1
fun isPermissionGranted(context: Context): Boolean {// сначала проверьте, предоставлено ли разрешение
    return ContextCompat.checkSelfPermission(context, CAMERA) == PackageManager.PERMISSION_GRANTED
}

@Composable
fun Example1() {
    val context = LocalContext.current
    var permissionGranted by remember { mutableStateOf(isPermissionGranted(context)) }

    val permissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { permissionGranted_ ->
            Toast.makeText(context, "Разрешение получено $permissionGranted_", Toast.LENGTH_SHORT)
                .show()// это вызывается, когда пользователь выбирает разрешить или запретить
            permissionGranted = permissionGranted_
        }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                enabled = !permissionGranted, // если разрешение НЕ предоставлено, включите кнопку
                onClick = {
                    if (!permissionGranted) {
                        permissionLauncher.launch(CAMERA) // попросить разрешения
                    }
                }) {
                Text(text = if (permissionGranted) "Разрешение получено" else "Включить разрешение")
            }

            if (permissionGranted) {
                Toast.makeText(context, "Разрешение получено", Toast.LENGTH_SHORT)
                    .show()// обновите свой пользовательский интерфейс
            }
        }
    }
}
//__________________________________________________________________________________________________1


//__________________________________________________________________________________________________2

fun isPermissionGranted2(context: Context): Boolean {// сначала проверьте, предоставлено ли разрешение
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        ContextCompat.checkSelfPermission(
            context,
            READ_MEDIA_IMAGES
        ) == PackageManager.PERMISSION_GRANTED
    } else {
        ContextCompat.checkSelfPermission(
            context,
            READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }
}

@Composable
fun Example2() {
    val context = LocalContext.current
    var permissionGranted by remember { mutableStateOf(isPermissionGranted2(context)) }

    val permissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { permissionGranted_ ->
            Toast.makeText(context, "Разрешение получено $permissionGranted_", Toast.LENGTH_SHORT)
                .show()// это вызывается, когда пользователь выбирает разрешить или запретить
            permissionGranted = permissionGranted_
        }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                enabled = !permissionGranted, // если разрешение НЕ предоставлено, включите кнопку
                onClick = {
                    if (!permissionGranted) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                            permissionLauncher.launch(READ_MEDIA_IMAGES)
                        } else {
                            permissionLauncher.launch(READ_EXTERNAL_STORAGE)
                        }
                        // попросить разрешения
                    }
                }) {
                Text(text = if (permissionGranted) "Разрешение получено" else "Включить разрешение")
            }

            if (permissionGranted) {
                Toast.makeText(context, "Разрешение получено", Toast.LENGTH_SHORT)
                    .show()// обновите свой пользовательский интерфейс
            }
        }
    }
}
//__________________________________________________________________________________________________2


//__________________________________________________________________________________________________3
@Composable
fun Example3() {
    val permissionsRequired = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            CALL_PHONE,
            READ_MEDIA_IMAGES,
            RECORD_AUDIO
        )
    } else {
        arrayOf(
            CALL_PHONE,
            READ_EXTERNAL_STORAGE,
            RECORD_AUDIO
        )
    }

    val context = LocalContext.current
    val askPermissions =
        arrayListOf<String>() // это для удержания разрешений, которые не предоставлены
    var allPermissionGranted by remember { mutableStateOf(false) }

    val permissionsLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) { permissionsMap ->
            Toast.makeText(context, "permissionsMap $permissionsMap", Toast.LENGTH_SHORT).show()
            allPermissionGranted =
                !permissionsMap.containsValue(false) // если карта НЕ содержит false, все разрешения предоставляются
        }

    //добавить разрешения, которые НЕ предоставлены
    for (permission in permissionsRequired) {
        if (ContextCompat.checkSelfPermission(
                context,
                permission
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            askPermissions.add(permission)
        }
    }

    allPermissionGranted =
        askPermissions.isEmpty()// если список пуст, все разрешения предоставляются

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                enabled = !allPermissionGranted, // если разрешения НЕ предоставлены, включите кнопку
                onClick = {
                    if (!allPermissionGranted) { // попросить разрешения
                        permissionsLauncher.launch(askPermissions.toTypedArray())
                    }
                }) {
                Text(text = if (allPermissionGranted) "Все разрешения предоставлены" else "Включить разрешения")
            }

            if (allPermissionGranted) {
                Toast.makeText(context, "Все разрешения предоставлены", Toast.LENGTH_SHORT)
                    .show()// обновите свой пользовательский интерфейс
            }
        }
    }
}
//__________________________________________________________________________________________________3


//__________________________________________________________________________________________________4
private fun isPermissionGranted4(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(context, CAMERA) == PackageManager.PERMISSION_GRANTED
}

@Composable
fun ExampleWithApi4() {
    val context = LocalContext.current
    var permissionGranted by remember { mutableStateOf(isPermissionGranted4(context)) }

    val permissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { permissionGranted_ ->
            // this is called when the user selects allow or deny
            Toast.makeText(context, "permissionGranted_ $permissionGranted_", Toast.LENGTH_SHORT)
                .show()
            permissionGranted = permissionGranted_
        }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                enabled = !permissionGranted, // if the permission is NOT granted, enable the button
                onClick = {
                    if (!permissionGranted) {
                        // ask for permission
                        permissionLauncher.launch(CAMERA)
                    }
                }) {
                Text(text = if (permissionGranted) "Permission Granted" else "Enable Permission")
            }

            if (permissionGranted) {
                // update your UI
                Toast.makeText(context, "Permission granted", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
//__________________________________________________________________________________________________4


//__________________________________________________________________________________________________5
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ExampleWithApi5() {
    val permissionsRequired =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            listOf(
                CALL_PHONE, READ_MEDIA_IMAGES, RECORD_AUDIO
            )
        } else {
            listOf(
                CALL_PHONE, READ_EXTERNAL_STORAGE, RECORD_AUDIO
            )
        }


    val permissionsState = rememberMultiplePermissionsState(permissions = permissionsRequired)
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                enabled = !permissionsState.allPermissionsGranted, // если разрешения НЕ предоставлены
                onClick = {
                    permissionsState.launchMultiplePermissionRequest()
                }) {
                Text(if (permissionsState.allPermissionsGranted) "All Permissions Granted" else "Enable Permissions")
            }
        }

        if (permissionsState.allPermissionsGranted) {
            // update the UI
            Toast.makeText(context, "All Permission Granted", Toast.LENGTH_SHORT).show()
        }
    }
}
//__________________________________________________________________________________________________5


//__________________________________________________________________________________________________6
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun Example6(context: Context) {
    val permissionGranted = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        rememberPermissionState(permission = "android.permission.READ_MEDIA_IMAGES")
    } else {
        rememberPermissionState(permission = "android.permission.READ_EXTERNAL_STORAGE")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                enabled = (permissionGranted.status != PermissionStatus.Granted), // если разрешение НЕ предоставлено, включите кнопку
                onClick = { permissionGranted.launchPermissionRequest() }) {
                Text(if (permissionGranted.status == PermissionStatus.Granted) "Разрешение получено" else "Включить разрешение")
            }

            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.DarkGray,
                        fontSize = 16.sp
                    )
                ) {
                    append("Вы можете включить разрешения ")
                }

                pushStringAnnotation(
                    tag = "settings",
                    annotation = "settings"
                )
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontSize = 16.sp
                    )
                ) {
                    append("в настройках")
                }
                pop()
            }

            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    annotatedText.getStringAnnotations(
                        tag = "settings",// тег, который вы использовали в buildAnnotatedString
                        start = offset,
                        end = offset
                    )[0].let {
                        // onClick заблокировать открытые настройки
                        val intentSettings = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        intentSettings.data = Uri.fromParts("package", context.packageName, null)
                        context.startActivity(intentSettings)
                    }
                }
            )
        }
        // вы также можете проверить cameraPermission.status.isGranted
        if (permissionGranted.status == PermissionStatus.Granted) {
            // обновить пользовательский интерфейс
            Toast.makeText(context, "Разрешение получено", Toast.LENGTH_SHORT).show()
        }
    }
}
//__________________________________________________________________________________________________6


//__________________________________________________________________________________________________7
@Composable
fun Example7() {
    val context = LocalContext.current
    val permissionsRequired = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            CALL_PHONE, READ_MEDIA_IMAGES, RECORD_AUDIO
        )
    } else {
        arrayOf(
            CALL_PHONE, READ_EXTERNAL_STORAGE, RECORD_AUDIO
        )
    }
    val allPermissionsGranted: MutableState<Boolean> = remember { mutableStateOf(false) }
    val nextPermission: MutableState<String> = remember { mutableStateOf(permissionsRequired[0]) }

    val permissionRequestLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { permissionGranted ->
            Toast.makeText(context, "permissionGranted $permissionGranted", Toast.LENGTH_SHORT)
                .show()
            // проверьте, все ли разрешения предоставлены
            for (permission in permissionsRequired) {
                if (ContextCompat.checkSelfPermission(
                        context,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // a permission is not granted
                    allPermissionsGranted.value = false
                    nextPermission.value = permission
                    return@rememberLauncherForActivityResult
                }
            }

            // все разрешения предоставлены
            allPermissionsGranted.value = true

        }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(enabled = !allPermissionsGranted.value, // если разрешения НЕ предоставлены, включите кнопку
                onClick = {
                    permissionRequestLauncher.launch(nextPermission.value)
                }) {
                Text(
                    text = if (allPermissionsGranted.value) "All Permissions are Granted" else
                        nextPermission.value.substringAfterLast(".")
                )
            }

            if (allPermissionsGranted.value) {
                // обновить пользовательский интерфейс
                Toast.makeText(context, "All Permissions are Granted", Toast.LENGTH_SHORT).show()
            }
        }
    }
    // это вызывается при первом запуске приложения
    LaunchedEffect(Unit) {
        // проверьте, все ли разрешения предоставлены
        for (permission in permissionsRequired) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // a permission is not granted
                allPermissionsGranted.value = false
                nextPermission.value = permission
                return@LaunchedEffect
            }
        }

        // все разрешения предоставлены
        allPermissionsGranted.value = true
    }
}
//__________________________________________________________________________________________________7