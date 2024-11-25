package com.example.quod.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.ui.theme.Recursive

@Composable
fun ScoreAntiFraudeScreen(navController: NavController) {
    var score by remember { mutableStateOf(0) }
    var scoreMessage by remember { mutableStateOf("") }
    var scoreColor by remember { mutableStateOf(Color(0xFFA1A1A1)) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
    ) {
        // Botão de voltar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
        ) {
            IconButton(
                onClick = { navController.navigate("dashboard_screen") },
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

        Text(
            text = "Score Anti Fraude",
            style = TextStyle(
                color = colorResource(id = R.color.white),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Recursive
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 25.dp)
        )

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
            // Título
            Text(
                text = "Informe o CPF e clique no botão Enviar.",
                fontSize = 16.sp,
                color = colorResource(id = R.color.text),
                style = TextStyle(
                    fontFamily = Recursive,
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de CPF
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        "CPF *",
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

            // Medidor de score
            ScoreMeter(score)

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Enviar
            Button(
                onClick = {
                    score = (0..1000).random()
                    when (score) {
                        in 0..300 -> {
                            scoreColor = Color(0xFFFF0000)
                            scoreMessage = "Muito alta probabilidade de inadimplência e muito baixa chance de crédito."
                        }
                        in 301..500 -> {
                            scoreColor = Color(0xFFFED000)
                            scoreMessage = "Alta probabilidade de inadimplência e baixa chance de crédito."
                        }
                        in 501..700 -> {
                            scoreColor = Color(0xFFFFA500) // Laranja
                            scoreMessage = "Baixa probabilidade de inadimplência e alta chance de crédito."
                        }
                        in 701..1000 -> {
                            scoreColor = Color(0xFF008000)
                            scoreMessage = "Muito baixa probabilidade de inadimplência e muito alta chance de crédito."
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                modifier = Modifier
                    .width(150.dp)
                    .height(48.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Enviar",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontFamily = Recursive)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mensagem do resultado
            if (scoreMessage.isNotEmpty()) {
                Text(
                    text = scoreMessage,
                    fontSize = 14.sp,
                    color = scoreColor,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = Recursive,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Composable
fun ScoreMeter(score: Int) {
    val progress = score / 1000f

    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator(
            progress = {
                1f
            },
            modifier = Modifier
                .size(200.dp),
            color = colorResource(id = R.color.border),
            strokeWidth = 16.dp,
        )

        // Score colorido
        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .size(200.dp),
            color = when (score) {
                in 0..300 -> colorResource(id = R.color.red)
                in 301..800 -> colorResource(id = R.color.yellow)
                else -> colorResource(id = R.color.green)
            },
            strokeWidth = 16.dp,
        )

        // Score no centro
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = score.toString(),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.text_gray)
            )
            Text(
                text = "de 1000",
                fontSize = 16.sp,
                color = colorResource(id = R.color.text_gray)
            )
        }
    }
}
