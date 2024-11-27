package com.example.quod.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import android.widget.Toast

@Composable
fun SimSwapSemTrocaScreen(navController: NavController) {
    var imei by remember { mutableStateOf("") }
    var iccid by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var imeiError by remember { mutableStateOf(false) }
    var iccidError by remember { mutableStateOf(false) }
    var telefoneError by remember { mutableStateOf(false) }

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
                onClick = { navController.navigate("sim_swap_screen") },
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
                .height(450.dp)
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

            // Campo de IMEI
            OutlinedTextField(
                value = imei,
                onValueChange = { imei = it },
                label = {
                    Text(
                        "IMEI *",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                isError = imeiError,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused),
                    errorBorderColor = colorResource(id = R.color.red)
                )
            )
            if (imeiError) {
                Text(
                    text = "Campo de preenchimento obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Campo de ICCID
            OutlinedTextField(
                value = iccid,
                onValueChange = { iccid = it },
                label = {
                    Text(
                        "ICCID *",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                isError = iccidError,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused),
                    errorBorderColor = colorResource(id = R.color.red)
                )
            )
            if (iccidError) {
                Text(
                    text = "Campo de preenchimento obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Campo de Telefone celular
            OutlinedTextField(
                value = telefone,
                onValueChange = { telefone = it },
                label = {
                    Text(
                        "Telefone celular *",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                isError = telefoneError,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused),
                    errorBorderColor = colorResource(id = R.color.red)
                )
            )
            if (telefoneError) {
                Text(
                    text = "Campo de preenchimento obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Enviar
            Button(
                onClick = {
                    imeiError = imei.isBlank()
                    iccidError = iccid.isBlank()
                    telefoneError = telefone.isBlank()

                    // Verificar se algum campo está em branco e mostrar o Toast
                    if (imeiError || iccidError || telefoneError) {
                        Toast.makeText(navController.context, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
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
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontFamily = Recursive)
                )
            }

        }
    }
}
