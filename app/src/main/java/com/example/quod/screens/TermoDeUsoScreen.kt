package com.example.quod.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.ui.theme.Recursive
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext

@Composable
fun TermoDeUsoScreen(navController: NavController) {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append("Para saber como a Quod trata os dados pessoais, acesse a ")
        pushStringAnnotation(
            tag = "URL",
            annotation = "https://www.quod.com.br/politica-de-privacidade"
        )
        withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
            append("Política de Privacidade.")
        }
        pop()
    }

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = colorResource(id = R.color.black),
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
                            modifier = Modifier.size(24.dp),
                            tint = colorResource(id = R.color.button)
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
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
                    selected = true,
                    onClick = { navController.navigate("termo_de_uso_screen") },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_terms),
                            contentDescription = "Terms",
                            modifier = Modifier.size(24.dp),
                            tint = colorResource(id = R.color.button)
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
                            modifier = Modifier.size(24.dp),
                            tint = colorResource(id = R.color.button)
                        )
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white))
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "TERMO DE USO DO PORTAL DE SERVIÇOS QUOD",
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = Recursive
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            SelectionContainer {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Objetivo:")
                            }
                            append("\n\nRegular o acesso e a utilização das Plataformas disponibilizadas pela GESTORA DE INTELIGÊNCIA DE CRÉDITO S.A.")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(" (“Quod”)")
                            }
                            append(" aos seus clientes, aos consumidores e ao público em geral (“")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Usuário(s)")
                            }
                            append("”).\n\nAlguns serviços fornecidos pela ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Quod")
                            }
                            append(" têm suas regras, condições e valores específicos, que são fixados por meio de contrato e/ou demais ordens de serviço vinculadas, disponibilizadas no momento da contratação.\n\n")
                        },
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        )
                    )

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("1      Quem é a Quod?")
                            }
                            append("\n\nA ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Quod")
                            }
                            append(" é uma datatech que oferece soluções que transformam dados em inteligência para qualificar tomadas de decisão e alavancar negócios. Possui em seu quadro de acionistas, nomes de peso do mercado financeiro, trazendo solidez e segurança. Através de um portfólio de crédito, antifraude e cobrança utilizam sua expertise multimercado para gerar vantagens competitivas aos seus clientes.\n\n")
                        },
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        )
                    )

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Razão Social:")
                            }
                            append(" GESTORA DE INTELIGÊNCIA DE CRÉDITO S.A.\n")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("CNPJ:")
                            }
                            append(" 28.042.871/0001-97\n")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Endereço:")
                            }
                            append(" (coloque o endereço aqui)")
                        },
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white))
                            .border(1.dp, colorResource(id = R.color.black))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("A Quod quer facilitar seu entendimento sobre o Termo. Desse modo, ao início de cada item deste documento há um quadro resumo, no mesmo formato deste, contendo uma breve descrição dos principais pontos abordados no texto.")
                                }
                            },
                            style = TextStyle(
                                color = colorResource(id = R.color.text),
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontFamily = Recursive,
                                textAlign = TextAlign.Start
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("2      Plataforma Quod")
                            }
                        },
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white))
                            .border(1.dp, colorResource(id = R.color.black))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("A Quod disponibiliza três plataformas para uso por clientes e consumidores.")
                                }
                            },
                            style = TextStyle(
                                color = colorResource(id = R.color.text),
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontFamily = Recursive,
                                textAlign = TextAlign.Start
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Os Usuários podem acessar três plataformas com naturezas e objetos distintos:",
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    //Tabela

                    Column(
                        modifier = Modifier
                            .fillMaxWidth() // Preenche a largura toda
                            .border(1.dp, colorResource(id = R.color.black)) // Borda ao redor de toda a tabela
                    ) {
                        // Linha 1: Cabeçalhos em negrito
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp), // Adiciona espaçamento interno
                            horizontalArrangement = Arrangement.Start // Alinha os itens à esquerda
                        ) {
                            Text(
                                text = "Plataforma",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "Objeto",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "Público Alvo",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                        }

                        // Divider após o cabeçalho
                        Divider(color = colorResource(id = R.color.black), thickness = 1.dp)

                        // Linha 2
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp), // Adiciona espaçamento interno
                            horizontalArrangement = Arrangement.Start // Alinha os itens à esquerda
                        ) {
                            Text(
                                text = "Plataforma de Consulta ao Cadastro Positivo",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "É oferecida pela QUOD para que o consumidor consulte alguma dívida reportada por credores no cadastro de inadimplentes.",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Justify // Justifica o texto
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "Titulares de dados",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                        }

                        // Divider após a linha 2
                        Divider(color = colorResource(id = R.color.black), thickness = 1.dp)

                        // Linha 3
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp), // Adiciona espaçamento interno
                            horizontalArrangement = Arrangement.Start // Alinha os itens à esquerda
                        ) {
                            Text(
                                text = "Plataforma de Consulta de Pendências Financeiras",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "É oferecida pela QUOD para que o consumidor consulte alguma dívida reportada por credores no cadastro de inadimplentes.",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Justify // Justifica o texto
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "Titulares de dados",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start
                            )
                        }

                        Divider(color = colorResource(id = R.color.black), thickness = 1.dp)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Text(
                                text = "Portal do Cliente",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "Portal por meio do qual os clientes da Quod podem consumir determinadas soluções, de acordo com o contrato que firmaram com a Quod.",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Justify // Justifica o texto
                            )
                            Spacer(modifier = Modifier.width(8.dp)) // Espaçamento entre as colunas
                            Text(
                                text = "Usuários de clientes que contratem soluções de dados ofertados pela Quod",
                                style = TextStyle(
                                    color = colorResource(id = R.color.text),
                                    fontSize = 16.sp,
                                    fontFamily = Recursive
                                ),
                                modifier = Modifier.weight(1f),
                                textAlign = TextAlign.Start // Alinha o texto à esquerda
                            )
                        }

                        // Divider após a linha 4
                        Divider(color = colorResource(id = R.color.black), thickness = 1.dp)
                    }

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Atenção!")
                            }
                            append(" As Plataformas de Consulta ao Cadastro Positivo e Consulta de Pendências Financeiras são oferecidas pela Quod exclusivamente para que o Usuário consulte dados com relação a si mesmo, sendo vedada a consulta de dados de terceiros.")
                        },
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("3      Cadastro Positivo e Consulta de Pendências Financeiras")
                            } },
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.white))
                            .border(1.dp, colorResource(id = R.color.black))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("A Quod disponibiliza, dentre seus serviços, a Consulta ao Cadastro Positivo e a Consulta às Pendências Financeiras.\n" +
                                            "Para saber mais sobre como a Quod trata seus dados pessoais com relação a estes e outros serviços, acesse a Política de Privacidade da Quod.")
                                }
                            },
                            style = TextStyle(
                                color = colorResource(id = R.color.text),
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontFamily = Recursive,
                                textAlign = TextAlign.Start
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Dentre as soluções disponibilizadas pela Quod aos Usuários das Plataformas estão a Consulta ao Cadastro Positivo e a Consulta de Pendências Financeiras.\n" +
                                "O Cadastro Positivo permite a avaliação de crédito com base nas contas pagas pelo Usuário, e não somente com base em dívidas em atraso. Esta atividade é regulada pela Lei nº. 12.414/2011 (Lei do Cadastro Positivo), que autoriza a abertura de cadastro de consumidores ou pessoas jurídicas em banco de dados de adimplemento, sem a necessidade de obtenção de prévia autorização. Para saber mais sobre esse serviço, clique aqui.\n" +
                                "O serviço de Consulta de Pendências Financeiras, por sua vez, permite o acesso, pelos Usuários, de dívidas em aberto informada por credores, seguindo as regras estabelecidas pelo artigo 43 da Lei n°. 8.078/1998 (Código de Defesa do Consumidor).\n" +
                                "Para saber mais como seus dados são tratados pela Quod com relação aos serviços disponibilizados nas Plataformas, verifique a Política de Privacidade da Quod, conforme Item 6 abaixo.",
                        style = TextStyle(
                            color = colorResource(id = R.color.text),
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = Recursive
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("4      Acesso às Plataformas")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
                    .border(1.dp, colorResource(id = R.color.black))
                    .padding(16.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("O acesso às Plataformas da Quod é restrito a Usuários dos serviços disponibilizados, por login e senha. O Usuário é responsável pelas credenciais de acesso e dados informados no cadastro, não devendo compartilhá-los com terceiros.")
                        }
                    },
                    style = TextStyle(
                        color = colorResource(id = R.color.text),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "As Plataformas da Quod estão disponíveis para acesso pelos diversos Usuários por meio do domínio www.quod.com.br.. O acesso geral ao domínio é público e realizado de forma gratuita, porém o acesso ao Portal do Cliente, Plataforma de Consulta ao Cadastro Positivo e Plataforma de Consulta de Pendências Financeiras, é restrito por login e senha.\n" +
                        "\n" +
                        "Para o Portal do Cliente serão cobrados valores em decorrência da contratação de serviços, conforme solicitação do Usuário e aceite ao contrato pertinente, disponibilizado no momento da contratação. Assim, os serviços e produtos disponibilizados no Portal do Cliente poderão conter restrições para Usuários, em decorrência das funções efetivamente contratadas.",
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Atenção!")
                    }
                    append(" O Usuário com acesso às áreas logadas das Plataformas é responsável por qualquer ação que seja realizada por meio de suas credenciais de acesso, que são intransferíveis e de uso exclusivo. É também de sua responsabilidade a veracidade dos dados informados no cadastro.")
                },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("5      Condições de utilização das Plataformas")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
                    .border(1.dp, colorResource(id = R.color.black))
                    .padding(16.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("A utilização das Plataformas pelos Usuários está sujeita a determinadas condições, incluindo a proibição quanto ao uso para qualquer finalidade ilícita ou a inserção de conteúdo inadequado." +
                                    "O Usuário é responsável por qualquer informação por ele inserida nas Plataformas, bem como pelos resultados obtidos a partir de dados inverídicos ou desatualizados por ele disponibilizados e pelo uso que fizer das informações acessadas por meio das Plataformas." +
                                    "Por fim, todo o conteúdo disponibilizado nas Plataformas é protegido por direitos de propriedade intelectual, sendo proibido o uso para qualquer finalidade diversa daquela para qual o conteúdo foi originalmente disponibilizado.")
                        }
                    },
                    style = TextStyle(
                        color = colorResource(id = R.color.text),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("5.1      Regras de Utilização")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Text(
                text = buildAnnotatedString {
                    append("É vedado ao Usuário, na utilização das Plataformas:\n" +
                            "    (i)   Utilizar as Plataformas para quaisquer finalidades fraudulentas ou ilícitas;\n" +
                            "   (ii)   Inserir nas Plataformas qualquer informação inverídica ou dados referentes a terceiros, com relação aos quais o Usuário não possua os direitos ou autorizações necessárias para o tratamento;\n" +
                            "  (iii)   Submeter às Plataformas qualquer tipo de conteúdo ilegal, imoral ou incompatível com sua natureza, como material racista ou preconceituoso, pornográfico, ofensivo, além de qualquer código ou software que permita a utilização das Plataformas para quaisquer finalidades diversas daquela para as quais foram disponibilizadas;\n" +
                            "   (iv)   Inserir qualquer conteúdo nas Plataformas que viole direitos de propriedade intelectual de terceiros.\n" +
                            "\n" +
                            "A Quod não monitora a utilização das Plataformas pelos Usuários e caso tome ciência de qualquer uso indevido, a Quod poderá suspender ou encerrar o acesso às Plataformas do Usuário responsável, conforme descrito no Item 7 abaixo, bem como adotar quaisquer outras medidas legais adequadas.")
                },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("5.2     Responsabilidades do Usuário")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Text(
                text = buildAnnotatedString {
                    append("O Usuário é responsável por quaisquer dados ou informações por ele inseridos nas Plataformas, inclusive com relação a sua atualidade e veracidade. A Quod não poderá ser responsabilizada por qualquer falha nos serviços decorrentes de informações inverídicas, desatualizadas ou incompletas disponibilizadas pelos Usuários.\n" +
                            "Cabe ao Usuário adotar as medidas de segurança razoáveis nos dispositivos que utiliza para acessar as Plataformas, bem como para a conexão de internet utilizada no acesso.\n" +
                            "É de total responsabilidade do Usuário a forma de utilização das informações a que teve acesso em decorrência do acesso às Plataformas, assegurando sempre que serão utilizadas de forma devida e com respaldo legal. Em caso de desrespeito ao previsto neste item, o Usuário responderá individualmente pelo uso indevido e violações de quaisquer direitos da Quod ou de terceiros.")
                },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("5.3     Propriedade Intelectual")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Text(
                text = buildAnnotatedString {
                    append("Todos os serviços, dados, marcas, softwares, códigos, imagens, fotografias, textos, relatórios, layouts, designs e demais materiais disponibilizados nas Plataformas são protegidos por direitos de propriedade intelectual da Quod ou de terceiros que autorizaram sua utilização pela Quod, nos termos das leis aplicáveis. É vedada a cópia, modificação ou reprodução, parcial ou integral, das informações, dados ou qualquer outro conteúdo disponibilizado nas Plataformas da Quod.")
                },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("6     Responsabilidades da Quod")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
                    .border(1.dp, colorResource(id = R.color.black))
                    .padding(16.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("A Quod não garante a funcionalidade contínua das Plataformas, sem quaisquer interrupções ou dificuldades de acesso.\n" +
                                    "As Plataformas podem conter links e acessos seguros que direcionam para páginas de terceiros, cujas regras de utilização não estão sujeitas a este Termo.")
                        }
                    },
                    style = TextStyle(
                        color = colorResource(id = R.color.text),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Em decorrência das próprias limitações da tecnologia, a Quod não pode garantir a disponibilidade integral ou a ausência de quaisquer falhas nas Plataformas. Em caso de falhas de funcionamento, a Quod empenhará os melhores esforços para retomar a disponibilidade das Plataformas o mais rapidamente possível.\n" +
                        "\n" +
                        "A Quod adota as melhores práticas tecnológicas e organizacionais para garantir a segurança das Plataformas e dos serviços por meio destas prestados. No entanto, nenhuma plataforma tecnológica está completamente livre de potenciais incidentes de segurança da informação ou de ataques mal-intencionados. A Quod possui ferramentas técnicas de proteção (como firewalls e antivírus) e plano de resposta a incidentes para lidar de forma eficiente com eventuais situações adversas, sempre buscando preservar a segurança de seus Usuários.\n" +
                        "\n" +
                        "É possível que as Plataformas contenham links e acessos seguros que redirecionem o Usuário a sites externos, sendo que o presente Termo faz referência apenas à utilização das Plataformas disponibilizadas pela Quod. Dessa forma, é de responsabilidade do Usuário consultar as políticas e termos de uso de outros sites.",
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("7     Privacidade e Proteção de Dados")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
                    .border(1.dp, colorResource(id = R.color.black))
                    .padding(16.dp)
            ) {
                ClickableText(
                    text = annotatedText,
                    style = TextStyle(
                        color = colorResource(id = R.color.text),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    ),
                    onClick = { offset ->
                        annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                            .firstOrNull()?.let { annotation ->
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                                context.startActivity(intent)
                            }
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "A Quod adota práticas adequadas de proteção de dados pessoais, de acordo com a legislação aplicável, com destaque para as Leis nº. 8.078/1990 (o Código de Defesa do Consumidor), nº. 12.965/2014 (o Marco Civil da Internet), nº. 13.709/2018 (a Lei Geral de Proteção de Dados Pessoais – LGPD) e a Lei nº. 12.414/2011 (a Lei do Cadastro Positivo).\n" +
                        "\n" +
                        "Visando garantir transparência aos Usuários acerca de como a Quod trata dados pessoais, inclusive por meio das Plataformas, a Política de Privacidade completa está disponível aqui.",
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("8     Encerramento do acesso à plataforma")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
                    .border(1.dp, colorResource(id = R.color.black))
                    .padding(16.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("O acesso às Plataformas poderá ser encerrado por solicitação do Usuário, pelo término da disponibilização do serviço pela Quod ou em caso de violação, por parte do Usuário, de disposições legais ou do presente Termo. A Quod ainda poderá armazenar dados acerca do Usuário após o encerramento do acesso, conforme descrito na Política de Privacidade.\n")
                        }
                    },
                    style = TextStyle(
                        color = colorResource(id = R.color.text),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Exceto se de forma diversa estabelecida por meio do contrato referente ao serviço utilizado pelo Usuário, a disponibilização dos acessos às Plataformas se dá por prazo indeterminado, podendo a Quod encerrar a disponibilização dos acessos às Plataformas ou de qualquer de suas funcionalidades a qualquer momento, sem necessidade de prévia comunicação ao Usuário.\n" +
                        "\n" +
                        "O Usuário poderá cancelar seu cadastro para acesso às Plataformas a qualquer momento, seguindo as instruções indicadas na área logada ou por meio de contato com a Quod, conforme indicado no Item 8 abaixo. Neste caso, a Quod ainda poderá armazenar dados a respeito do Usuário, conforme detalhado na Política de Privacidade.\n" +
                        "\n" +
                        "A Quod poderá suspender ou encerrar o acesso do Usuário às Plataformas caso identifique qualquer uso indevido ou ilícito por parte do Usuário, ou em violação ao presente Termo e demais políticas disponíveis no Portal.",
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("9     Contato")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.white))
                    .border(1.dp, colorResource(id = R.color.black))
                    .padding(16.dp)
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Quer falar com a Quod? Disponibilizamos os canais de atendimentos indicados abaixo!")
                        }
                    },
                    style = TextStyle(
                        color = colorResource(id = R.color.text),
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = Recursive,
                        textAlign = TextAlign.Start
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "O Usuário poderá entrar em contato com a Quod por meio do e-mail atendimento@quod.com.br, pelos telefones 3003-7863 (capitais e regiões metropolitanas) ou 0800 400 7863 (demais localidades), das 8h às 20h, em dias úteis; ou pelo chat \"Fale com a SophIA\", disponível no site da Quod (www.quod.com.br) .\n" +
                        "\n" +
                        "A Quod sempre entrará em contato com o Usuário pelos meios de comunicação oficiais. Em caso de desconfiança sobre um e-mail, ligação ou mensagem, o Usuário deverá entrar em contato com a Quod através dos canais de atendimento aqui indicados.\n" +
                        "\n" +
                        "Os dados de e-mail e telefone fornecidos pelo Usuário poderão ser utilizados para comunicação da Quod sobre novidades e parcerias, abertura de cadastro ou inclusão de informações de inadimplência, educação financeira, ofertas exclusivas, novidades do Blog, pesquisas e convites para eventos. Caso o Usuário não queira mais receber os comunicados da Quod, poderá solicitar o cancelamento de tais envios por meio das Plataformas ou canais disponibilizados pela Quod. Em algumas situações, no entanto, o contato não poderá ser interrompido, quando, por exemplo, a comunicação ao Usuário corresponder a uma obrigação legal da Quod.\n" +
                        "\n" +
                        "Os dados de contato poderão ser compartilhados com terceiros para suporte à Quod em atividades operacionais na realização de eventos e/ou webinars e para comunicações sobre os produtos e a prestação de serviço da Quod. Os dados compartilhados terão seus processos de expurgo realizados assim que a finalidade tiver sido atingida, conforme determina a LGPD. Para mais informações, acesse a Política de Privacidade.",
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("10     Disposições Gerais")
                    } },
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Se qualquer parte deste Termo for considerada inválida ou inexequível, todas as demais disposições permanecerão válidas e vigentes. A falha da Quod em exigir quaisquer direitos ou disposições do presente Termo não constituirá renúncia, podendo a parte exercer regularmente o seu direito, dentro dos prazos legais.\n" +
                        "\n" +
                        "Este Termo é regido e interpretado de acordo com as leis da República Federativa do Brasil, ficando eleito, nos limites do quanto autorizado pela legislação aplicável, o Foro de São Paulo/SP para dirimir quaisquer conflitos decorrentes deste instrumento.",
                style = TextStyle(
                    color = colorResource(id = R.color.text),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = Recursive
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}
