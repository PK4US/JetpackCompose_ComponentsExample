package com.pk4us.jetpackcompose_componentsexample.components

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.pk4us.jetpackcompose_componentsexample.R
import com.pk4us.jetpackcompose_componentsexample.SecondActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLazyColumnScreen() {
//    MyListExample1()
//    MyListExample2()
//    MyListExample3()
//    MyListExample4()
    MyListExample5()
//    MyListExample6()
}

data class FruitModel(val name: String, val image: Int)

@Preview
@Composable
fun MyListExample1() {
    LazyColumn {
        item {
            Text(text = "Header")
        }

        items(3) { index ->
            Text(text = "First List items : $index")
        }

        items(2) { index ->
            Text(text = "Second List Items: $index")
        }

        item {
            Text(text = "Footer")
        }
    }
}
//--------------------------------------------------------------------------------------------------

private val countryList = mutableListOf("India", "Pakistan", "China", "United States")
private val listModifier = Modifier
private val textStyle = TextStyle(fontSize = 20.sp)

@Preview
@Composable
fun MyListExample2() {
    LazyColumn(modifier = listModifier) {
        items(countryList) { country ->
            Text(text = country, style = textStyle)
        }
    }
}

//--------------------------------------------------------------------------------------------------
@Composable
fun ListRow(model: FruitModel) {
    val mContext = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .selectable(
                selected = false,
                onClick = {
                    mContext.startActivity(Intent(mContext, SecondActivity::class.java))
                }
            )
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            Modifier.padding(32.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}


@Preview
@Composable
fun MyListExample3() {
    val fruitsList = mutableListOf<FruitModel>()
    fruitsList.add(FruitModel("Apple", R.drawable.apple))
    fruitsList.add(FruitModel("Orange", R.drawable.orange))
    fruitsList.add(FruitModel("Banana", R.drawable.banana))
    fruitsList.add(FruitModel("Strawberry", R.drawable.strawberry))
    fruitsList.add(FruitModel("Eggplant", R.drawable.eggplant))
    fruitsList.add(FruitModel("Cucumber", R.drawable.cucumber))
    fruitsList.add(FruitModel("Tomato", R.drawable.tomato))
    fruitsList.add(FruitModel("Avocado", R.drawable.avocado))
    fruitsList.add(FruitModel("Beet", R.drawable.beet))
    fruitsList.add(FruitModel("Bell pepper", R.drawable.bell_pepper))
    fruitsList.add(FruitModel("Broccoli", R.drawable.broccoli))
    fruitsList.add(FruitModel("Carrot", R.drawable.carrot))
    fruitsList.add(FruitModel("Cherry", R.drawable.cherry))
    fruitsList.add(FruitModel("Corn", R.drawable.corn))
    fruitsList.add(FruitModel("Kiwi", R.drawable.kiwi_))
    fruitsList.add(FruitModel("Lemon", R.drawable.lemon))
    fruitsList.add(FruitModel("Pear", R.drawable.pear))
    fruitsList.add(FruitModel("Peas", R.drawable.peas))
    fruitsList.add(FruitModel("Pineapple", R.drawable.pineapple))
    fruitsList.add(FruitModel("Pomegranate", R.drawable.pomegranate))
    fruitsList.add(FruitModel("Watermelon", R.drawable.watermelon))
    fruitsList.add(FruitModel("Peach", R.drawable.peach))

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(fruitsList) { model ->
            ListRow(model = model)
        }
    }
}

//--------------------------------------------------------------------------------------------------


private lateinit var messagesList: ArrayList<MessagesData>


@Preview
@Composable
fun MyListExample4() {
    var listPrepared by remember { mutableStateOf(false) }
    if (listPrepared) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(messagesList) { itemObject ->
                MessagesItemStyle(item = itemObject)
            }
        }
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            prepareMessagesList()
            listPrepared = true
        }
    }
}

@Composable
fun MessagesItemStyle(
    item: MessagesData,
    context: Context = LocalContext.current.applicationContext
) {

    Box(
        modifier = Modifier
            .clickable(
                onClick = {
                    Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
                }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Profile image
            Image(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(56.dp),
                painter = painterResource(id = item.image),
                contentDescription = item.name
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    // Text that shows the name
                    Text(
                        text = item.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    )

                    Text(
                        text = item.time,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    )

                }

                Text(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    text = item.message,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                )

            }
        }
    }
}

private fun prepareMessagesList() {
    messagesList = ArrayList()

    messagesList.add(
        MessagesData(
            R.drawable.people_abby,
            "Abby",
            "Cool. We meet tomorrow",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_emilia,
            "Emilia",
            "Why are you not picking up my call?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_emma,
            "Emma",
            "Tom doesn't have to help",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_grace,
            "Grace",
            "The school principal was so mean that all the children were scared of him",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_hannah,
            "Hannah",
            "I'm curious to know why they removed my name from the list",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_isabella,
            "Isabella",
            "Do you really think you'd be happy in a job like that?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_lucy,
            "Lucy",
            "Would you like your cash in tens or twenties?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_olivia,
            "Olivia",
            "If you hurry, there still might be some choice items left for you to buy",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_scarlett,
            "Scarlett",
            "How can she afford a multi-million dollar house?",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_victoria,
            "Victoria",
            "She found the necklace in a safe at the bottom of her parents' closet",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_natasha,
            "Наташа",
            "Азиатом короч",
            "00:46"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_katya,
            "Катя",
            "Тогда договорились встречаемся в субботу в 16:00",
            "00:35"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_anya,
            "Аня",
            "Ахахах, очень смешно!",
            "00:30"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_masha,
            "Маша",
            "Хорошо",
            "00:15"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_lera,
            "Лера",
            "Ясно",
            "00:12"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_karina,
            "Карина",
            "Ахаха дааа!",
            "00:09"
        )
    )

    messagesList.add(
        MessagesData(
            R.drawable.people_lesya,
            "Леся",
            "Пока! Увидимся!",
            "00:05"
        )
    )
}

data class MessagesData(
    val image: Int,
    val name: String,
    val message: String,
    val time: String
)

//__________________________________________________________________________________________________

@ExperimentalMaterial3Api
@Composable
fun MyListExample5() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        ) { values ->
            LazyColumn(contentPadding = values) {
                items(2000) {
                    ImageCard(
                        title = "Заголовок",
                        description = "Описание, описание, описание, описание, описание, описание, описание, описание.",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun ImageCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://picsum.photos/seed/${Random.nextInt()}/300/200"),
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AssistChip(
                    onClick = { },
                    colors = AssistChipDefaults.assistChipColors(leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Избранное") }
                )
                AssistChip(
                    onClick = { },
                    colors = AssistChipDefaults.assistChipColors(leadingIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Share,
                            contentDescription = null
                        )
                    },
                    label = { Text(text = "Поделится") }
                )
            }
        }
    }
}

//__________________________________________________________________________________________________

@Composable
@Preview
@ExperimentalMaterial3Api
fun MyListExample6() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ListItem(
            headlineContent = { Text("Однострочный элемент списка со значком 24x24") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Локализованное описание",
                )
            })

        Divider()

        ListItem(
            headlineContent = { Text("Элемент списка из двух строк с замыканием") },
            supportingContent = { Text("Вторичный текст") },
            trailingContent = { Text("meta") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                )
            })

        Divider()

        ListItem(
            headlineContent = { Text("Элемент трехстрочного списка") },
            overlineContent = { Text("ВЕРХНЯЯ ЛИНИЯ") },
            supportingContent = { Text("Вторичный текст") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = null,
                )
            },
            trailingContent = {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = null,
                )
            }

        )

        Divider()
    }
}