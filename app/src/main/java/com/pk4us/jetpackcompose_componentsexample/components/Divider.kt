package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun MyDividerUI() {
    Column {
        Row {
            Icon(imageVector = Icons.Filled.Star, contentDescription = "Star")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "text")
        }

        Divider(color = Color.Green, thickness = 2.dp)
        Row {
            Icon(imageVector = Icons.Filled.Star, contentDescription = "Star")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "text")
        }

        Divider(color = Color.Green, thickness = 2.dp)

        Row {
            Icon(imageVector = Icons.Filled.Star, contentDescription = "Star")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "text")
        }

        Divider(color = Color.Green, thickness = 2.dp)

        Row {
            Icon(imageVector = Icons.Filled.Star, contentDescription = "Star")
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "text")
        }

        Divider(color = Color.Green, thickness = 2.dp)

        Row {
            Divider(
                color = Color.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "Star")
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = "t")
                Text(text = "e")
                Text(text = "x")
                Text(text = "t")
            }

            Divider(
                color = Color.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Column {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "Star")
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = "text")
            }

            Divider(
                color = Color.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Column {
                Icon(imageVector = Icons.Filled.Star, contentDescription = "Star")
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = "text")
            }

            Divider(
                color = Color.Red,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )


            Row(
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                Text("one", Modifier.padding(4.dp))

                Divider(
                    color = Color.Red,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                )

                Text("two", Modifier.padding(4.dp))

                // or replace it with a custom one
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(color = Color.Red)
                )

                Text("three", Modifier.padding(4.dp))
            }

        }
    }
}