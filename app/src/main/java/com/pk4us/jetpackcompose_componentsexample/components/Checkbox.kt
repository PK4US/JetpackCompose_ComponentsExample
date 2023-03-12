package com.pk4us.jetpackcompose_componentsexample.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyCheckboxScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CheckboxExample1()
        Divider()
        CheckboxExample2()
        Divider()
        CheckboxExample3()
        Divider()
        CheckboxExample4()
        Divider()
        CheckboxExample5(
            mItemsList = listOf(
                "Grouped Checkbox One", "Grouped Checkbox Two", "Grouped Checkbox Three"
            )
        )
        Divider()
        CheckboxExample6()
    }
}


@Preview
@Composable
fun CheckboxExample1() {
    val checkedState = remember { mutableStateOf(true) }
    Checkbox(checked = checkedState.value, onCheckedChange = { checkedState.value = it })
}


@Preview
@Composable
fun CheckboxExample2() {
    val isChecked = remember { mutableStateOf(false) }

    Checkbox(
        checked = isChecked.value, onCheckedChange = { isChecked.value = it }, enabled = true
    )
}

@Preview
@Composable
fun CheckboxExample3() {
    val (checkedState, onStateChange) = remember { mutableStateOf(true) }
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .toggleable(
                value = checkedState,
                onValueChange = { onStateChange(!checkedState) },
                role = Role.Checkbox
            )
            .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checkedState,
            onCheckedChange = null // null recommended for accessibility with screenreaders
        )
        Text(
            text = "Option selection",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@Preview
@Composable
fun CheckboxExample4() {
    val isChecked = remember { mutableStateOf(false) }

    Checkbox(
        checked = isChecked.value, onCheckedChange = { isChecked.value = it }, enabled = false
    )
}


@Composable
fun CheckboxExample5(mItemsList: List<String>) {

    mItemsList.forEach { items ->
        Row(modifier = Modifier.padding(8.dp)) {
            val isChecked = remember { mutableStateOf(false) }

            Checkbox(
                checked = isChecked.value,
                onCheckedChange = { isChecked.value = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Magenta,
                    uncheckedColor = Color.DarkGray,
                    checkmarkColor = Color.Cyan
                )
            )
            Text(text = items)
        }
    }
}


@Preview
@Composable
fun CheckboxExample6() {
    Column {
        // define dependent checkboxes states
        val (state, onStateChange) = remember { mutableStateOf(true) }
        val (state2, onStateChange2) = remember { mutableStateOf(true) }

        // TriStateCheckbox state reflects state of dependent checkboxes
        val parentState = remember(state, state2) {
            if (state && state2) ToggleableState.On
            else if (!state && !state2) ToggleableState.Off
            else ToggleableState.Indeterminate
        }
        // click on TriStateCheckbox can set state for dependent checkboxes
        val onParentClick = {
            val s = parentState != ToggleableState.On
            onStateChange(s)
            onStateChange2(s)
        }

        TriStateCheckbox(
            state = parentState, onClick = onParentClick
        )
        Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
            Checkbox(state, onStateChange)
            Checkbox(state2, onStateChange2)
        }
    }
}