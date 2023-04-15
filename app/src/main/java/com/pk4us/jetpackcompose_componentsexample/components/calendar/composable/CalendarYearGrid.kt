package com.pk4us.jetpackcompose_componentsexample.components.calendar.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.pk4us.jetpackcompose_componentsexample.components.calendar.daterange.DateRange

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun CalendarYearGrid(
    gridState: LazyGridState,
    dateRangeByYear: DateRange,
    selectedYear: Int,
    currentYear: Int,
    onYearSelected: (Int) -> Unit
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        state = gridState,
        horizontalArrangement = Arrangement.spacedBy(
            space = 4.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        dateRangeByYear.forEach {
            item {
                CalendarYear(
                    year = it.year,
                    isSelectedYear = it.year == selectedYear,
                    isCurrentYear = it.year == currentYear,
                    setSelectedYear = { year ->
                        onYearSelected(year)
                    }
                )
            }
        }
    }

}