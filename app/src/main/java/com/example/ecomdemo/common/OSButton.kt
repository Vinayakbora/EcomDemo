package com.example.ecomdemo.common

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.ecomdemo.R
import com.example.ecomdemo.ui.theme.BlueGreen

@Composable
fun OSButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    shape: RoundedCornerShape = RoundedCornerShape(50.dp)
    ){

    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Button(
        modifier = modifier.padding(vertical = 10.dp, horizontal = 40.dp).fillMaxWidth().height(50.dp),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(contentColor = BlueGreen),
        shape = shape,
        border = BorderStroke(3.dp, BlueGreen),
    ) {
        Text(text, style = TextStyle(fontSize = 20.sp,fontWeight = FontWeight.Bold))
        Image(
            painter = rememberAsyncImagePainter(R.drawable.fast_forward, imageLoader),
            contentDescription = null,
            modifier = Modifier.wrapContentWidth().padding(horizontal = 5.dp),
        )
    }
}