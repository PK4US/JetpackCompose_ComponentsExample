package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Preview
@Composable
fun MyBottomSheetScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        MyBottomSheet1()
//        MyBottomSheet2()
//        MyBottomSheet3()
//        MyBottomSheet4()
//        MyBottomSheet5()
//        MyBottomSheet6()
    }
}

//@Composable
//fun MyBottomSheet1() {
//    val contextForToast = LocalContext.current.applicationContext
//    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
//    val coroutineScope = rememberCoroutineScope()
//
//    ModalBottomSheetLayout(
//        sheetContent = {
//            LazyColumn {
//                items(count = 5) {
//                    ListItem(
//                        modifier = Modifier.clickable {
//
//                            Toast.makeText(contextForToast, "Item $it", Toast.LENGTH_SHORT)
//                                .show()
//
//                            coroutineScope.launch {
//                                bottomSheetState.hide()
//                            }
//                        },
//                        text = {
//                            Text(text = "Item $it")
//                        },
//                        icon = {
//                            Icon(
//                                imageVector = Icons.Default.Favorite,
//                                contentDescription = "Favorite"
//                            )
//                        }
//                    )
//                }
//            }
//        },
//        sheetState = bottomSheetState
//    ) {
//        // app UI
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Button(onClick = {
//                coroutineScope.launch {
//                    bottomSheetState.show()
//                }
//            }) {
//                Text(text = "Show Bottom Sheet")
//            }
//        }
//    }
//}
//
//
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun MyBottomSheet2() {
//    val contextForToast = LocalContext.current.applicationContext
//
//    val coroutineScope = rememberCoroutineScope()
//
//    val scaffoldState = rememberBottomSheetScaffoldState()
//
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState,
//        sheetPeekHeight = 56.dp,
//        sheetContent = {
//
//            LazyColumn {
//
//                // the first item that is visible
//                item {
//                    Box(
//                        modifier = Modifier
//                            .height(56.dp)
//                            .fillMaxWidth()
//                            .background(color = MaterialTheme.colorScheme.primary)
//                    ) {
//                        Text(
//                            text = "Swipe up to Expand the sheet",
//                            modifier = Modifier.align(alignment = Alignment.Center),
//                            color = Color.White
//                        )
//                    }
//                }
//
//                // remaining items
//                items(count = 5) {
//                    ListItem(
//                        modifier = Modifier.clickable {
//
//                            Toast.makeText(contextForToast, "Item $it", Toast.LENGTH_SHORT)
//                                .show()
//
//                            coroutineScope.launch {
//                                scaffoldState.bottomSheetState.collapse()
//                            }
//                        },
//                        text = {
//                            Text(text = "Item $it")
//                        },
//                        icon = {
//                            Icon(
//                                imageVector = Icons.Default.Favorite,
//                                contentDescription = "Favorite",
//                                tint = MaterialTheme.colorScheme.primary
//                            )
//                        }
//                    )
//                }
//            }
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                Toast.makeText(contextForToast, "FAB Click", Toast.LENGTH_SHORT).show()
//            }) {
//                Icon(
//                    imageVector = Icons.Default.Navigation,
//                    contentDescription = "Favorite"
//                )
//            }
//        }) {
//        // app UI
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "Rest of the app UI")
//        }
//    }
//}
//
//
//@ExperimentalMaterialApi
//@Preview
//@Composable
//fun MyBottomSheet3() {
//    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
//    val sheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
//    val scope = rememberCoroutineScope()
//
//    BottomSheetScaffold(
//        scaffoldState = sheetScaffoldState,
//        sheetElevation = 0.dp,
//        sheetBackgroundColor = Color.Transparent,
//        sheetPeekHeight = 50.dp,
//        sheetContent = {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                IconButton(onClick = {
//                    scope.launch {
//                        if (sheetState.isCollapsed) {
//                            sheetState.expand()
//                        } else if (sheetState.isExpanded) {
//                            sheetState.collapse()
//                        }
//                    }
//                }) {
//                    Icon(
//                        imageVector = if (sheetState.isExpanded) {
//                            Icons.Filled.KeyboardArrowDown
//                        } else {
//                            Icons.Filled.KeyboardArrowUp
//                        },
//                        contentDescription = "Icon button"
//                    )
//                }
//                Surface(
//                    modifier = Modifier.height(300.dp),
//                    color = Color(0xff9c7ca5)
//                ) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        Text(
//                            text = "Нижний модальный лист",
//                            fontSize = 20.sp,
//                            modifier = Modifier.padding(10.dp),
//                            color = Color.White,
//                            fontWeight = FontWeight.ExtraBold
//                        )
//                        Divider(modifier = Modifier.padding(5.dp), color = Color.White)
//                        Text(
//                            text = "Модальные нижние листы представляют собой набор вариантов, блокируя взаимодействие с остальной частью экрана. Они являются альтернативой встроенным меню и простым диалоговым окнам на мобильных устройствах, предоставляя дополнительное пространство для контента, значков и действий.",
//                            fontSize = 15.sp,
//                            fontStyle = FontStyle.Italic,
//                            color = Color.White,
//                            modifier = Modifier.padding(10.dp)
//                        )
//                    }
//                }
//            }
//        }) {
//    }
//}
//
//
//@ExperimentalMaterialApi
//@Preview
//@Composable
//fun MyBottomSheet4() {
//    val sheetState = rememberBottomSheetState(
//        initialValue = BottomSheetValue.Collapsed
//    )
//    val scaffoldState = rememberBottomSheetScaffoldState(
//        bottomSheetState = sheetState
//    )
//    val scope = rememberCoroutineScope()
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState,
//        sheetContent = {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(600.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Bottom sheet",
//                    fontSize = 60.sp
//                )
//            }
//        },
//        sheetBackgroundColor = Color.White,
//        sheetPeekHeight = 0.dp
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Button(onClick = {
//                scope.launch {
//                    if (sheetState.isCollapsed) {
//                        sheetState.expand()
//                    } else {
//                        sheetState.collapse()
//                    }
//                }
//            }) {
//                Text(text = "Bottom sheet fraction: ${sheetState.progress.fraction}")
//            }
//        }
//    }
//}
//
//
//@ExperimentalMaterialApi
//@Preview
//@Composable
//fun MyBottomSheet5() {
//    val contextForToast = LocalContext.current.applicationContext
//    val coroutineScope = rememberCoroutineScope()
//    val scaffoldState = rememberBottomSheetScaffoldState()
//
//    BottomSheetScaffold(
//        scaffoldState = scaffoldState,
//        sheetPeekHeight = 50.dp,
//        sheetContent = {
//
//            LazyColumn {
//
//                // the first item that is visible
//                item {
//                    Box(
//                        modifier = Modifier
//                            .height(50.dp)
//                            .fillMaxWidth()
//                            .background(color = Violet90)
//                    ) {
//                        Text(
//                            text = "Проведите вверх, чтобы развернуть лист",
//                            modifier = Modifier.align(alignment = Alignment.Center),
//                            color = Color.White
//                        )
//                    }
//                }
//
//                // remaining items
//                items(count = 10) {
//                    ListItem(
//                        modifier = Modifier.clickable {
//
//                            Toast.makeText(contextForToast, "Item $it", Toast.LENGTH_SHORT)
//                                .show()
//
//                            coroutineScope.launch {
//                                scaffoldState.bottomSheetState.collapse()
//                            }
//                        },
//                        text = {
//                            Text(text = "Item $it")
//                        },
//                        icon = {
//                            Icon(
//                                imageVector = Icons.Outlined.Favorite,
//                                contentDescription = "Favorite",
//                                tint = Violet80
//                            )
//                        }
//                    )
//                }
//            }
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                Toast.makeText(contextForToast, "FAB Click", Toast.LENGTH_SHORT).show()
//            }, contentColor = Violet30, backgroundColor = Violet90) {
//                Icon(
//                    imageVector = Icons.Default.Favorite,
//                    contentDescription = "Favorite"
//                )
//            }
//        }) {
//        // app UI
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "UI", fontSize = 50.sp)
//        }
//    }
//}
//
//
//data class BottomSheetItem(val title: String, val icon: ImageVector)
//
//@ExperimentalFoundationApi
//@ExperimentalMaterialApi
//@Composable
//fun MyBottomSheet6() {
//    val bottomSheetItems = listOf(
//        BottomSheetItem(title = "Notification", icon = Icons.Default.Notifications),
//        BottomSheetItem(title = "Mail", icon = Icons.Default.MailOutline),
//        BottomSheetItem(title = "Scan", icon = Icons.Default.Search),
//        BottomSheetItem(title = "Edit", icon = Icons.Default.Edit),
//        BottomSheetItem(title = "Favorite", icon = Icons.Default.Favorite),
//        BottomSheetItem(title = "Settings", icon = Icons.Default.Settings)
//    )
//    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
//        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
//    )
//    val coroutineScope = rememberCoroutineScope()
//    BottomSheetScaffold(
//        scaffoldState = bottomSheetScaffoldState,
//        sheetContent = {
//            Column(
//                content = {
//                    Spacer(modifier = Modifier.padding(16.dp))
//                    Text(
//                        text = "Create New",
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        textAlign = TextAlign.Center,
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 21.sp,
//                        color = Color.White
//                    )
//                    LazyVerticalGrid(
//                        columns = GridCells.Fixed(3)
//                    ) {
//                        items(bottomSheetItems.size, itemContent = {
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally,
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 24.dp)
//                            ) {
//                                Spacer(modifier = Modifier.padding(8.dp))
//                                Icon(
//                                    bottomSheetItems[it].icon,
//                                    "",
//                                    tint = Color.White
//                                )
//                                Spacer(modifier = Modifier.padding(8.dp))
//                                Text(text = bottomSheetItems[it].title, color = Color.White)
//                            }
//
//                        })
//                    }
//                }, modifier = Modifier
//                    .fillMaxWidth()
//                    .height(300.dp)
//                    .background(Color(0xFF6650a4))
//                    .padding(16.dp)
//            )
//        },
//        sheetPeekHeight = 0.dp,
//        topBar = {
//            TopAppBar(
//                title = { Text("Bottom Sheet Demo") },
//                backgroundColor = Color.White,
//                contentColor = Color.Blue
//            )
//        }
//    ) {
//        Column(modifier = Modifier.fillMaxSize()) {
//            Button(
//                modifier = Modifier
//                    .padding(20.dp),
//                onClick = {
//                    coroutineScope.launch {
//                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
//                            bottomSheetScaffoldState.bottomSheetState.expand()
//                        } else {
//                            bottomSheetScaffoldState.bottomSheetState.collapse()
//                        }
//                    }
//                }
//            ) {
//                Text(
//                    text = "Click to show Bottom Sheet"
//                )
//            }
//        }
//    }
//}