package com.example.quod.navigation

import UserScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard.AutenticacaoCadastralScreen
import com.example.quod.screens.AnaliseDocumentoFalhaScreen
import com.example.quod.screens.AnaliseDocumentoScreen
import com.example.quod.screens.AnaliseDocumentoSucessoScreen
import com.example.quod.screens.AutenticacaoCadastralFalhaScreen
import com.example.quod.screens.AutenticacaoCadastralSucessoScreen
import com.example.quod.screens.EsqueciMinhaSenhaScreen
import com.example.quod.screens.LoginScreen
import com.example.quod.screens.ScoreAntiFraudeScreen
import com.example.quod.screens.SimSwapComTrocaScreen
import com.example.quod.screens.SimSwapScreen
import com.example.quod.screens.SimSwapSemTrocaScreen
import com.example.quod.screens.BiometriaFacialFalhaScreen
import com.example.quod.screens.BiometriaFacialSucessoScreen
import com.example.quod.screens.BiometriaFacialScreen
import com.example.quod.screens.BiometriaDigitalFalhaScreen
import com.example.quod.screens.BiometriaDigitalSucessoScreen
import com.example.quod.screens.BiometriaDigitalScreen
import com.example.quod.screens.DashboardScreen
import com.example.quod.screens.TermoDeUsoScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login_screen"
    ) {
        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("esqueci_minha_senha_screen") {
            EsqueciMinhaSenhaScreen(navController = navController)
        }
        composable("dashboard_screen") {
            DashboardScreen(navController = navController)
        }
        composable("termo_de_uso_screen") {
            TermoDeUsoScreen(navController = navController)
        }
        composable("user_screen") {
            UserScreen(navController = navController)
        }
        composable("autenticacao_cadastral_screen") {
            AutenticacaoCadastralScreen(navController = navController)
        }
        composable("autenticacao_cadastral_sucesso_screen") {
            AutenticacaoCadastralSucessoScreen(navController = navController)
        }
        composable("autenticacao_cadastral_falha_screen") {
            AutenticacaoCadastralFalhaScreen(navController = navController)
        }
        composable("sim_swap_screen") {
            SimSwapScreen(navController = navController)
        }
        composable("sim_swap_com_troca_screen") {
            SimSwapComTrocaScreen(navController = navController)
        }
        composable("sim_swap_sem_troca_screen") {
            SimSwapSemTrocaScreen(navController = navController)
        }
        composable("analise_documento_screen") {
            AnaliseDocumentoScreen(navController = navController)
        }
        composable("analise_documento_sucesso_screen") {
            AnaliseDocumentoSucessoScreen(navController = navController)
        }
        composable("analise_documento_falha_screen") {
            AnaliseDocumentoFalhaScreen(navController = navController)
        }
        composable("score_anti_fraude_screen") {
            ScoreAntiFraudeScreen(navController = navController)
        }
        composable("biometria_facial_screen") {
            BiometriaFacialScreen(navController = navController)
        }
        composable("biometria_facial_sucesso_screen") {
            BiometriaFacialSucessoScreen(navController = navController)
        }
        composable("biometria_facial_falha_screen") {
            BiometriaFacialFalhaScreen(navController = navController)
        }
        composable("biometria_digital_screen") {
            BiometriaDigitalScreen(navController = navController)
        }
        composable("biometria_digital_sucesso_screen") {
            BiometriaDigitalSucessoScreen(navController = navController)
        }
        composable("biometria_digital_falha_screen") {
            BiometriaDigitalFalhaScreen(navController = navController)
        }
    }
}
