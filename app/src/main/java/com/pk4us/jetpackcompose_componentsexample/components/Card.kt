package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MyCardScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFDAE1E7),
            modifier = Modifier
                .height(210.dp)
                .padding(10.dp),
            shadowElevation = 10.dp
        ) {
            Column {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(2f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Surface(
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier.wrapContentSize(),
                            color = Color(0xFFD1D5E1)
                        ) {
                            Text(
                                text = "Новый",
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Степан",
                            fontSize = 24.sp,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(text = "Цена: 300$")

                        Spacer(modifier = Modifier.height(2.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "4.0",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )

                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )

                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                tint = Color(0xFFF6B266),
                                contentDescription = null
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedButton(
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.Black,
                                containerColor = Color.White
                            ),
                            onClick = {/* Do something */ }
                        ) {
                            Text(
                                text = "Читать еще ...",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }

                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.size(width = 100.dp, height = 140.dp)
                    ) {
                        Image(
                            painter = painterResource(id = com.pk4us.jetpackcompose_componentsexample.R.drawable.stepan),
                            contentScale = ContentScale.Crop,
                            contentDescription = ""
                        )
                    }
                }
            }
        }

        Card(
            modifier = Modifier.padding(10.dp),
        ) {
            Text(text = "Card", modifier = Modifier.padding(10.dp))
        }

        ElevatedCard(
            modifier = Modifier.padding(10.dp),
        ) {
            Text(text = "ElevatedCard", modifier = Modifier.padding(10.dp))
        }

        OutlinedCard(
            modifier = Modifier.padding(10.dp),
        ) {
            Text(text = "OutlinedCard", modifier = Modifier.padding(10.dp))
        }

        Card(
            onClick = { }, modifier = Modifier.padding(10.dp),
        ) {
            Text(text = "Карта с нажатием", modifier = Modifier.padding(10.dp))

        }

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp,
            ), modifier = Modifier.padding(10.dp),
            content = {
                Text(
                    text = "Карта с тенью",
                    modifier = Modifier.padding(10.dp)
                )
            }
        )

        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.padding(10.dp),
            content = {
                Text(text = "Карта с круглением", modifier = Modifier.padding(10.dp))
            }
        )

        Card(
            border = BorderStroke(1.dp, Color.Blue),
            modifier = Modifier.padding(10.dp),
            content = { Text(text = "Карточка с синей рамкой", modifier = Modifier.padding(10.dp)) }
        )

        Card(
            modifier = Modifier.padding(10.dp), content = {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = "Первый текст")
                    Text(text = "Второй текст")
                }
            })

        Card(
            modifier = Modifier.padding(10.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            content = {
                Text(
                    text = "Карточка с цветом фона",
                    modifier = Modifier.padding(10.dp)
                )
            }
        )

        Card(
            modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
            content = {
                Column(modifier = Modifier.clickable(onClick = { })) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null, // decorative
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth()
                    )

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Заголовок",
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "Текст текст текст текст текст текст текст текст текст текст текст текст текст ",
                            style = MaterialTheme.typography.titleSmall,
                        )
                    }
                }
            }
        )
    }
}