package com.pk4us.jetpackcompose_componentsexample.components

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.PopupProperties
import com.pk4us.jetpackcompose_componentsexample.R
import me.saket.cascade.CascadeDropdownMenu

@Preview
@Composable
fun MyDropMenuScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuExample0()
        MenuExample1()
        MenuExample2()
        MenuExample3()
        MenuExample4()
        MenuExample5()
        MenuExample6()
        MenuExample7()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuExample0() {
    val listItems = getMenuItemsList()
    val contextForToast = LocalContext.current.applicationContext
    var expanded by remember {
        mutableStateOf(false)
    }

    TopAppBar(
        title = {
            Text(text = "SemicolonSpace")
        },
        actions = {

            // 3 vertical dots icon
            IconButton(onClick = {
                expanded = true
            }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Open Options"
                )
            }

            // drop down menu
            DropdownMenu(
                modifier = Modifier.width(width = 150.dp),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                // adjust the position
                offset = DpOffset(x = (-102).dp, y = (-64).dp),
                properties = PopupProperties()
            ) {

                // adding each menu item
                listItems.forEach { menuItemData ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = menuItemData.text,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = menuItemData.icon,
                                contentDescription = menuItemData.text,
                                tint = Color.DarkGray
                            )
                        },
                        onClick = {
                            Toast.makeText(contextForToast, menuItemData.text, Toast.LENGTH_SHORT)
                                .show()
                            expanded = false
                        },
                        enabled = true
                    )
                }
            }
        }
    )
}

data class MenuItemData(val text: String, val icon: ImageVector)

fun getMenuItemsList(): ArrayList<MenuItemData> {
    val listItems = ArrayList<MenuItemData>()

    listItems.add(MenuItemData(text = "Home", icon = Icons.Outlined.Home))
    listItems.add(MenuItemData(text = "Call", icon = Icons.Outlined.Call))
    listItems.add(MenuItemData(text = "Mail", icon = Icons.Outlined.Email))
    listItems.add(MenuItemData(text = "Info", icon = Icons.Outlined.Info))

    return listItems
}


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuExample1() {
    var expanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "TopAppBar") },
        actions = {

            IconButton(onClick = {
                expanded = true
            }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Open Options"
                )
            }

            DropdownMenu(
                modifier = Modifier.width(width = 150.dp),
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                },
                properties = PopupProperties()
            ) {
                DropdownMenuItem(
                    text = { Text("Edit") },
                    onClick = { expanded = false },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = null
                        )
                    })
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { expanded = false },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    })
                Divider()
                DropdownMenuItem(
                    text = { Text("Send") },
                    onClick = { expanded = false },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Email,
                            contentDescription = null
                        )
                    },
                    trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
            }
        }
    )
}


