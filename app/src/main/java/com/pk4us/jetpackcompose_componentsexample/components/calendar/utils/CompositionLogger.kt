package com.pk4us.jetpackcompose_componentsexample.components.calendar.utils

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import com.pk4us.jetpackcompose_componentsexample.BuildConfig

class Ref(var value: Int)

@Composable
internal inline fun LogCompositions(msg: String) {
    if (BuildConfig.DEBUG) {
        val ref = remember { Ref(0) }
        SideEffect { ref.value++ }
        Log.d("ComposeCalendar", "Compositions: $msg ${ref.value}")
    }
}
