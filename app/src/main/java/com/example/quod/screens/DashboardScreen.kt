package com.example.dashboard

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

data class GridItem(
    val name: String,
    val iconResId: Int,
    val route: String
)

@Composable
fun DashboardScreen(navController: NavController) {
    val itemsList = listOf(
        GridItem("Biometria Facial", R.drawable.icon_facial, "biometriaFacial"),
        GridItem("Biometria Digital", R.drawable.icon_digital, "biometriaDigital"),
        GridItem("Análise de Documento", R.drawable.icon_documento, "analise_documento_screen"),
        GridItem("SIM SWAP", R.drawable.icon_sim, "sim_swap_screen"),
        GridItem("Autenticação Cadastral", R.drawable.icon_autenticacao_cadastral, "autenticacao_cadastral_screen"),
        GridItem("Score Antifraude", R.drawable.icon_score, "score_anti_fraude_screen")
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
                            contentDescription = "LogOut",
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
                .background(color = colorResource(id = R.color.background))
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
                    Button(
                        onClick = { navController.navigate(item.route) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                            .background(Color(0xFF7850FF), shape = RoundedCornerShape(16.dp)),
                        contentPadding = PaddingValues(0.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.button),
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
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = item.name,
                                style = TextStyle(
                                    color = Color.White,
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
