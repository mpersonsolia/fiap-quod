package com.example.quod.screens


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
fun BiometriaFacialFalhaScreen(navController: NavController) {
    val context = LocalContext.current
    var showMessage by remember { mutableStateOf(false) }
    var showInstructions by remember { mutableStateOf(true) } // Controla exibição das instruções
    var frontPhoto by remember { mutableStateOf(false) }
    var topPhoto by remember { mutableStateOf(false) }
    var sidePhoto by remember { mutableStateOf(false) }

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
                onClick = { navController.navigate("biometria_facial_screen") },
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
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Instruções para capturar as fotos
            if (showInstructions) {
                Text(
                    text = "Siga as seguintes instruções para garantir o registro de boas fotos:\n" +
                            "\n" +
                            "- Certifique-se de que você está em um local bem iluminado\n" +
                            "- Dê preferência para um local que possua um fundo branco\n" +
                            "- Lembre-se de retirar acessórios como óculos ou chapéu",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.text),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = Recursive,
                        fontWeight = FontWeight.Normal
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { showInstructions = false },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Entendi",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white)
                    )
                }
            } else {
                Text(
                    text = "Capture e envie as três fotos.",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.text),
                    style = TextStyle(
                        fontFamily = Recursive,
                        fontWeight = FontWeight.Normal
                    ),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Botão para capturar foto frontal
                Button(
                    onClick = { frontPhoto = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Foto de Frente",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white)
                    )
                }

                if (frontPhoto) {
                    Image(
                        painter = painterResource(id = R.drawable.image_face_front),
                        contentDescription = "Foto Frontal",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .border(1.dp, colorResource(id = R.color.border), RoundedCornerShape(8.dp))
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botão para capturar foto de lado
                Button(
                    onClick = { topPhoto = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Foto do Lado Direito",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white)
                    )
                }

                if (topPhoto) {
                    Image(
                        painter = painterResource(id = R.drawable.image_face_left),
                        contentDescription = "Foto do Lado Direito",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .border(1.dp, colorResource(id = R.color.border), RoundedCornerShape(8.dp))
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botão para capturar foto de lado
                Button(
                    onClick = { sidePhoto = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Foto do Lado Esquerdo",
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white)
                    )
                }

                if (sidePhoto) {
                    Image(
                        painter = painterResource(id = R.drawable.image_face_right),
                        contentDescription = "Foto do Lado Esquerdo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .border(1.dp, colorResource(id = R.color.border), RoundedCornerShape(8.dp))
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botão Enviar
                Button(
                    onClick = {
                        if (frontPhoto && topPhoto && sidePhoto) {
                            showMessage = true
                        } else {
                            Toast.makeText(context, "Por favor, capture as três fotos faciais.", Toast.LENGTH_SHORT).show()
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
                        text = "Biometria facial inválida. Por favor, tente novamente.",
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
}