package com.pk4us.jetpackcompose_componentsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.pk4us.jetpackcompose_componentsexample.components.MyCardScreen
import com.pk4us.jetpackcompose_componentsexample.components.MyLazyColumnScreen
import com.pk4us.jetpackcompose_componentsexample.components.MyNavigationDrawerScreen
import com.pk4us.jetpackcompose_componentsexample.ui.theme.Material3AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3AppTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyLazyColumnScreen()
                }
            }
        }
    }
}