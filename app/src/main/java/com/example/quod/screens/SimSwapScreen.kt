package com.example.quod.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.ui.theme.Recursive

data class SimSwapItem(
    val name: String,
    val iconResId: Int,
    val route: String
)

@Composable
fun SimSwapScreen(navController: NavController) {
    val itemsList = listOf(
        SimSwapItem("Sem Troca", R.drawable.icon_success, "sim_swap_sem_troca_screen"),
        SimSwapItem("Com Troca", R.drawable.icon_fail, "sim_swap_com_troca_screen")
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = colorResource(id = R.color.white),
                modifier = Modifier
                    .height(56.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                NavigationBarItem(
                    selected = true,
                    onClick = { navController.navigate("dashboard_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_home),
                            contentDescription = "Home",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("user_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_user),
                            contentDescription = "User",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {navController.navigate("termo_de_uso_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_terms),
                            contentDescription = "Terms",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("login_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_logout),
                            contentDescription = "Sair",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_quod_white),
                contentDescription = "Logo Quod",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp)
                    .size(120.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Título
            Text(
                text = "SIM SWAP",
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Recursive
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 25.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(itemsList) { item ->

                    val buttonColor = when (item.name) {
                        "Com Troca" -> colorResource(id = R.color.red)
                        "Sem Troca" -> colorResource(id = R.color.green)
                        else -> colorResource(id = R.color.button)
                    }

                    Button(
                        onClick = {
                            navController.navigate(item.route)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp),
                        contentPadding = PaddingValues(0.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColor,
                            contentColor = colorResource(id = R.color.white)
                        )
                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                painter = painterResource(id = item.iconResId),
                                contentDescription = item.name,
                                tint = colorResource(id = R.color.white),
                                modifier = Modifier.size(32.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = item.name,
                                style = TextStyle(
                                    color = colorResource(id = R.color.white),
                                    fontSize = 15.sp,
                                    fontFamily = Recursive,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
