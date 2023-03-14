package com.pk4us.jetpackcompose_componentsexample.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pk4us.jetpackcompose_componentsexample.R
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarAndNavigationBarScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTopBarAndNavigationBarUI1()
        MyTopBarAndNavigationBarUI2()
        MyTopBarAndNavigationBarUI3()
        MyTopBarAndNavigationBarUI4()
        MyTopBarAndNavigationBarUI5()
        MyTopBarAndNavigationBarUI6()

//        BottomNav()
    }
}

//__________________________________________________________________________________________________

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarAndNavigationBarUI1() {
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "Заголовок")
        },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(contextForToast, "Щелчок по значку «Назад»", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Назад")
            }
        }
    )
}

//__________________________________________________________________________________________________

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarAndNavigationBarUI2() {
    val contextForToast = LocalContext.current.applicationContext

    TopAppBar(
        title = {
            Text(text = "Заголовок")
        },
        actions = {
            // значок поиска
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Search,
                description = "Поиск"
            ) {
                Toast.makeText(contextForToast, "Поиск", Toast.LENGTH_SHORT).show()
            }

            // значок замка
            TopAppBarActionButton(
                imageVector = Icons.Outlined.Lock,
                description = "Замок"
            ) {
                Toast.makeText(contextForToast, "Замок", Toast.LENGTH_SHORT).show()
            }
        }
    )
}

@Composable
fun TopAppBarActionButton(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

//__________________________________________________________________________________________________

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarAndNavigationBarUI3() {
    val contextForToast = LocalContext.current.applicationContext
    var dropDownMenuExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Заголовок") },
        actions = {
            // значок параметров (вертикальные точки)
            TopAppBarActionButton2(imageVector = Icons.Outlined.MoreVert, description = "Options") {
                // показать выпадающее меню
                dropDownMenuExpanded = true
            }

            // выпадающее меню
            DropdownMenu(
                expanded = dropDownMenuExpanded,
                onDismissRequest = {
                    dropDownMenuExpanded = false
                },
                //поэкспериментируйте с этими значениями, чтобы правильно расположить меню
                offset = DpOffset(x = 10.dp, y = (-60).dp)
            ) {
                // это элементы области столбца, которые добавляются вертикально

                DropdownMenuItem(text = { Text("Обновить") }, onClick = {
                    Toast.makeText(contextForToast, "Refresh Click", Toast.LENGTH_SHORT)
                        .show()
                    dropDownMenuExpanded = false
                })

                DropdownMenuItem(text = { Text("Настройки") }, onClick = {
                    Toast.makeText(contextForToast, "Settings Click", Toast.LENGTH_SHORT)
                        .show()
                    dropDownMenuExpanded = false
                })

                DropdownMenuItem(text = { Text("Отправить отзыв") }, onClick = {
                    Toast.makeText(contextForToast, "Send Feedback Click", Toast.LENGTH_SHORT)
                        .show()
                    dropDownMenuExpanded = false
                })
            }
        }
    )
}

@Composable
fun TopAppBarActionButton2(
    imageVector: ImageVector,
    description: String,
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = imageVector, contentDescription = description)
    }
}

//__________________________________________________________________________________________________

@ExperimentalMaterial3Api
@Preview
@Composable
fun MyTopBarAndNavigationBarUI4() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

//________________________________________________________________________________________________

@Preview
@Composable
fun MyTopBarAndNavigationBarUI5() {
    val bottomMenuItemsList = prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext
    var selectedItem by remember { mutableStateOf("Home") }

    NavigationBar {
        bottomMenuItemsList.forEach { menuItem ->
            NavigationBarItem(
                selected = (selectedItem == menuItem.label),
                onClick = {
                    selectedItem = menuItem.label
                    Toast.makeText(
                        contextForToast,
                        menuItem.label, Toast.LENGTH_SHORT
                    ).show()
                },
                icon = {
                    Icon(
                        imageVector = menuItem.icon,
                        contentDescription = menuItem.label
                    )
                },
                label = {
                    Text(text = menuItem.label)
                },
                enabled = true
            )
        }
    }
}

private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()
    // add menu items
    bottomMenuItemsList.add(BottomMenuItem(label = "Home", icon = Icons.Filled.Home))
    bottomMenuItemsList.add(BottomMenuItem(label = "Profile", icon = Icons.Filled.Person))
    bottomMenuItemsList.add(BottomMenuItem(label = "Cart", icon = Icons.Filled.ShoppingCart))
    bottomMenuItemsList.add(BottomMenuItem(label = "Settings", icon = Icons.Filled.Settings))
    return bottomMenuItemsList
}

data class BottomMenuItem(val label: String, val icon: ImageVector)

//__________________________________________________________________________________________________

@Preview
@Composable
fun MyTopBarAndNavigationBarUI6() {
    BottomAppBar(
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    Icons.Filled.Edit,
                    contentDescription = "Localized description",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Localized description")
            }
        }
    )
}

//__________________________________________________________________________________________________

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {
    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomBar(navController = navController) }) {
        Modifier.padding(it)
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home Screen", fontSize = 60.sp)
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Profile Screen", fontSize = 60.sp)
    }
}

@Composable
fun ReportScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Report Screen", fontSize = 60.sp)
    }
}


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {

    // for home
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_bottom_home,
        icon_focused = R.drawable.ic_bottom_home_focused
    )

    // for report
    object Report : BottomBarScreen(
        route = "report",
        title = "Report",
        icon = R.drawable.ic_bottom_report,
        icon_focused = R.drawable.ic_bottom_report_focused
    )

    // for report
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_bottom_profile,
        icon_focused = R.drawable.ic_bottom_profile_focused
    )
}

@ExperimentalMaterial3Api
@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(BottomBarScreen.Home, BottomBarScreen.Report, BottomBarScreen.Profile)
    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination

    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
            .background(Color.Transparent)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background =
        if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.6f) else Color.Transparent
    val contentColor = if (selected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Row(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            //* if menu title : Report means we will show badge
            if (screen.title == "Report") { // with badge
                BadgedBox(badge = { Badge(modifier = Modifier.padding(10.dp)) { Text("6") } }) {
                    Icon(
                        painter = painterResource(id = if (selected) screen.icon_focused else screen.icon),
                        contentDescription = "icon",
                        tint = contentColor
                    )
                }
            } else {
                Icon(
                    painter = painterResource(id = if (selected) screen.icon_focused else screen.icon),
                    contentDescription = "icon",
                    tint = contentColor
                )
            }
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title, color = contentColor
                )
            }
        }
    }
}

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController, startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.Report.route) {
            ReportScreen()
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }
    }
}