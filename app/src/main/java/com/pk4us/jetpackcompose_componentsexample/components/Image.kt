package com.pk4us.jetpackcompose_componentsexample.components


import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import coil.compose.rememberAsyncImagePainter
import com.pk4us.jetpackcompose_componentsexample.R

@Preview
@Composable
fun MyImageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyImageUi1()
        MyImageUi2()
        MyImageUi3()
        MyImageUi4()
        MyImageUi5()
        MyImageUi6()
        MyImageUi7()
        MyImageUi8()
        MyImageUi9()
        MyImageUi10()
        MyImageUi11()
        MyImageUi12()
        MyImageUi13()
        MyImageUi14()
    }
}

@Preview
@Composable
fun MyImageUi1() {
    val context = LocalContext.current.applicationContext
    val bitmap = ContextCompat.getDrawable(
        context, R.drawable.dog
    )?.toBitmap()?.asImageBitmap()!!

    Image(
        bitmap = bitmap,
        contentDescription = null,
        modifier = Modifier.size(size = 160.dp)
    )
}

@Preview
@Composable
fun MyImageUi2() {
    val asyncPainter =
        rememberAsyncImagePainter("https://semicolonspace.com/wp-content/uploads/2023/02/forest.jpg")

    Image(
        painter = asyncPainter,
        contentDescription = null,
        modifier = Modifier.size(size = 160.dp)
    )
}


@Preview
@Composable
fun MyImageUi3() {
    val contextForToast = LocalContext.current.applicationContext
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = "Dog Image",
        modifier = Modifier
            .size(160.dp)
            .clickable {
                Toast
                    .makeText(contextForToast, "Click!", Toast.LENGTH_SHORT)
                    .show()
            }
    )
}


@Preview
@Composable
fun MyImageUi4() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
            .border(width = 2.dp, color = Color.Green, shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyImageUi5() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(size = 160.dp)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment(shape = RoundedCornerShape(percent = 5))
            ),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun MyImageUi6() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(size = 160.dp)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            ),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
fun MyImageUi7() {
    Image(
        painter = painterResource(id = R.drawable.dog),
        contentDescription = null,
        modifier = Modifier
            .size(size = 160.dp)
            .blur(
                radiusX = 10.dp,
                radiusY = 10.dp,
                edgeTreatment = BlurredEdgeTreatment.Rectangle
            ),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyImageUi8() {
    Image(
        imageVector = Icons.Filled.Search,
        contentDescription = null,
        modifier = Modifier.size(size = 100.dp)
    )
}

@Preview
@Composable
fun MyImageUi9() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "Andy Rubin",
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview
@Composable
fun MyImageUi10() {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape) // clip to the circle shape
            .border(5.dp, Color.Gray, CircleShape)//optional
    )
}


@Preview
@Composable
fun MyImageUi11() {
    Image(
        painter = painterResource(R.drawable.andy_rubin),
        contentDescription = "Round corner image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10))
            .border(5.dp, Color.Gray, RoundedCornerShape(10))
    )
}


@Preview
@Composable
fun MyImageUi12() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        modifier = Modifier
            .size(200.dp)
            .background(Color.DarkGray)
            .padding(20.dp)
    )
}


@Preview
@Composable
fun MyImageUi13() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier
            .size(200.dp)
    )
}


@Preview
@Composable
fun MyImageUi14() {
    Image(
        painter = painterResource(id = R.drawable.andy_rubin),
        contentDescription = "",
        modifier = Modifier
            .size(150.dp)
            .background(Color.LightGray),
        contentScale = ContentScale.Inside
    )
}