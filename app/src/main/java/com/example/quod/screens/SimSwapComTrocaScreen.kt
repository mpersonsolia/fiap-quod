package com.example.quod.screens

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
fun SimSwapComTrocaScreen(navController: NavController) {
    var imei by remember { mutableStateOf("") }
    var iccid by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }

    var imeiValido by remember { mutableStateOf(true) }
    var iccidValido by remember { mutableStateOf(true) }
    var celularValido by remember { mutableStateOf(true) }

    var showMessage by remember { mutableStateOf(false) }
    var buttonClicked by remember { mutableStateOf(false) }

    var toastMessage by remember { mutableStateOf<String?>(null) }

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
                onValueChange = {
                    imei = it
                    imeiValido = it.isNotEmpty()
                },
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
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused)
                ),
                isError = !imeiValido && buttonClicked,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )

            if (!imeiValido && buttonClicked) {
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
                onValueChange = {
                    iccid = it
                    iccidValido = it.isNotEmpty()
                },
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
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused)
                ),
                isError = !iccidValido && buttonClicked,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )

            if (!iccidValido && buttonClicked) {
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
                value = celular,
                onValueChange = {
                    celular = it
                    celularValido = it.isNotEmpty()
                },
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
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = colorResource(id = R.color.border),
                    focusedBorderColor = colorResource(id = R.color.border_focused)
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
                    imeiValido = imei.isNotEmpty()
                    iccidValido = iccid.isNotEmpty()
                    celularValido = celular.isNotEmpty()
                    celular = formatarCelular(celular)

                    buttonClicked = true

                    if (imeiValido && iccidValido && celularValido) {
                        showMessage = true
                        toastMessage = "O SIM do número informado foi trocado."
                    } else {
                        toastMessage = "Por favor, preencha todos os campos."
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

            Spacer(modifier = Modifier.height(16.dp))

            if (showMessage) {
                Text(
                    text = toastMessage ?: "",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.red),
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
