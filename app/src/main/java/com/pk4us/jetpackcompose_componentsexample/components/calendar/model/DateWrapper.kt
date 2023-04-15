package com.pk4us.jetpackcompose_componentsexample.components.calendar.model

import java.time.LocalDate

internal data class DateWrapper(
    val localDate: LocalDate,
    val isSelectedDay: Boolean,
    val isCurrentDay: Boolean,
    val isCurrentMonth: Boolean,
    val isInDateRange: Boolean,
    val showCurrentMonthOnly: Boolean
)
