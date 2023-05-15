package com.example.ecomdemo.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.ecomdemo.ui.theme.BlueGrotto

@Composable
fun OSTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    label: String = "",
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = BlueGrotto) },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        modifier = modifier.padding(vertical = 10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            cursorColor = BlueGrotto,
            focusedBorderColor = BlueGrotto,
            unfocusedBorderColor = BlueGrotto
        ),
    )
}