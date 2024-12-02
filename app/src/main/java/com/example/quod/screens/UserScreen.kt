import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.ui.theme.Recursive
import android.content.Intent
import android.net.Uri

@Composable
fun UserScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = colorResource(id = R.color.white),
                modifier = Modifier
                    .height(56.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            ) {
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("dashboard_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_home),
                            contentDescription = "Home",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { navController.navigate("user_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_user),
                            contentDescription = "User",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("termo_de_uso_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_terms),
                            contentDescription = "Terms",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("login_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_logout),
                            contentDescription = "LogOut",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = colorResource(id = R.color.background))
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_quod_white),
                contentDescription = "Logo Quod",
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.TopCenter)
                    .padding(top = 10.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(horizontal = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(color = colorResource(id = R.color.white))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Cláudia de Oliveira",
                            style = TextStyle(
                                color = colorResource(id = R.color.text),
                                fontSize = 27.sp
                            )
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Vendedora Sênior",
                            style = TextStyle(
                                color = colorResource(id = R.color.text_gray),
                                fontSize = 18.sp,
                                fontFamily = Recursive,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Matrícula 0000-00",
                            style = TextStyle(
                                color = colorResource(id = R.color.text_gray),
                                fontSize = 18.sp,
                                fontFamily = Recursive,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Primeiro acesso: 18/03/2023 às 18:01:23",
                            style = TextStyle(
                                color = colorResource(id = R.color.text_gray),
                                fontSize = 16.sp,
                                fontFamily = Recursive,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "Último acesso: 22/12/2024 às 10:38:55",
                            style = TextStyle(
                                color = colorResource(id = R.color.text_gray),
                                fontSize = 16.sp,
                                fontFamily = Recursive,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable {
                                    val url = "https://api.whatsapp.com/send?1=pt_BR&phone=5511993197863"
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    navController.context.startActivity(intent)
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_suporte),
                                    contentDescription = "Suporte",
                                    modifier = Modifier.size(23.dp),
                                    tint = colorResource(id = R.color.button)

                                )

                                Spacer(modifier = Modifier.width(12.dp))

                                Text(
                                    text = "Suporte",
                                    style = TextStyle(
                                        color = colorResource(id = R.color.button),
                                        fontSize = 19.sp,
                                        fontFamily = Recursive,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.clickable {
                                    navController.navigate("esqueci_minha_senha_screen")
                                }
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_senha),
                                    contentDescription = "Mudar Senha",
                                    modifier = Modifier.size(25.dp),
                                    tint = colorResource(id = R.color.button)

                                )

                                Spacer(modifier = Modifier.width(12.dp))

                                Text(
                                    text = "Mudar senha",
                                    style = TextStyle(
                                        color = colorResource(id = R.color.button),
                                        fontSize = 19.sp,
                                        fontFamily = Recursive,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }

                            Spacer(modifier = Modifier.height(24.dp))
                        }
                    }
                }
            }
        }
    }
}
