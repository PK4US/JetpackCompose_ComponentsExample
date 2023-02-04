package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun MyTextStyleScreen() {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        MyTextStyleColor()
        Divider()
        MyTextStyleFontSize()
        Divider()
        MyTextStyleFontWeight()
        Divider()
        MyTextStyleFontStyle()
        Divider()
        MyTextStyleFontSynthesis()
        Divider()
        MyTextStyleFontFamily()
        Divider()
        MyTextStyleFontFeatureSettings()
        Divider()
        MyTextStyleLetterSpacing()
        Divider()
        MyTextStyleBaselineShift()
        Divider()
        MyTextStyleTextGeometricTransform()
        Divider()
        MyTextStyleBackgroundColor()
        Divider()
        MyTextStyleTextDecoration()
        Divider()
        MyTextStyleShadow()
        Divider()
        MyTextStyleTextAlign()
        Divider()
        MyTextStyleTextDirection()
        Divider()
        MyTextStyleLineHeight()
        Divider()
        MyTextStyleTextIndent()
        Divider()
        MyTextStyleLineHeightStyle()
        Divider()
        MyTextStyleLineBreak()
        Divider()
        MyTextStyleHyphens()
        Divider()
        Spacer(modifier = Modifier.size(50.dp))
        MyTextStyleTextHeading()
    }
}

@Preview
@Composable
fun MyText() {
    Text(
        text = "Hello World",
        style = TextStyle(
            color = Red,                                                                      //объект который представляет цвет текста. По умолчанию имеет значение Color.Unspecified
            fontSize = 16.sp,                                                                       //объект  который представляет размер шрифта. По умолчанию равен TextUnit.Unspecified
            fontWeight = FontWeight.W800,                                                           //объект  который представляет толщину шрифта. По умолчанию равен null
            fontStyle = Italic,                                                                     //объект  который представляет стиль шрифта. По умолчанию равен null
            fontSynthesis = FontSynthesis.All,                                                      //Следует ли синтезировать толщину шрифта и/или стиль, когда запрошенная насыщенность или стиль не могут быть найдены в предоставленном семействе шрифтов.
            fontFamily = Cursive,                                                                   //объект который представляет тип шрифта. По умолчанию равен null
            fontFeatureSettings = "Hello",                                                          //объект который определяет, как будут применяться настройки толщины шрифта и его наклон
            letterSpacing = TextUnit.Unspecified,                                                   //объект который представляет отступы между символами. По умолчанию равен TextUnit.Unspecified
            baselineShift = BaselineShift.Superscript,                                              //объект BaselineShift?, который определяет, насколько текст будет сдвигаться относительно базовой линии (baseline). По умолчанию равен null
            textGeometricTransform = TextGeometricTransform(1.0f, 0f),               //представляет применяемые к тексту геометрические трансформации в виде объекта. По умолчанию равен null
            background = Color.Green,                                                               //объект который фоновый цвет компонента. По умолчанию имеет значение Color.Unspecified
            textDecoration = TextDecoration.Underline,                                              //объект который представляет тип декораций (например, подчеркивание), применяемых к тексту. По умолчанию равен null
            shadow = Shadow(Color.LightGray, Offset(10.0f, 16.5f), 1.0f),        //объект  который определяет применяемый к тексту эффект тени. По умолчанию равен null
            textAlign = TextAlign.Start,                                                            //объект который представляет выравнивание текста. По умолчанию равен null
            textDirection = TextDirection.Content,                                                  //объект  который представляет направление текста. По умолчанию равен null
            lineHeight = 7.sp,                                                                      //объект который представляет высоту строки текста. По умолчанию равен TextUnit.Unspecified
            textIndent = TextIndent(7.sp, 7.sp),                                                    //объект который представляет отступ от начала текста. По умолчанию равен null
            lineHeightStyle = LineHeightStyle.Default,
            lineBreak = LineBreak.Heading,
            hyphens = Hyphens.Auto
        )
    )
}


@OptIn(ExperimentalTextApi::class)
@Preview
@Composable
fun MyTextStyleColor() {
    Text(
        text = " 1 - Цвет текста",
        style = TextStyle(color = Red)
    )

    val gradientColors = listOf(Cyan, Blue, Red)
    Text(
        text = " 1 - Цвет текста",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        )
    )
}

@Preview
@Composable
fun MyTextStyleFontSize() {
    Text(
        text = " 2 - Размер текста",
        style = TextStyle(fontSize = 22.sp)
    )
}

@Preview
@Composable
fun MyTextStyleFontWeight() {
    Text(
        text = " 3 - Толщина текста",
        style = TextStyle(fontWeight = FontWeight.W800)
    )
}

@Preview
@Composable
fun MyTextStyleFontStyle() {
    Text(
        text = " 4 - Стиль текста",
        style = TextStyle(fontStyle = Italic)
    )
}

@Preview
@Composable
fun MyTextStyleFontSynthesis() {
    Text(
        text = " 5 - fontSynthesis = FontSynthesis.All",
        style = TextStyle(fontSynthesis = FontSynthesis.All)
    )
}

@Preview
@Composable
fun MyTextStyleFontFamily() {
    Text(
        text = " 6 - (fontFamily = Cursive",
        style = TextStyle(fontFamily = Cursive)
    )
}

