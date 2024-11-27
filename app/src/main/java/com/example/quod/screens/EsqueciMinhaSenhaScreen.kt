package com.example.quod.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.ui.theme.Recursive

@Composable
fun EsqueciMinhaSenhaScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background_login),
            contentDescription = "Imagem de Fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Ícone de voltar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
        ) {
            IconButton(
                onClick = { navController.navigate("login_screen") },
                modifier = Modifier
                    .size(18.dp)
                    .align(Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = "Voltar",
                    tint = colorResource(id = R.color.white),
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.logo_quod_white),
            contentDescription = "Logo QuOD",
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.TopCenter)
                .padding(top = 40.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Informe seu email para solicitar reset da senha de acesso",
                fontSize = 16.sp,
                color = colorResource(id = R.color.text),
                style = TextStyle(
                    fontFamily = Recursive,
                    fontWeight = FontWeight.Normal
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de email
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        "Email",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused)
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Entrar
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                modifier = Modifier
                    .width(150.dp)
                    .height(48.dp)
                    .align(Alignment.End),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Enviar",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontFamily = Recursive)
                )
            }
        }
    }
}