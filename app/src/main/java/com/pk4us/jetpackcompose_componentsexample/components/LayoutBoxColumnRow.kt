package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MyColumnExample1() {
    Column() {
        Box(modifier = Modifier.background(Color.Red).fillMaxWidth().weight(1f))
        Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(150.dp))
        Box(modifier = Modifier.background(Color.Green).fillMaxWidth().weight(2f))
    }
}

@Preview
@Composable
fun MyColumnExample2() {
    Column(
        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End
    ) {
        Text(text = " Text 1", Modifier.background(Color.Red))
        Text(text = " Text 2", Modifier.background(Color.White))
        Text(text = " Text 3", Modifier.background(Color.Green))
    }
}

@Preview
@Composable
fun MyColumnExample4() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center)
    {
        Box(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
    }
}

@Preview
@Composable
fun MyColumnExample5() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom)
    {
        Box(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
    }
}

@Preview
@Composable
fun MyColumnExample6() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top)
    {
        Box(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
    }
}

@Preview
@Composable
fun MyColumnExample7() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround)
    {
        Box(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
    }
}

@Preview
@Composable
fun MyColumnExample8() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween)
    {
        Box(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
    }
}

@Preview
@Composable
fun MyColumnExample9() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly)
    {
        Box(modifier = Modifier.background(Color.Red).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Yellow).fillMaxWidth().height(100.dp))
        Box(modifier = Modifier.background(Color.Green).fillMaxWidth().height(100.dp))
    }
}

//__________________________________________________________________________________________________

@Preview(showBackground = true)
@Composable
fun MyRowExample1() {
    Row {
        Text(text = "Row Text 1", Modifier.background(Color.Red))
        Text(text = "Row Text 2", Modifier.background(Color.Yellow))
        Text(text = "Row Text 3", Modifier.background(Color.Green))
    }
}

@Preview
@Composable
fun MyRowExample2() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Text 1", Modifier.background(Color.Red))
        Text(text = "Text 2", Modifier.background(Color.White))
        Text(text = "Text 3", Modifier.background(Color.Green))
    }
}

@Preview
@Composable
fun MyRowExample3() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly)
    {
        Box(modifier = Modifier.background(Color.Red).height(150.dp).width(100.dp))
        Box(modifier = Modifier.background(Color.Yellow).height(150.dp).width(100.dp))
        Box(modifier = Modifier.background(Color.Green).height(150.dp).width(100.dp))
    }
}

@Preview
@Composable
fun MyRowExample4() {
    Row()
    {
        Box(modifier = Modifier.background(Color.Red).height(150.dp).weight(1f))
        Box(modifier = Modifier.background(Color.Yellow).height(150.dp).weight(3f))
        Box(modifier = Modifier.background(Color.Green).height(150.dp).weight(2f))
    }
}

@Preview
@Composable
fun MyRowExample5() {
    Row()
    {
        Box(modifier = Modifier.background(Color.Red).height(150.dp).weight(1f))
        Box(modifier = Modifier.background(Color.Yellow).height(150.dp).width(150.dp))
        Box(modifier = Modifier.background(Color.Green).height(150.dp).weight(2f))
    }
}

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyBoxExample1() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center)
    {
        Box(modifier = Modifier.background(Color.Blue).size(300.dp))
        Box(modifier = Modifier.background(Color.LightGray).size(200.dp))
        Text("MyBox", style = TextStyle(fontSize = 22.sp))
    }
}