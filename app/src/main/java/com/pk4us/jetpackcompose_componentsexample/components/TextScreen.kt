package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcompose_componentsexample.ui.theme.Green20


@Preview
@Composable
fun MyTextScreen() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        MyColorText()
        Divider()
        MyFontSize()
        Divider()
        MyFontStyle()
        Divider()
        MyFontWeight()
        Divider()
        MyFontFamily()
        Divider()
        MyLetterSpacing()
        Divider()
        MyTextDecoration()
        Divider()
        MyTextAlign()
        Divider()
        MyOverflowedText()
        Divider()
        MySoftWrap()
        Divider()
        MyMaxLines()
    }
}


@Preview
@Composable
fun TextExample() {
    Text(
        text = "Text",                          //объект, который представляет выводимый текст
        modifier = Modifier,                    //объект, который представляет применяемые к компоненту модификаторы
        color = Color.Unspecified,              //объект, который представляет цвет текста. По умолчанию имеет значение Color.Unspecified
        fontSize = TextUnit.Unspecified,        //объект, который представляет размер шрифта. По умолчанию равен TextUnit.Unspecified
        fontStyle = null,                       //объект, который представляет стиль шрифта. По умолчанию равен null
        fontWeight = null,                      //объект, который представляет толщину шрифта. По умолчанию равен null
        fontFamily = null,                      //объект, который представляет тип шрифта. По умолчанию равен null
        letterSpacing = TextUnit.Unspecified,   //объект, который представляет отступы между символами. По умолчанию равен TextUnit.Unspecified
        textDecoration = null,                  //объект, который представляет тип декораций (например, подчеркивание), применяемых к тексту. По умолчанию равен null
        textAlign = null,                       //объект, который представляет выравнивание текста. По умолчанию равен null
        lineHeight = TextUnit.Unspecified,      //объект, который представляет высоту строки текста. По умолчанию равен TextUnit.Unspecified
        overflow = TextOverflow.Clip,           //объект, который определяет поведение текста при его выходе за границы контейнера. По умолчанию равен TextOverflow.Clip
        softWrap = true,                        //объект, который определяет, должен ли текст не переносится при завершении строки. При значении false текст не переносится, как будто строка имеет бесконечную длину. По умолчанию равен true
        maxLines = Int.MAX_VALUE,               //объект, который представляет максимальное количество строк. Если текст превысил установленное количество строк, то он усекается в соответствии с параметрами overflow и softWrap. По умолчанию равен Int.MAX_VALUE
        onTextLayout = {},                      //объект, который представляет функцию, выполняемую при определении компоновки текста.
        style = LocalTextStyle.current          //объект, который представляет стиль текста. Значение по умолчанию - LocalTextStyle.current
    )
}


@Preview
@Composable
fun MyColorText() {
    Column {
        Text("Цветной текст - Green20", color = Green20)
        Text(
            text = "Цветной текст",
            color = Color.Red
        )
    }
}

@Preview
@Composable
fun MyFontSize() {
    Text("Размер текста - 30.sp", fontSize = 30.sp)
}

@Preview
@Composable
fun MyFontStyle() {
    Column {
        Text(text = "Стиль шрифта - Italic", fontStyle = FontStyle.Italic)
        Text(text = "Стиль шрифта - Normal", fontStyle = FontStyle.Normal)
    }
}

@Preview
@Composable
fun MyFontWeight() {
    Column {
        Text("Шрифт текста - Black", fontWeight = FontWeight.Black)
        Text("Шрифт текста - Bold", fontWeight = FontWeight.Bold)
        Text("Шрифт текста - ExtraBold", fontWeight = FontWeight.ExtraBold)
        Text("Шрифт текста - ExtraLight", fontWeight = FontWeight.ExtraLight)
        Text("Шрифт текста - Light", fontWeight = FontWeight.Light)
        Text("Шрифт текста - Medium", fontWeight = FontWeight.Medium)
        Text("Шрифт текста - Normal", fontWeight = FontWeight.Normal)
        Text("Шрифт текста - SemiBold", fontWeight = FontWeight.SemiBold)
        Text("Шрифт текста - Thin", fontWeight = FontWeight.Thin)

        Text(text = "Шрифт текста - W700", fontWeight = FontWeight.W700)
        Text(text = "Шрифт текста - 600", fontWeight = FontWeight(600))
    }
}

@Preview
@Composable
fun MyFontFamily() {
    Column {
        Text(text = "Тип или семейство шрифта - Cursive", fontFamily = FontFamily.Cursive)
        Text(text = "Тип или семейство шрифта - Monospace", fontFamily = FontFamily.Monospace)
        Text(text = "Тип или семейство шрифта - Serif", fontFamily = FontFamily.Serif)
        Text(text = "Тип или семейство шрифта - SansSerif", fontFamily = FontFamily.SansSerif)
        Text(text = "Тип или семейство шрифта - Default", fontFamily = FontFamily.Default)
    }
}

@Preview
@Composable
fun MyLetterSpacing() {
    Column {
        Text(text = "Отступы между символами - 5.sp", letterSpacing = 5.sp)
        Text(text = "Отступы между символами - 0.2.em", letterSpacing = 0.2.em)
    }
}

@Preview
@Composable
fun MyTextDecoration() {
    Column {
        Text(text = "Декорации текста - LineThrough", textDecoration = TextDecoration.LineThrough)
        Text(text = "Декорации текста - Underline", textDecoration = TextDecoration.Underline)
        Text(text = "Декорации текста - None", textDecoration = TextDecoration.None)
    }
}

@Preview
@Composable
fun MyTextAlign() {
    Column {
        Text(
            text = "Текст (Center)",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Текст (Justify)",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "Текст (Left)",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Left
        )
        Text(
            text = "Текст (Right)",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Right
        )
        Text(
            text = "Текст (Start)",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Start
        )
        Text(text = "Текст (End)", modifier = Modifier.fillMaxWidth(1f), textAlign = TextAlign.End)
    }
}

@Preview
@Composable
fun MyOverflowedText() {
    Column {
        Text(
            "Усечение текста - Ellipsis - выходящий за границы контейнера текст усекается",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            "Усечение текста -Clip - текст усекается, а в конце текста добавляется многоточие",
            maxLines = 1,
            overflow = TextOverflow.Clip
        )
        Text(
            "Усечение текста - Visible - весь текст может отображаться",
            maxLines = 1,
            overflow = TextOverflow.Visible
        )
    }
}

@Preview
@Composable
fun MySoftWrap() {
    Column {
        Text(
            "Параметр softWrap управляет переносом текста. Равен true, текст переносится, текст переносится, текст переносится, текст переносится, текст переносится, текст переносится, текст переносится",
            softWrap = true
        )
        Text(
            "Параметр softWrap управляет переносом текста. Равен false, текст не переносится, текст не переносится, текст не переносится, текст не переносится, текст не переносится, текст не переносится, текст не переносится",
            softWrap = false
        )
    }
}

@Preview
@Composable
fun MyMaxLines() {
    Text(
        "Макс. кол. строк - 2, Макс. кол. строк - 2, Макс. кол. строк - 2, Макс. кол. строк - 2, Макс. кол. строк - 2, Макс. кол. строк - 2, Макс. кол. строк - 2, Макс. кол. строк - 2, Макс. кол. строк - 2, ",
        maxLines = 2
    )
}