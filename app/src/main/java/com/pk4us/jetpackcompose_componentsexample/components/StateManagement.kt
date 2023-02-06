package com.pk4us.jetpackcompose_componentsexample.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StateManagementScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        NoState()
        MutableStateClick()
        RememberSample()
        RememberSaveableClickCount()
        MyUI()
    }
}


@Composable
fun NoState() {
    var clickCount = 0
    Log.d("TAG", "NoState: create()")
    Column {
        Button(onClick = {
            clickCount++
            Log.d("TAG", "NoState: $clickCount")
        }) {
            Text(text = "Count $clickCount")
        }
    }
}

//Not recommended. Use with remember()
@SuppressLint("UnrememberedMutableState")
@Composable
fun MutableStateClick() {
    var clickCount by mutableStateOf(0)
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "Count $clickCount")
        }
    }
}


@Composable
fun RememberSample() {
    var clickCount by remember { mutableStateOf(0) }
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "Count $clickCount")
        }
    }
}

//__________________________________________________________________________________________________

@Composable
fun RememberSaveableClickCount() {
    val clickCount = rememberSaveable { mutableStateOf(0) }
    ClickCount(text = clickCount.value) {
        clickCount.value++
    }
}

@Composable
private fun ClickCount(text: Int, onClickEvent: () -> Unit) {
    Button(onClick = onClickEvent) {
        Text(text = "Count$text")
    }
}

//__________________________________________________________________________________________________

class MyViewMode : ViewModel() {
    var count = MutableLiveData<Int>(0)
    fun increment() {
        count.value = count.value?.plus(1)
    }
}

@Composable
fun MyUI(myViewModel: MyViewMode = viewModel()) {
    val clickCount by myViewModel.count.observeAsState(0)

    Button(
        onClick = {
            myViewModel.increment()
        }, content = { Text(text = "Count $clickCount") }
    )
}

//__________________________________________________________________________________________________