@Preview
@Composable
fun MenuExample2() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Edit") },
                onClick = { /* Handle edit! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text("Settings") },
                onClick = { /* Handle settings! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = null
                    )
                })
            Divider()
            DropdownMenuItem(
                text = { Text("Send Feedback") },
                onClick = { /* Handle send feedback! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Email,
                        contentDescription = null
                    )
                },
                trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
        }
    }
}


@Preview
@Composable
fun MenuExample3() {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopEnd),

        ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Row(
                modifier = Modifier.padding(all = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(size = 62.dp),
                    painter = painterResource(id = R.drawable.dog),
                    contentDescription = "lucy pic",
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(width = 8.dp)) // gap between image and text
                Text(
                    text = "Hi! I'm Lucy",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(width = 180.dp)) // gap between image and text
                IconButton(onClick = {
                    expanded = true
                }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Open Options"
                    )
                }
            }
        }

        DropdownMenu(
            modifier = Modifier.width(width = 150.dp),
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            },
            properties = PopupProperties()
        ) {
            DropdownMenuItem(
                text = { Text("Edit") },
                onClick = { expanded = false },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text("Settings") },
                onClick = { expanded = false },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = null
                    )
                })
            Divider()
            DropdownMenuItem(
                text = { Text("Send") },
                onClick = { expanded = false },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Email,
                        contentDescription = null
                    )
                },
                trailingIcon = { Text("F11", textAlign = TextAlign.Center) })
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuExample4() {
    val listItems = arrayOf("Text1", "Text2", "Text3", "Text4")
    var selectedItem by remember { mutableStateOf(listItems[0]) }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = selectedItem,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }
        ) {
            listItems.forEach { item ->
                DropdownMenuItem(text = {
                    Text(
                        text = item,
                        color = if (item == selectedItem) Color.White else Color.Gray
                    )
                },
                    onClick = {
                        selectedItem = item
                        expanded = false
                    })
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuExample5() {
    val context = LocalContext.current
    val listItems = arrayOf(
        "Квас",
        "Морс",
        "Компот",
        "Чай",
        "Кофе",
        "Соки",
        "Минеральная вода",
        "Газированные напитки",
        "Пиво",
        "Кефир",
        "Ряженка",
        "Простокваша",
        "Кумыс",
        "Тархун",
        "Лимонад",
        "Яблочный уксус",
        "Брага",
        "Медовуха",
        "Сидр",
        "Вино",
        "Холодный чай",
        "Какао",
        "Глинтвейн",
        "Травяной чай",
        "Растворимый кофе",
        "Текила",
        "Водка",
        "Джин",
        "Виски",
        "Ром",
        "Ликер",
        "Абсент",
        "Шампанское",
        "Профитроли",
        "Маргарита",
        "Бурбон",
        "Мохито",
        "Текила санрайз",
        "Лонг-айленд",
        "Мартини",
        "Коньяк",
        "Вишневый компот",
        "Яблочный компот",
        "Грейпфрутовый сок",
        "Апельсиновый сок",
        "Клюквенный морс",
        "Клюквенный сок",
        "Малиновый сок",
        "Красный борщ",
        "Банановый молочный коктейль",
        "Смузи",
        "Персиковый сок",
        "Томатный сок",
        "Мороженое коктейль",
        "Энергетические напитки",
        "Холодный кофе",
        "Красное вино",
        "Белое вино",
        "Розовое вино",
        "Сладкий чай",
        "Горячий шоколад",
        "Зеленый чай",
        "Черный чай с молоком",
        "Горячий глинтвейн",
        "Самогон",
        "Десертное вино",
        "Ягодный коктейль",
        "Ванильный молочный коктейль",
        "Айран",
        "Кумысный коктейль",
        "Сок граната",
        "Грушевый компот",
        "Персиковый компот",
        "Молочный коктейль с клубникой",
        "Мохито безалкогольный",
        "Кокосовый коктейль",
        "Банановый коктейль",
        "Сиропы для напитков",
        "Кисель",
        "Лимонный чай",
        "Клюквенный чай",
        "Яблочный чай",
        "Горячий ром с медом",
        "Кедровый орех",
        "Чернослив",
        "Мультивитаминный сок",
        "Сок из арбуза",
        "Киви-малиновый коктейль",
        "Коктейль из бананов и клубники",
        "Черника в сахарном сиропе",
        "Ликер Бейлис",
        "Лимонный сок",
        "Мандариновый сок",
        "Апельсиновый коктейль",
        "Молочный коктейль с мятой",
        "Пина колада",
        "Ром-кола",
        "Молочный коктейль с шоколадом",
        "Абрикосовый компот",
        "Морковный сок",
        "Грейпфрутовый коктейль",
        "Вишневый сок",
        "Черносмородиновый сок",
        "Березовый сок",
        "Лимонад",
        "Клюквенный лимонад",
        "Малиновый лимонад",
        "Кола",
        "Фанта",
        "Спрайт",
        "Квас",
        "Сольный квас",
        "Медовуха",
        "Карамельный молочный коктейль",
        "Шоколадный молочный коктейль",
        "Молочный коктейль с фруктами",
        "Сливочный коктейль",
        "Кофейный коктейль",
        "Красный пунш",
        "Желтый пунш",
        "Ром",
        "Виски",
        "Джин",
        "Коньяк",
        "Водка",
        "Текила",
        "Шампанское",
        "Привет",
        "Кислородный коктейль",
        "Перчиковый компот",
        "Грейпфрутовый сок",
        "Томатный сок",
        "Клюквенный коктейль",
        "Малиновый коктейль",
        "Яблочный коктейль",
        "Клубничный молочный коктейль",
        "Овсяный коктейль",
        "Черносливовый компот",
        "Молочный коктейль с бананом",
        "Молочный коктейль с вишней",
        "Клюквенный компот",
        "Арбузный коктейль",
        "Оливковый коктейль",
        "Брусничный коктейль",
        "Клюквенный морс",
        "Смузи",
        "Клубничный смузи",
        "Малиновый смузи",
        "Банановый смузи",
        "Шоколадный смузи",
        "Черничный смузи",
        "Грейпфрутовый смузи",
        "Апельсиновый смузи",
        "Грушевый компот",
        "Имбирный коктейль",
        "Морковный коктейль",
        "Тыквенный коктейль",
        "Сок из свеклы",
        "Сок из зеленого яблока",
        "Клюквенный морс с имбирем",
        "Глинтвейн",
        "Мультивитаминный коктейль",
        "Морс из красной смородины",
        "Морс из черной смородины",
        "Морс из малины",
        "Морс из клюквы и малины",
        "Морс из клюквы и черной смородины",
        "Ароматизированный чай",
        "Зеленый чай",
        "Черный чай",
        "Кофе со сливками",
        "Кофе со сгущенным молоком",
        "Лимонный чай",
        "Чай с имбирем",
        "Чай с медом",
        "Чай с липой",
        "Чай с малиной",
        "Чай с клюквой",
        "Чай с мятой",
        "Чай с апельсином",
        "Чай с брусникой",
        "Чай с лемонграссом",
        "Чай с бергамотом",
        "Чай с грейпфрутом",
        "Чай с карамелью",
        "Чай с клубникой",
        "Чай с манго",
        "Чай с персиком",
        "Чай с клюквой и медом",
        "Чай с ревенем",
        "Чай с шиповником",
        "Чай с травами",
        "Чай с фруктами",
        "Чай с цветами",
        "Коктейль Пина колада",
        "Латте",
        "Капучино",
        "Мокко",
        "Горячий шоколад",
        "Молочный коктейль"
    )
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }


    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
        TextField(
            value = selectedItem,
            onValueChange = { selectedItem = it },
            label = { Text(text = "Напиток") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )
        val filteredOptions = listItems.filter { it.contains(selectedItem, ignoreCase = true) }
        if (filteredOptions.isNotEmpty()) {
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = {
                // Мы не должны скрывать меню, когда пользователь входит, удаляет любой символ.
            }
            ) {
                filteredOptions.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedItem = item
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun MenuExample6() {
    val listItems = arrayOf("Favorites", "Options", "Settings", "Share")
    val disabledItem = 1
    val contextForToast = LocalContext.current.applicationContext
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ) {

        // options button
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Open Options"
            )
        }

        // drop down menu
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            // adding items
            listItems.forEachIndexed { itemIndex, itemValue ->
                DropdownMenuItem(
                    text = { Text(text = itemValue) },
                    onClick = {
                        Toast.makeText(contextForToast, itemValue, Toast.LENGTH_SHORT)
                            .show()
                        expanded = false
                    },
                    enabled = (itemIndex != disabledItem)
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuExample7() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More menu"
            )
        }

        CascadeDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = "1. Item") },
                children = {
                    DropdownMenuItem(
                        text = { Text(text = "1.1. Sub-Item") },
                        onClick = {
                            expanded = false
                            Toast.makeText(context, "1.1. Sub-Item", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            )
            DropdownMenuItem(
                text = { Text(text = "2. Item") },
                children = {
                    DropdownMenuItem(
                        text = { Text(text = "2.1. Sub-Item") },
                        onClick = {
                            expanded = false
                            Toast.makeText(context, "2.1. Sub-Item", Toast.LENGTH_SHORT).show()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "2.2. Sub-Item") },
                        children = {
                            DropdownMenuItem(
                                text = { Text(text = "2.2.1. Sub-Sub-Item") },
                                onClick = {
                                    expanded = false
                                    Toast.makeText(
                                        context,
                                        "2.2.1. Sub-Sub-Item",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            )
                        }
                    )
                }
            )
        }
    }

}