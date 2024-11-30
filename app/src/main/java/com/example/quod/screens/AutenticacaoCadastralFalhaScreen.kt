package com.example.quod.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.ui.theme.Recursive

@Composable
fun AutenticacaoCadastralFalhaScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }

    var nomeValido by remember { mutableStateOf(true) }
    var cpfValido by remember { mutableStateOf(true) }
    var enderecoValido by remember { mutableStateOf(true) }
    var celularValido by remember { mutableStateOf(true) }

    var showSuccessMessage by remember { mutableStateOf(false) }

    var buttonClicked by remember { mutableStateOf(false) }


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

    // Máscara do celular
    fun formatarCelular(celular: String): String {
        val celularLimpo = celular.replace(Regex("[^\\d]"), "") // Remove qualquer caractere não numérico
        return when (celularLimpo.length) {
            11 -> "(${celularLimpo.substring(0, 2)}) ${celularLimpo.substring(2, 7)}-${celularLimpo.substring(7)}"
            10 -> "(${celularLimpo.substring(0, 2)}) ${celularLimpo.substring(2, 6)}-${celularLimpo.substring(6)}"
            else -> celular // Retorna o número original se não tiver 10 ou 11 dígitos
        }
    }


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
                onClick = { navController.navigate("autenticacao_cadastral_screen") },
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

        Spacer(modifier = Modifier.height(120.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
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
                text = "Informe os dados e clique no botão Enviar.",
                fontSize = 16.sp,
                color = colorResource(id = R.color.text),
                style = TextStyle(
                    fontFamily = Recursive,
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de nome
            OutlinedTextField(
                value = nome,
                onValueChange = {
                    nome = it
                    nomeValido = it.isNotEmpty()
                },
                label = {
                    Text(
                        "Nome *",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused),
                    unfocusedLabelColor = colorResource(id = R.color.text),
                    focusedLabelColor = colorResource(id = R.color.text)
                ),
                isError = !nomeValido && buttonClicked
            )

            if (!nomeValido && buttonClicked) {
                Text(
                    text = "Campo de preenchimento obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Campo de CPF
            OutlinedTextField(
                value = cpf,
                onValueChange = {
                    cpf = it
                    cpfValido = it.isNotEmpty()
                },
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
                    focusedBorderColor = colorResource(id = R.color.border_focused),
                    unfocusedLabelColor = colorResource(id = R.color.text),
                    focusedLabelColor = colorResource(id = R.color.text)
                ),
                isError = !cpfValido && buttonClicked,

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Number,
                    imeAction = ImeAction.Done
                )

            )

            if (!cpfValido && buttonClicked) {
                Text(
                    text = "Campo de preenchimento obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Campo de endereço
            OutlinedTextField(
                value = endereco,
                onValueChange = {
                    endereco = it
                    enderecoValido = it.isNotEmpty()
                },
                label = {
                    Text(
                        "Endereço *",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused),
                    unfocusedLabelColor = colorResource(id = R.color.text),
                    focusedLabelColor = colorResource(id = R.color.text)
                ),
                isError = !enderecoValido && buttonClicked
            )

            if (!enderecoValido && buttonClicked) {
                Text(
                    text = "Campo de preenchimento obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Campo de celular
            OutlinedTextField(
                value = celular,
                onValueChange = {
                    celular = it
                    celularValido = it.isNotEmpty()
                },
                label = {
                    Text(
                        "Celular *",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused),
                    unfocusedLabelColor = colorResource(id = R.color.text),
                    focusedLabelColor = colorResource(id = R.color.text)
                ),
                isError = !celularValido && buttonClicked,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )

            if (!celularValido && buttonClicked) {
                Text(
                    text = "Campo de preenchimento obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Enviar
            Button(
                onClick = {
                    nomeValido = nome.isNotEmpty()
                    cpfValido = cpf.isNotEmpty()
                    cpf = applyCPFMask(cpf)
                    enderecoValido = endereco.isNotEmpty()
                    celularValido = celular.isNotEmpty()
                    celular = formatarCelular(celular)

                    buttonClicked = true

                    if (!nomeValido || !cpfValido || !enderecoValido || !celularValido) {
                        Toast.makeText(navController.context, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                    } else {
                        showSuccessMessage = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE)
                ),
                modifier = Modifier
                    .width(150.dp)
                    .height(48.dp)
                    .align(Alignment.CenterHorizontally),
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

            Spacer(modifier = Modifier.height(16.dp))

            if (showSuccessMessage) {
                Text(
                    text = "Os dados cadastrais informados não são autênticos.",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.red),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = Recursive,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}