package com.example.ecomdemo.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.ecomdemo.Routes
import com.example.ecomdemo.ui.theme.BlueGreen
import com.example.ecomdemo.ui.theme.BlueGrotto
import com.example.ecomdemo.ui.theme.LightGreen3
import com.example.ecomdemo.ui.theme.LightRed
import com.example.ecomdemo.ui.viewmodels.MainViewModel

@Composable
fun SignUpOption(navController: NavHostController, mainViewModel: MainViewModel) {
    Column {
        Spacer(modifier = Modifier.height(120.dp))
        Button(
            onClick = {
                mainViewModel._customerListState.observe(
                    navController.context as LifecycleOwner
                ) {
                    navController.navigate(Routes.UserList.route) {
                        launchSingleTop = true
                    }
                }
                mainViewModel.getAllCustomers()
            },
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 40.dp)
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(1.dp, BlueGrotto),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = BlueGrotto)
        ) {
            Text(text = "Show Users")
        }

        Card(elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 10.dp, horizontal = 30.dp)
                .clickable {
                    navController.navigate(Routes.UserSignUp.route)
                }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(BlueGrotto)
            ) {
                Text(
                    text = "USER",
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
        }


        Card(elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(vertical = 10.dp, horizontal = 30.dp)
                .clickable {
                    navController.navigate(Routes.SellerSignUp.route)
                }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(BlueGreen)
            ) {
                Text(
                    text = "SELLER",
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
        }

        Button(
            onClick = {
                mainViewModel._sellerListState.observe(
                    navController.context as LifecycleOwner
                ) {
                    navController.navigate(Routes.SellerList.route) {
                        launchSingleTop = true
                    }
                }
                mainViewModel.getAllSeller()
            },
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 40.dp)
                .fillMaxWidth()
                .height(50.dp),
            border = BorderStroke(1.dp, BlueGreen),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = BlueGreen)
        ) {
            Text(text = "Show Sellers")
        }
    }
}