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
import androidx.compose.ui.graphics.Color
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
fun BiometriaDigitalSucessoScreen(navController: NavController) {
    val context = LocalContext.current
    var showInstructions by remember { mutableStateOf(true) }
    var fingerOne by remember { mutableStateOf(false) }
    var fingerTwo by remember { mutableStateOf(false) }
    var fingerThree by remember { mutableStateOf(false) }
    var fingerFour by remember { mutableStateOf(false) }
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
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
                .background(
                    color = colorResource(id = R.color.white),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            // Botão para capturar a impressão digital do dedo 1
            Button(
                onClick = { fingerOne = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Polegar Direito",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }

            if (fingerOne) {
                Image(
                    painter = painterResource(id = R.drawable.finger1),
                    contentDescription = "Impressão Digital 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .border(1.dp, colorResource(id = R.color.border), RoundedCornerShape(8.dp))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão para capturar a impressão digital do dedo 2
            Button(
                onClick = { fingerTwo = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Polegar Esquerdo",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }

            if (fingerTwo) {
                Image(
                    painter = painterResource(id = R.drawable.finger2),
                    contentDescription = "Impressão Digital 2",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .border(1.dp, colorResource(id = R.color.border), RoundedCornerShape(8.dp))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botão para capturar a impressão digital do dedo 3
            Button(
                onClick = { fingerThree = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Indicador Direito",
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.white)
                )
            }

            if (fingerThree) {
                Image(
                    painter = painterResource(id = R.drawable.finger3),
                    contentDescription = "Impressão Digital 3",
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
                    if (fingerOne && fingerTwo && fingerThree) {
                        showMessage = true
                    } else {
                        Toast.makeText(context, "Por favor, capture todas as impressões digitais.", Toast.LENGTH_SHORT).show()
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
                    text = "Impressões digitais validadas com sucesso.",
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.green),
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
