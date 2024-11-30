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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import com.example.quod.R
import com.example.quod.ui.theme.Recursive

@Composable
fun AnaliseDocumentoFalhaScreen(navController: NavController) {
    val context = LocalContext.current
    var documentPhoto by remember { mutableStateOf(false) }
    var facePhoto by remember { mutableStateOf(false) }

    var documentPhotoValid by remember { mutableStateOf(true) }
    var facePhotoValid by remember { mutableStateOf(true) }

    var buttonClicked by remember { mutableStateOf(false) }
    var showMessage by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.background))
    ) {

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
                text = "Adicione os dados e clique no botão Enviar",
                fontSize = 16.sp,
                color = colorResource(id = R.color.text),
                style = TextStyle(
                    fontFamily = Recursive,
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Upload da foto do documento
            Button(
                onClick = {
                    documentPhoto = true
                    documentPhotoValid = true
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Capturar Foto do Documento",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }

            if (!documentPhotoValid && buttonClicked) {
                Text(
                    text = "Envio obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (documentPhoto) {
                Image(
                    painter = painterResource(id = R.drawable.image_analisedocumento),
                    contentDescription = "Foto do Documento",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .border(1.dp, colorResource(id = R.color.border), RoundedCornerShape(8.dp))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Upload da foto do rosto
            Button(
                onClick = {
                    facePhoto = true
                    facePhotoValid = true
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Capturar Foto do Rosto",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }

            if (!facePhotoValid && buttonClicked) {
                Text(
                    text = "Envio obrigatório.",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.red),
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (facePhoto) {
                Image(
                    painter = painterResource(id = R.drawable.image_face),
                    contentDescription = "Foto do Rosto",
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
                    buttonClicked = true
                    documentPhotoValid = documentPhoto
                    facePhotoValid = facePhoto

                    if (documentPhotoValid && facePhotoValid) {
                        showMessage = true
                    } else {
                        Toast.makeText(
                            context,
                            "Por favor, capture as fotos do documento e do rosto.",
                            Toast.LENGTH_SHORT
                        ).show()
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
                    text = "O documento enviado não é autêntico.",
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
