package com.example.quod.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.ui.theme.Recursive
import android.widget.Toast

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current

    val email = remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf<String?>(null) }
    val password = remember { mutableStateOf("") }
    val passwordError = remember { mutableStateOf<String?>(null) }

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

        Image(
            painter = painterResource(id = R.drawable.logo_quod_white),
            contentDescription = "Logo QuOD",
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.TopCenter)
                .padding(top = 50.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(410.dp)
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
                .offset(y = 60.dp)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Informe suas credenciais para se logar",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text),
                    style = TextStyle(
                        fontFamily = Recursive,
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de email
            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                    emailError.value = null
                },
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
                isError = emailError.value != null,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = if (emailError.value != null) colorResource(id = R.color.red) else colorResource(id = R.color.border),
                    focusedBorderColor = if (emailError.value != null) colorResource(id = R.color.red) else colorResource(id = R.color.border_focused)
                )
            )

            if (emailError.value != null) {
                Text(
                    text = emailError.value!!,
                    color = colorResource(id = R.color.red),
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Campo de senha
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                    passwordError.value = null
                },
                label = {
                    Text(
                        "Senha",
                        style = TextStyle(
                            fontFamily = Recursive,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                isError = passwordError.value != null,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = if (passwordError.value != null) colorResource(id = R.color.red) else colorResource(id = R.color.border),
                    focusedBorderColor = if (passwordError.value != null) colorResource(id = R.color.red) else colorResource(id = R.color.border_focused)
                )
            )

            if (passwordError.value != null) {
                Text(
                    text = passwordError.value!!,
                    color = colorResource(id = R.color.red),
                    fontSize = 12.sp,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.weight(1f))

            // Texto "Esqueci minha senha"
            Text(
                text = "Esqueci minha senha",
                fontSize = 14.sp,
                color = colorResource(id = R.color.link),
                style = TextStyle(
                    fontFamily = Recursive,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        navController.navigate("esqueci_minha_senha_screen")
                    }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão Entrar
            Button(
                onClick = {
                    var hasError = false

                    if (email.value.isBlank()) {
                        emailError.value = "Campo de preenchimento obrigatório."
                        hasError = true
                    }
                    if (password.value.isBlank()) {
                        passwordError.value = "Campo de preenchimento obrigatório."
                        hasError = true
                    }

                    if (hasError) {
                        Toast.makeText(
                            context,
                            "Por favor, preencha os campos obrigatórios.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        navController.navigate("dashboard_screen")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                modifier = Modifier
                    .width(150.dp)
                    .height(48.dp)
                    .align(Alignment.End),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Entrar",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(fontFamily = Recursive)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Termos e Políticas
            Text(
                text = buildAnnotatedString {
                    append("Ao entrar você está de acordo com os ")
                    pushStringAnnotation(
                        tag = "URL",
                        annotation = "https://www.quod.com.br/dist/files/Termos-quod.pdf"
                    )
                    withStyle(style = SpanStyle(color = colorResource(id = R.color.link), fontWeight = FontWeight.Bold)) {
                        append("Termos de Uso e Política de Privacidade")
                    }
                    pop()
                },
                fontSize = 12.sp,
                color = colorResource(id = R.color.text),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = Recursive,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://www.quod.com.br/dist/files/Termos-quod.pdf")
                        )
                        context.startActivity(intent)
                    }
            )
        }
    }
}
