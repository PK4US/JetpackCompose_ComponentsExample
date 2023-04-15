package com.pk4us.jetpackcompose_componentsexample.components.calendar.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pk4us.jetpackcompose_componentsexample.components.calendar.model.DateWrapper
import com.pk4us.jetpackcompose_componentsexample.components.calendar.utils.LogCompositions
import java.time.LocalDate

@Composable
internal fun CalendarDay(
    date: DateWrapper,
    onSelected: (LocalDate) -> Unit
) {
    LogCompositions("CalendarDay")

    var currentModifier = Modifier
        .aspectRatio(1F)
        .clip(CircleShape)

    if (!date.isCurrentMonth && date.showCurrentMonthOnly) {
        Box(modifier = currentModifier)
        return
    }

    currentModifier = when {
        date.isSelectedDay -> {
            currentModifier
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
        }
        date.isCurrentDay -> {
            currentModifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
        }
        else -> currentModifier
    }

    if (date.isInDateRange || (date.isCurrentMonth && date.showCurrentMonthOnly)) {
        currentModifier = currentModifier.clickable {
            onSelected(date.localDate)
        }
    }

    val textColor = when {
        !date.isInDateRange -> {
            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38F)
        }
        date.isSelectedDay -> {
            MaterialTheme.colorScheme.onPrimary
        }
        date.isCurrentDay -> {
            MaterialTheme.colorScheme.primary
        }
        !date.isCurrentMonth -> {
            MaterialTheme.colorScheme.primary.copy(alpha = 0.6F)
        }
        else -> Color.Unspecified
    }

    val text = "${date.localDate.dayOfMonth}"

    Box(
        modifier = currentModifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
        )
    }
}
