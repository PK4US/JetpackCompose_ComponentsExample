package com.pk4us.jetpackcompose_componentsexample.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.pk4us.jetpackcompose_componentsexample.R
import kotlinx.coroutines.launch

@Composable
fun MyNavigationDrawerScreen() {
    Column() {
//        MyNavigationDrawerUI1()
//        MyNavigationDrawerUI2()
//        MyNavigationDrawerUI3()
//        MyNavigationDrawerUI4()
        MyNavigationDrawerUI5()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun MyNavigationDrawerUI1() {
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember { mutableStateOf(items[0]) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            Column {
                ModalDrawerSheet {
                    Spacer(Modifier.height(12.dp))
                    items.forEach { item ->
                        NavigationDrawerItem(
                            icon = { Icon(item, contentDescription = null) },
                            label = { Text(item.name) },
                            selected = item == selectedItem.value,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedItem.value = item
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                    Divider()

                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Star"
                            )
                        },
                        label = { Text("Star") },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    NavigationDrawerItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Edit"
                            )
                        },
                        label = { Text("Edit") },
                        selected = false,
                        onClick = {
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        drawerState = drawerState,
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "TopBar",
                            )
                        },
                        navigationIcon = {
                            IconButton(
                                onClick = { scope.launch { drawerState.open() } }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        },
                    )
                },
                content = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("App Content")
                    }
                }
            )
        }
    )
}


@Composable
@Preview
private fun MyNavigationDrawerUI2() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
    val selectedItem = remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                items.forEach { item ->
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
                Divider()

                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Filled.Star, contentDescription = "Star") },
                    label = { Text("Star") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )

                NavigationDrawerItem(
                    icon = { Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit") },
                    label = { Text("Edit") },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
                Spacer(Modifier.height(20.dp))
                Button(onClick = { scope.launch { drawerState.open() } }) {
                    Text("Click to open")
                }
            }
        }
    )
}

@Preview
@Composable
fun MyNavigationDrawerUI3() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Settings")
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)
    NavigationRail {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}


@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigationDrawerUI4() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val currentBackStackEntryAsState = navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntryAsState.value?.destination

    ModalNavigationDrawer(
        drawerContent = {
            Column {
                ModalDrawerSheet {
                    Spacer(Modifier.height(12.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ava),
                            contentDescription = "profile pic",
                            modifier = Modifier
                                .clip(CircleShape)
                                .width(150.dp)
                                .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Evhenii Stepanchuk",
                            fontSize = TextUnit(18F, TextUnitType.Sp),
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Android Developer",
                            fontSize = TextUnit(14F, TextUnitType.Sp),
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Divider(color = Color.LightGray)
                    Spacer(modifier = Modifier.height(10.dp))

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                        label = { Text(text = "Главная") },
                        selected = destination?.route == "HomePage",
                        onClick = {
                            navController.navigate("HomePage", navOptions {
                                this.launchSingleTop = true
                                this.restoreState = true

                            })
                            scope.launch {
                                drawerState.close()
                            }
                        }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Filled.Hail, "About") },
                        label = { Text(text = "Обо мне") },
                        selected = destination?.route == "AboutPage",

                        onClick = {
                            navController.navigate("AboutPage", navOptions {
                                this.launchSingleTop = true
                                this.restoreState = true

                            })
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    NavigationDrawerItem(
                        icon = { Icon(Icons.Filled.Settings, "Setting") },

                        label = { Text(text = "Настройки") },
                        selected = destination?.route == "SettingPage",
                        onClick = {
                            navController.navigate("SettingPage", navOptions {
                                this.launchSingleTop = true
                                this.restoreState = true
                            })
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = "version 1.0.0", fontSize = 16.sp, color = Color.Gray)
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Приложение") }, navigationIcon = {
                IconButton(onClick = {

                    if (drawerState.isClosed) {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    } else {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    }

                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Drawer Menu.")
                }
            })
        }) {
            Box(modifier = Modifier.padding(it)) {
                NavHost(navController = navController, startDestination = "HomePage") {
                    composable("HomePage") {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Главная")
                        }
                    }

                    composable("AboutPage") {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Обо мне")
                        }
                    }

                    composable("SettingPage") {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Настройки")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigationDrawerUI5() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val itemsList = prepareNavigationDrawerItems()
    val contextForToast = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerContent = {
            Column {
                ModalDrawerSheet {
                    Spacer(Modifier.height(12.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color(0xFF03A9F4),
                                        Color(0xFFFFFFFF)
                                    )
                                )
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        contentPadding = PaddingValues(vertical = 36.dp)
                    ) {

                        item {

                            // user's image
                            Image(
                                modifier = Modifier
                                    .size(size = 120.dp)
                                    .clip(shape = CircleShape),
                                painter = painterResource(id = R.drawable.ava),
                                contentDescription = "Profile Image"
                            )

                            // user's name
                            Text(
                                modifier = Modifier
                                    .padding(top = 12.dp),
                                text = "Eugene Stepanchuk",
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            // user's email
                            Text(
                                modifier = Modifier.padding(top = 8.dp, bottom = 30.dp),
                                text = "stepachuk.ei@gmail.com",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }

                        items(itemsList) { item ->
                            NavigationListItem(item = item) {
                                Toast.makeText(contextForToast, item.label, Toast.LENGTH_SHORT)
                                    .show()
                                scope.launch { drawerState.close() }
                            }
                        }
                    }
                }
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(topBar = {
            TopAppBar(title = { Text(text = "Приложение") }, navigationIcon = {
                IconButton(onClick = {

                    if (drawerState.isClosed) {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    } else {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                    }

                }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Drawer Menu.")
                }
            })
        }) {
            Box(modifier = Modifier.padding(it)) {
                NavHost(navController = navController, startDestination = "HomePage") {
                    composable("HomePage") {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Главная")
                        }
                    }

                    composable("AboutPage") {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Обо мне")
                        }
                    }

                    composable("SettingPage") {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Настройки")
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun NavigationListItem(
    item: NavigationDrawerItem,
    itemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                itemClick()
            }
            .padding(horizontal = 24.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // icon and unread bubble
        Box {

            Icon(
                modifier = Modifier
                    .padding(all = if (item.showUnreadBubble && item.label == "Messages") 5.dp else 2.dp)
                    .size(size = if (item.showUnreadBubble && item.label == "Messages") 24.dp else 28.dp),
                painter = item.image,
                contentDescription = null,
                tint = Color.White
            )

            // unread bubble
            if (item.showUnreadBubble) {
                Box(
                    modifier = Modifier
                        .size(size = 8.dp)
                        .align(alignment = Alignment.TopEnd)
                        .background(color = Color(0xFF0FFF93), shape = CircleShape)
                )
            }
        }

        // label
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = item.label,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}

@Composable
private fun prepareNavigationDrawerItems(): List<NavigationDrawerItem> {
    val itemsList = arrayListOf<NavigationDrawerItem>()

    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.home),
            label = "Главная"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.message_square),
            label = "Сообщения",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.bell),
            label = "Уведомления",
            showUnreadBubble = true
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.user),
            label = "Профиль"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.credit_card),
            label = "Покупки"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.settings),
            label = "Настройки"
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.log_out),
            label = "Выйти"
        )
    )

    return itemsList
}

data class NavigationDrawerItem(
    val image: Painter,
    val label: String,
    val showUnreadBubble: Boolean = false
)