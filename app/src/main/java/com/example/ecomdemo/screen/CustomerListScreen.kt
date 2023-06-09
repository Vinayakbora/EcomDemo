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
import com.example.ecomdemo.data.db.entities.Customer
import com.example.ecomdemo.R
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.DarkGrey

@Composable
fun CustomerListScreen(customers: List<Customer>) {
    Column {
        CustomerListTopBar()
        CustomerList(customers)
    }
}

@Composable
fun CustomerListTopBar() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "All Customers",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = BlueGrotto,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(16.dp).wrapContentWidth()
        )
    }
}

@Composable
fun CustomerList(customers: List<Customer>) {

    LazyColumn {
        items(customers) { customer ->
            Card(
                elevation = 5.dp,
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
                        painter = painterResource(R.drawable.user),
                        contentDescription = "User",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(50.dp)
                    )
                    Text(
                        text = customer.firstName + " " + customer.lastName,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Start,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .wrapContentHeight()
                            .width(100.dp)
                    )
                    Text(
                        text = customer.phoneNumber,
                        textAlign = TextAlign.End,
                        fontSize = 15.sp,
                        color = DarkGrey,
                        modifier = Modifier
                            .padding(vertical = 10.dp, horizontal = 10.dp)
                            .wrapContentWidth()
                    )
                }
            }
        }
    }
}
