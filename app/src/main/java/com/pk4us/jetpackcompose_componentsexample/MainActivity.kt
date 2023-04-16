package com.pk4us.jetpackcompose_componentsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.core.view.WindowCompat
import com.pk4us.jetpackcompose_componentsexample.ui.theme.Material3AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // расширил пользовательский интерфейс приложения до системных панелей
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)

        // вместо WindowCompat.setDecorFitsSystemWindows() вы также можете использовать следующее
        // window.setFlags(
        // WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        // WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        // )

        setContent {
            Material3AppTheme() {

//                //__________________________________________________________________________________ цвет статус бара
//                val systemUiController = rememberSystemUiController()
//                SideEffect {
//                    systemUiController.setStatusBarColor(
//                        color = Color.Magenta,
//                        darkIcons = false
//                    )
//                }//__________________________________________________________________________________
//
//
//
//                //__________________________________________________________________________________ цвет меню навигации
//                val systemUiController = rememberSystemUiController()
//                SideEffect {
//                    systemUiController.setNavigationBarColor(
//                        color = Color.Magenta,
//                        darkIcons = false
//                    )
//                }//__________________________________________________________________________________
//
//
//
//                //__________________________________________________________________________________ цвет всех элементов управления
//                val systemUiController = rememberSystemUiController()
//                SideEffect {
//                    systemUiController.setSystemBarsColor(
//                        color = Color.Magenta,
//                        darkIcons = false
//                    )
//                }//__________________________________________________________________________________
//
//
//
//                //__________________________________________________________________________________ скрывает элементы управления
//                val systemUiController = rememberSystemUiController()
//                SideEffect {
//                    // предназначены для настройки видимости панели навигации
//                    systemUiController.isNavigationBarVisible = false
//
//                    // предназначены для настройки видимости строки состояния соответственно
//                    systemUiController.isStatusBarVisible = false
//
//                    // isSystemBarsVisible для обеих системных панелей.
//                    //systemUiController.isSystemBarsVisible = false
//                }//__________________________________________________________________________________
//
//
//
//                //__________________________________________________________________________________ делает прозрачным
//                val systemUiController = rememberSystemUiController()
//                SideEffect {
//                    // установить прозрачный цвет, чтобы наше изображение было видно за строкой состояния
//                    systemUiController.setStatusBarColor(color = Color.Transparent)
//
//                    // панель навигации прозрачная
//                     systemUiController.setNavigationBarColor(color = Color.Transparent)
//                }//__________________________________________________________________________________





                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
//                            .navigationBarsPadding() //добавляет отступ в меню навигазии
//                            .statusBarsPadding()  //добавляет отступ в статус баре
                    ) {
                        items(count = 10) {
                            Image(
                                painter = painterResource(id = R.drawable.dog),
                                contentDescription = "Squirrel",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}