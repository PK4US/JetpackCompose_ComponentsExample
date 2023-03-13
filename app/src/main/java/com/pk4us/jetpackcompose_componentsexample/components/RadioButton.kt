package com.pk4us.jetpackcompose_componentsexample.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcompose_componentsexample.R

@Preview
@Composable
fun MyRadioButtonScreen() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.fillMaxSize()) {
            MyTopAppBar()
            Spacer(modifier = Modifier.height(height = 8.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = "Выбери собаку",
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold))
            )
            Spacer(modifier = Modifier.height(height = 8.dp))
            CustomRadioButtons()
        }

        Spacer(modifier = Modifier.size(50.dp))
        Divider()

        Column {
            RadioButtonExample1()
            RadioButtonExample2()
        }
    }
}


@Preview
@Composable
fun RadioButtonExample1() {
    var state by remember { mutableStateOf(true) }

    Row(Modifier.selectableGroup()) {
        RadioButton(
            selected = state,
            onClick = { state = true },
            modifier = Modifier.semantics { contentDescription = "Localized Description" }
        )
        RadioButton(
            selected = !state,
            onClick = { state = false },
            modifier = Modifier.semantics { contentDescription = "Localized Description" }
        )
    }
}

@Preview
@Composable
fun RadioButtonExample2() {
    val radioOptions = listOf("Text 1", "Text 2", "Text 3")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null // null recommended for accessibility with screenreaders
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}


//__________________________________________________________________________________________________


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyTopAppBar() {
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "Собаки") },
        navigationIcon = {
            IconButton(
                onClick = { Toast.makeText(context, "Nav Icon Click", Toast.LENGTH_SHORT).show() }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Go Back"
                )
            }
        }
    )
}

@Composable
private fun CustomRadioButtons() {
    val dogsList = returnDogsList()
    var selectedItem by remember { mutableStateOf(dogsList[0].name) }

    Column(
        modifier = Modifier
            .selectableGroup()
    ) {
        CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {

            dogsList.forEach { dogDetails ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (selectedItem == dogDetails.name),
                            onClick = { selectedItem = dogDetails.name },
                            role = Role.RadioButton
                        )
                        .padding(vertical = 8.dp)
                ) {
                    RadioButtonStyle(selectedItem = selectedItem, dogDetails = dogDetails)
                }
            }
        }
    }
}

@Composable
private fun RadioButtonStyle(selectedItem: String, dogDetails: DogsData) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color =
                if (selectedItem == dogDetails.name)
                    MaterialTheme.colorScheme.primary
                else
                    Color.LightGray,
                shape = RoundedCornerShape(percent = 10)
            )
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            // dog's image
            Image(
                modifier = Modifier
                    .size(size = 94.dp)
                    .clip(shape = CircleShape),
                painter = painterResource(id = dogDetails.image),
                contentScale = ContentScale.Crop,
                contentDescription = "Dog Image"
            )
            // dog's details
            Column(
                modifier = Modifier
                    .padding(start = 16.dp, top = 6.dp, bottom = 6.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // dog's name
                    Text(
                        text = dogDetails.name,
                        fontSize = 22.sp,
                        fontFamily = FontFamily(
                            Font(
                                R.font.roboto_bold,
                                weight = FontWeight.Bold
                            )
                        )
                    )
                    // check icon
                    Icon(
                        imageVector =
                        if (selectedItem == dogDetails.name)
                            Icons.Outlined.CheckCircle
                        else
                            Icons.Outlined.CheckCircle,
                        contentDescription = null,
                        tint =
                        if (selectedItem == dogDetails.name)
                            MaterialTheme.colorScheme.primary
                        else
                            Color.Gray
                    )
                }
                // dog's age
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = dogDetails.age,
                    fontSize = 18.sp,
                    fontFamily = FontFamily(
                        Font(
                            R.font.roboto_regular,
                            weight = FontWeight.Normal
                        )
                    )
                )
                // dog's price
                Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = "$${dogDetails.price}",
                    fontSize = 22.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium, weight = FontWeight.Medium)),
                    color = Color.DarkGray
                )
            }
        }
    }
}

private fun returnDogsList(): ArrayList<DogsData> {
    val dogsList = arrayListOf<DogsData>()

    dogsList.add(
        DogsData(
            image = R.drawable.dog4,
            name = "Марни",
            age = "3-года",
            price = "200"
        )
    )

    dogsList.add(
        DogsData(
            image = R.drawable.dog3,
            name = "Принц",
            age = "3-года",
            price = "250"
        )
    )

    dogsList.add(
        DogsData(
            image = R.drawable.dog2,
            name = "Марсель",
            age = "2-года",
            price = "500"
        )
    )

    dogsList.add(
        DogsData(
            image = R.drawable.dog1,
            name = "Лакки",
            age = "5-лет",
            price = "300"
        )
    )

    return dogsList
}


object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

data class DogsData(val image: Int, val name: String, val age: String, val price: String)