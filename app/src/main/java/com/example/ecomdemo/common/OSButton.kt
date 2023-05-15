package com.example.ecomdemo.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ecomdemo.ui.theme.BlueGreen

@Composable
fun OSButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    shape: RoundedCornerShape = RoundedCornerShape(50.dp)
    ){
    Button(
        modifier = modifier.padding(vertical = 10.dp, horizontal = 40.dp).fillMaxWidth().height(50.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = BlueGreen, contentColor = Color.White),
        shape = shape,
        border = BorderStroke(1.dp, BlueGreen),
    ) {
        Text(text)
    }
}