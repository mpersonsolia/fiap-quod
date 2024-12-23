package com.example.quod.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
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
import androidx.compose.ui.platform.LocalContext

@Composable
fun ScoreAntiFraudeScreen(navController: NavController) {
    val context = LocalContext.current
    var cpf by remember { mutableStateOf("") }
    var cpfError by remember { mutableStateOf(false) }
    var score by remember { mutableStateOf(0) }
    var scoreMessage by remember { mutableStateOf("") }
    var scoreColor by remember { mutableStateOf(Color(0xFFA1A1A1)) }
    var errorMessage by remember { mutableStateOf("") }

    // Validação de CPF
    fun isCPFValid(cpf: String): Boolean {
        val cleanCPF = cpf.filter { it.isDigit() }

        if (cleanCPF.length != 11) return false

        if (cleanCPF.all { it == cleanCPF[0] }) return false

        var sum = 0
        for (i in 0..8) {
            sum += cleanCPF[i].toString().toInt() * (10 - i)
        }
        var firstVerifier = sum % 11
        firstVerifier = if (firstVerifier < 2) 0 else 11 - firstVerifier

        sum = 0
        for (i in 0..8) {
            sum += cleanCPF[i].toString().toInt() * (11 - i)
        }
        sum += firstVerifier * 2
        var secondVerifier = sum % 11
        secondVerifier = if (secondVerifier < 2) 0 else 11 - secondVerifier

        return cleanCPF[9].toString().toInt() == firstVerifier && cleanCPF[10].toString().toInt() == secondVerifier
    }

    // Máscara no CPF
    fun applyCPFMask(input: String): String {
        val digitsOnly = input.filter { it.isDigit() }
        return buildString {
            for (i in digitsOnly.indices) {
                append(digitsOnly[i])
                if (i == 2 || i == 5) append(".")
                if (i == 8) append("-")
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
    ) {
        // Título
        Text(
            text = "Score Antifraude",
            fontSize = 20.sp,
            color = colorResource(id = R.color.white),
            fontFamily = Recursive,
            modifier = Modifier
                .padding(start = 24.dp, top = 56.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(490.dp)
                .padding(horizontal = 24.dp)
                .padding(top = 20.dp)
                .align(Alignment.Center)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Informe o CPF e clique no botão Enviar",
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
            BasicTextField(
                value = cpf,
                onValueChange = { input ->
                    cpf = input.filter { it.isDigit() }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .border(
                        width = 1.dp,
                        color = if (cpfError) colorResource(id = R.color.red) else colorResource(id = R.color.border),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(8.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Recursive,
                    color = colorResource(id = R.color.text)
                ),
                cursorBrush = SolidColor(colorResource(id = R.color.text))
            )

            if (cpfError) {
                Text(
                    text = errorMessage,
                    color = colorResource(id = R.color.red),
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Medidor de score
            ScoreMeter(score)

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de Enviar
            Button(
                onClick = {
                    val cleanCPF = cpf.filter { it.isDigit() }

                    when {
                        cleanCPF.isBlank() -> {
                            cpfError = true
                            errorMessage = "Campo de preenchimento obrigatório."
                            scoreMessage = "" // Reseta o ScoreMeter
                            scoreColor = Color(0xFFA1A1A1) // Cor padrão
                            score = 0 // Valor inicial do ScoreMeter
                            Toast.makeText(
                                context,
                                "Campo de preenchimento obrigatório.",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                        !isCPFValid(cleanCPF) -> {
                            cpfError = true
                            errorMessage = "O CPF informado é inválido."
                            scoreMessage = "" // Reseta o ScoreMeter
                            scoreColor = Color(0xFFA1A1A1) // Cor padrão
                            score = 0 // Valor inicial do ScoreMeter
                            Toast.makeText(
                                context,
                                "O CPF informado é inválido.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            cpfError = false
                            errorMessage = ""
                            cpf = applyCPFMask(cleanCPF)
                            score = (0..1000).random()
                            scoreMessage = when (score) {
                                in 0..300 -> {
                                    scoreColor = Color(0xFFFF0000)
                                    "Enorme probabilidade de se tratar de uma operação fraudulenta."
                                }
                                in 301..500 -> {
                                    scoreColor = Color(0xFFFED000)
                                    "Alta probabilidade de se tratar de uma operação fraudulenta."
                                }
                                in 501..700 -> {
                                    scoreColor = Color(0xFFFFA500)
                                    "Baixa probabilidade de se tratar de uma operação fraudulenta."
                                }
                                in 701..1000 -> {
                                    scoreColor = Color(0xFF008000)
                                    "Muito baixa probabilidade de se tratar de uma operação fraudulenta."
                                }
                                else -> ""
                            }
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

            if (scoreMessage.isNotEmpty()) {
                Text(
                    text = scoreMessage,
                    fontSize = 14.sp,
                    color = scoreColor,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontFamily = Recursive, textAlign = TextAlign.Center),
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

        CircularProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .size(200.dp),
            color = when (score) {
                in 0..300 -> colorResource(id = R.color.red)
                in 301..500 -> colorResource(id = R.color.yellow)
                in 501..700 -> colorResource(id = R.color.orange)
                in 701..1000 -> colorResource(id = R.color.green)
                else -> colorResource(id = R.color.border)
            },
            strokeWidth = 16.dp
        )

        Text(
            text = "$score",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.text)
        )
    }
}