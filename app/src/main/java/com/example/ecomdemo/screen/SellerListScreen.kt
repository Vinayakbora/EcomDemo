package com.example.ecomdemo.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecomdemo.data.db.entities.Seller
import com.example.ecomdemo.R
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.DarkGrey


@Composable
fun SellerListScreen(sellers: List<Seller>) {
    Column {
        SellerListTopBar()
        SellerList(sellers)
    }
}

@Composable
fun SellerListTopBar() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "All Sellers",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = BlueGrotto,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(16.dp).wrapContentWidth()
        )
    }
}

@Composable
fun SellerList(sellers: List<Seller>) {

    LazyColumn {
        items(sellers) { seller ->
            Card(
                elevation = 3.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.seller_contact),
                        contentDescription = "Product",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(50.dp)
                    )
                    Text(
                        text = seller.name ?: "",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .wrapContentHeight()
                            .width(100.dp)
                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = seller.address ?: "",
                            fontSize = 15.sp,
                            color = DarkGrey,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(16.dp)
                                .wrapContentWidth()
                        )
                        Text(
                            text = seller.contact ?: "",
                            textAlign = TextAlign.End,
                            fontSize = 15.sp,
                            color = DarkGrey,
                            modifier = Modifier
                                .padding(16.dp)
                                .wrapContentWidth()
                        )
                    }
                }
            }
        }
    }
}
