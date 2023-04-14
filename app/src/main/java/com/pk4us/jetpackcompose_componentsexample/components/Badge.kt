package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcompose_componentsexample.ui.theme.GreenGrey60


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyBadgeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyBadge1()
        MyBadge2()
        MyBadge3()
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun MyBadge1() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(30.dp),
        Arrangement.SpaceAround,
        Alignment.CenterVertically
    ) {
        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = "11")
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            Icon(
                tint = GreenGrey60,
                imageVector = Icons.Filled.Email,
                contentDescription = "Email",
                modifier = Modifier.size(45.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = "4")
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            Icon(
                tint = GreenGrey60,
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "ShoppingCart",
                modifier = Modifier.size(45.dp)
            )
        }

        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = "8")
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            Icon(
                tint = GreenGrey60,
                imageVector = Icons.Filled.Settings,
                contentDescription = "Settings",
                modifier = Modifier.size(45.dp)
            )
        }
    }
}


@Preview
@ExperimentalMaterial3Api
@Composable
fun MyBadge2() {
    var count by remember { mutableStateOf(0) }
    NavigationBar {
        NavigationBarItem(icon = {
            BadgedBox(badge = {
                Badge {
                    val badgeNumber = count.toString()
                    Text(badgeNumber, modifier = Modifier.semantics {
                        contentDescription = "$badgeNumber new notifications"
                    })
                }
            }) {
                Icon(
                    Icons.Filled.Star, contentDescription = "Favorite"
                )
            }
        }, selected = false, onClick = { count++ })
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun MyBadge3() {
    var count by remember { mutableStateOf(995) }
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(30.dp),
        Arrangement.SpaceAround,
        Alignment.CenterVertically
    ) {
        BadgedBox(
            badge = {
                Badge(
                    content = {
                        Text(text = count.toString())
                    },
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            }
        ) {
            FloatingActionButton(onClick = { count++ }) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    }
}