@Preview
@Composable
fun MyTextStyleFontFeatureSettings() {
    Text(
        text = " 7 - fontFeatureSettings = Hello",
        style = TextStyle(fontFeatureSettings = "Hello")
    )
}

@Preview
@Composable
fun MyTextStyleLetterSpacing() {
    Text(
        text = " 8 - letterSpacing = TextUnit.Unspecified",
        style = TextStyle(letterSpacing = TextUnit.Unspecified)
    )
}

@Preview
@Composable
fun MyTextStyleBaselineShift() {
    Text(
        text = " 9 - baselineShift = BaselineShift.Superscript",
        style = TextStyle(baselineShift = BaselineShift.Superscript)
    )
}

@Preview
@Composable
fun MyTextStyleTextGeometricTransform() {
    Column {
        Text(
            text = " 10 - textGeometricTransform = TextGeometricTransform(1.0f, 0f)",
            style = TextStyle(textGeometricTransform = TextGeometricTransform(0.5f))
        )
        Text(
            text = "textGeometricTransform = TextGeometricTransform(2.0f)",
            style = TextStyle(textGeometricTransform = TextGeometricTransform(2.0f))
        )
        Text(
            text = "textGeometricTransform = TextGeometricTransform(1.0f, -0.5f))",
            style = TextStyle(textGeometricTransform = TextGeometricTransform(1.0f, -0.5f))
        )
        Text(
            text = "textGeometricTransform = TextGeometricTransform(1.0f, 0.5f)",
            style = TextStyle(textGeometricTransform = TextGeometricTransform(1.0f, 0.5f))
        )
    }

}

@Preview
@Composable
fun MyTextStyleBackgroundColor() {
    Text(
        text = " 11 - background = Color.Yellow",
        style = TextStyle(background = Color.Yellow)
    )
}

@Preview
@Composable
fun MyTextStyleTextDecoration() {
    Column {
        Text(
            text = " 12 - textDecoration = TextDecoration.Underline",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "textDecoration = TextDecoration.LineThrough",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
    }
}

@Preview
@Composable
fun MyTextStyleShadow() {
    Text(
        text = " 13 - shadow = Shadow(color = Color.Black, offset = Offset(5f, 5f), blurRadius = 5f",
        style = TextStyle(
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(5f, 5f),
                blurRadius = 5f
            )
        )
    )
}

@Preview
@Composable
fun MyTextStyleTextAlign() {
    Text(
        text = " 14 - textAlign = TextAlign.Start",
        style = TextStyle(textAlign = TextAlign.Start)
    )
}

@Preview
@Composable
fun MyTextStyleTextDirection() {
    Column {
        Text(
            text = " 15 - Content: направление текста в соответствии с Unicode Bidirectional Algorithm",
            style = TextStyle(textDirection = TextDirection.Content)
        )
        Text(
            text = " 15 - ContentOrLtr: направление текста в соответствии с Unicode Bidirectional Algorithm",
            style = TextStyle(textDirection = TextDirection.ContentOrLtr)
        )
        Text(
            text = " 15 - ContentOrRtl: направление текста в соответствии с Unicode Bidirectional Algorithm",
            style = TextStyle(textDirection = TextDirection.ContentOrRtl)
        )
        Text(
            text = " 15 - Ltr: текс направлен слева направо",
            style = TextStyle(textDirection = TextDirection.Ltr)
        )
        Text(
            text = " 15 - Rtl: текст направлен справо налево",
            style = TextStyle(textDirection = TextDirection.Rtl)
        )
    }
}

@Preview
@Composable
fun MyTextStyleLineHeight() {
    Text(
        text = " 16 - lineHeight = 20.sp",
        style = TextStyle(lineHeight = 20.sp)
    )
}

@Preview
@Composable
fun MyTextStyleTextIndent() {
    Text(
        text = " 17 - textIndent = TextIndent(20.sp, 40.sp)",
        style = TextStyle(textIndent = TextIndent(20.sp, 40.sp))
    )
}

@Preview
@Composable
fun MyTextStyleLineHeightStyle() {
    Text(
        text = " 18 - lineHeightStyle = LineHeightStyle.Default",
        style = TextStyle(lineHeightStyle = LineHeightStyle.Default)
    )
}

@Preview
@Composable
fun MyTextStyleLineBreak() {
    Text(
        text = " 19 - lineBreak = LineBreak.Heading",
        style = TextStyle(lineBreak = LineBreak.Heading)
    )
}

@Preview
@Composable
fun MyTextStyleHyphens() {
    Text(
        text = " 20 - hyphens = Hyphens.Auto",
        style = TextStyle(hyphens = Hyphens.Auto)
    )
}


@Preview
@Composable
fun MyTextStyleTextHeading() {
    Column() {
        Text(
            text = "displayLarge",
            style = MaterialTheme.typography.displayLarge
        )
        Text(
            text = "displayMedium",
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = "displaySmall",
            style = MaterialTheme.typography.displaySmall
        )
        Text(
            text = "headlineLarge",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "headlineMedium",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "headlineSmall",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "titleLarge",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "titleMedium",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "titleSmall",
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = "bodyLarge",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "bodyMedium",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "bodySmall",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "labelLarge",
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = "labelMedium",
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = "labelSmall",
            style = MaterialTheme.typography.labelSmall
        )
    }
}