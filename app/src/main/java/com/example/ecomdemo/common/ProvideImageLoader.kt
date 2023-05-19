package com.example.ecomdemo.common

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import android.os.Build

@Composable
fun provideImageLoader(context: Context): ImageLoader {
    return remember(context) {
        ImageLoader.Builder(context).components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()
    }
}