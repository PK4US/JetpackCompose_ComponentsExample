package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyChipScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyChipExample1()
        MyChipExample2()
        MyChipExample3()
        MyChipExample4()
        MyChipExample5()
        MyChipExample6()
        MyChipExample7()
        MyChipExample8()
    }
}

@Composable
fun MyChipExample1() {
    AssistChip(onClick = { },
        label = { Text("Assist Chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        })
}

@Composable
fun MyChipExample2() {
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        repeat(20) { positons ->
            AssistChip(onClick = { },
                modifier = Modifier.padding(horizontal = 5.dp),
                label = { Text("Chip $positons") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Localized description",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChipExample3() {
    var selected by remember { mutableStateOf(false) }
    FilterChip(selected = selected,
        onClick = { selected = !selected },
        label = { Text(text = "Filter chip") },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyChipExample4() {
    var selectedValue by remember { mutableStateOf(false) }
    InputChip(selected = selectedValue,
        onClick = { selectedValue = !selectedValue },
        label = { Text(text = "Input chip") },
        avatar = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "",
                Modifier.size(InputChipDefaults.AvatarSize)
            )
        })
}

@Composable
fun MyChipExample5() {
    SuggestionChip(onClick = { },
        label = { Text(text = "Suggestion Chip") })


    val textChipRememberOneState = remember { mutableStateOf(false) }
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp, horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (textChipRememberOneState.value) Color.DarkGray else Color.LightGray,
                shape = ShapeDefaults.Medium
            )
            .background(
                color = if (textChipRememberOneState.value) Color.DarkGray else Color.Transparent,
                shape = ShapeDefaults.Medium
            )
            .clip(shape = ShapeDefaults.Medium)
            .clickable {
                textChipRememberOneState.value = (!textChipRememberOneState.value)
            }
            .padding(4.dp)) {
        Text(
            text = "Fries",
            color = if (textChipRememberOneState.value) Color.White else Color.Unspecified
        )
    }
}

@Composable
fun MyChipExample6() {
    val textChipRememberOneState2 = remember { mutableStateOf(false) }
    val shape = CircleShape
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp, horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (textChipRememberOneState2.value) Color.Red else Color.LightGray,
                shape = shape
            )
            .background(
                color = if (textChipRememberOneState2.value) Color.Red else Color.Transparent,
                shape = shape
            )
            .clip(shape = shape)
            .clickable {
                textChipRememberOneState2.value = (!textChipRememberOneState2.value)
            }
            .padding(4.dp)) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            tint = if (textChipRememberOneState2.value) Color.White else Color.Red,
            contentDescription = null
        )
        Text(
            text = "Pizza",
            color = if (textChipRememberOneState2.value) Color.White else Color.Unspecified
        )
    }
}

@Composable
fun MyChipExample7() {
    val textChipRememberOneState3 = remember { mutableStateOf(false) }
    val shape2 = RoundedCornerShape(8.dp)
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp, horizontal = 4.dp
            )
            .border(
                width = 1.dp, color = Color.LightGray, shape = shape2
            )
            .background(
                color = Color.LightGray, shape = shape2
            )
            .clip(shape = shape2)
            .clickable {
                textChipRememberOneState3.value = (!textChipRememberOneState3.value)
            }
            .padding(4.dp)) {
        if (textChipRememberOneState3.value) {
            Icon(
                imageVector = Icons.Filled.Done, tint = Color.DarkGray, contentDescription = null
            )
        }
        Text(
            text = "Pizza", color = Color.Unspecified
        )
    }
}

@Composable
fun MyChipExample8() {
    val textChipRememberOneState4 = remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 1.dp,
                horizontal = 2.dp
            )
            .border(
                width = 1.dp,
                color = if (textChipRememberOneState4.value) Color.Blue else Color.LightGray,
                shape = ShapeDefaults.Medium
            )
            .background(
                color = if (textChipRememberOneState4.value) Color.Blue else Color.Transparent,
                shape = ShapeDefaults.Medium
            )
            .clip(shape = ShapeDefaults.Medium)
            .clickable {
                textChipRememberOneState4.value = (!textChipRememberOneState4.value)
            }
            .padding(2.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            tint = if (textChipRememberOneState4.value) Color.White else Color.Blue,
            contentDescription = null
        )
    }
}