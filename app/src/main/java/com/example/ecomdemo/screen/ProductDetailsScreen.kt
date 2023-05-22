package com.example.ecomdemo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdemo.R
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.DarkGrey

@Composable
fun ProductDetailsScreen(productName: String) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = productName,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic),
                    fontSize = 25.sp,
                    color = BlueGrotto,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)
                )

                Image(
                    painter = painterResource(R.drawable.smartphone),
                    contentDescription = "Product",
                    modifier = Modifier
                        .padding(20.dp)
                        .size(200.dp)
                )

                Text(
                    text = "$productName is a top-of-the-line smartphone with advanced " +
                            "features that will impress even the most demanding users. " +
                            "With a large 6.7-inch Super AMOLED display and a resolution of " +
                            "1440 x 3200 pixels, you can enjoy stunning visuals and crisp, " +
                            "clear images. The phone is powered by a powerful Qualcomm Snapdragon" +
                            " 895 processor and comes with 12GB of RAM, ensuring fast and smooth " +
                            "performance even with multiple apps running in the background. " +
                            "The device has a large 128GB storage capacity, providing plenty of " +
                            "space for your apps, music, photos, and videos.",
                    fontSize = 15.sp,
                    color = DarkGrey,
                    style = TextStyle(fontStyle = FontStyle.Italic, fontFamily = FontFamily.Serif),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp)
                )
            }
        }
    }
}