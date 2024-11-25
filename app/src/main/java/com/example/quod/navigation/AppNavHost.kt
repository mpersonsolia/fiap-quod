package com.example.quod.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dashboard.AutenticacaoCadastralScreen
import com.example.dashboard.DashboardScreen
import com.example.quod.screens.AnaliseDocumentoFalhaScreen
import com.example.quod.screens.AnaliseDocumentoScreen
import com.example.quod.screens.AnaliseDocumentoSucessoScreen
import com.example.quod.screens.AutenticacaoCadastralFalhaScreen
import com.example.quod.screens.AutenticacaoCadastralSucessoScreen
import com.example.quod.screens.LoginScreen
import com.example.quod.screens.ScoreAntiFraudeScreen
import com.example.quod.screens.SimSwapComTrocaScreen
import com.example.quod.screens.SimSwapScreen
import com.example.quod.screens.SimSwapSemTrocaScreen

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
        composable("dashboard_screen") {
            DashboardScreen(navController = navController)
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
//        composable("sim_swap_com_troca_screen") {
//            SimSwapComTrocaScreen(navController = navController)
//        }
//        composable("sim_swap_sem_troca_screen") {
//            SimSwapSemTrocaScreen(navController = navController)
//        }

//        composable("biometriaFacial") {
//            BiometriaFacialScreen()
//        }
//        composable("biometriaDigital") {
//            BiometriaDigitalScreen()
//        }
//        composable("analiseDocumento") {
//            AnaliseDocumentoScreen()
//        }
//        composable("simSwap") {
//            SimSwapScreen()
//        }
//        composable("scoreAntifraude") {
//            ScoreAntifraudeScreen()
    }
}
