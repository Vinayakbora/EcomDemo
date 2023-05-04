package com.example.ecomdemo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.ecomdemo.Routes
import com.example.ecomdemo.ui.theme.LightGreen3
import com.example.ecomdemo.ui.theme.LightRed

@Composable
fun SignUpOption(navController: NavHostController) {
    Column(verticalArrangement = Arrangement.Center) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(16.dp,10.dp)
                    .clickable { navController.navigate(Routes.UserSignUp.route) }
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().background(LightGreen3)
                ) {
                    Text(
                        text = "USER",
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(16.dp,10.dp)
                    .clickable { navController.navigate(Routes.SellerSignUp.route){
                        popUpTo(Routes.SignUpOption.route) { inclusive = true }
                        launchSingleTop = true
                    } }
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize().background(LightRed)
                ) {
                    Text(
                        text = "SELLER",
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}