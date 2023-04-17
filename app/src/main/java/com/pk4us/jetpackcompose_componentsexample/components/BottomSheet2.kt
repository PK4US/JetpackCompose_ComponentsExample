package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun MyBottomSheetScreen2() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyBottomSheet12345()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyBottomSheet12345() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    Button(onClick = {
        scope.launch {
            sheetState.show()
        }
    }) {
        Text("Show sheet")
    }

    if (sheetState.isVisible) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                scope.launch {
                    sheetState.hide()
                }
            },
        ) {
            Row(horizontalArrangement = Arrangement.SpaceAround) {
                CenterAlignedTopAppBar(navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            sheetState.hide()
                        }
                    }) {
                        Icon(Icons.Rounded.Close, contentDescription = "Cancel")
                    }
                }, title = { Text("Content") }, actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Rounded.Check, contentDescription = "Save")
                    }
                })
            }
        }
    }
}