package com.example.myfigmaapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myfigmaapplication.ui.theme.Black
import com.example.myfigmaapplication.ui.theme.BlueGray

@Composable
fun LoginScreen() {
    Surface {
        Column(Modifier.fillMaxSize()) {

            TopSection()

            Spacer(modifier = Modifier.padding(top = 36.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {

                val uiColor = if (isSystemInDarkTheme()) Color.White else Black

                LoginSection()

                Spacer(modifier = Modifier.height(30.dp))

                SocialMediaSection()

                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color(0xFF94A3B8),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            )
                        ) {
                            append("Don't have account?")
                        }
                        withStyle(
                            style = SpanStyle(
                                color = uiColor,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold))
                            )
                        ) {
                            append(" ")
                            append("Create now")
                        }
                    })
                }
            }
        }
    }
}

@Composable
private fun SocialMediaSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Or continue with",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF64748B),
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogin(
                icon = R.drawable.google_logo,
                text = "Google",
                modifier = Modifier.weight(1f)
            ) {}

            Spacer(modifier = Modifier.width(20.dp))

            SocialMediaLogin(
                icon = R.drawable.facebook_logo, text = "Facebook",
                modifier = Modifier.weight(1f)
            ) {}
        }

    }
}

@Composable
private fun LoginSection() {
    LoginTextField(label = "Email", trailing = "", modifier = Modifier.fillMaxWidth())

    Spacer(modifier = Modifier.height(15.dp))

    LoginTextField(label = "Password", trailing = "Forgot?", modifier = Modifier.fillMaxWidth())

    Spacer(modifier = Modifier.height(15.dp))

    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
        onClick = { /*TODO*/ },
    ) {
        Text(
            text = "Log In",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
            )
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    val painterColor =
        if (isSystemInDarkTheme()) painterResource(id = R.drawable.subtract_dark) else painterResource(
            id = R.drawable.subtract_light
        )

    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.46f),
            painter = painterColor,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )

        Row(
            modifier = Modifier.padding(top = 82.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.the_tolet),
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.rubik_bold)),
                        fontWeight = FontWeight(700),
                        color = uiColor
                    )
                )
                Text(
                    text = "Find Your House",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.inter_medium)),
                        fontWeight = FontWeight(500),
                        color = uiColor,
                    )
                )
            }
        }
        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = "Login",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontWeight = FontWeight(800),
                color = uiColor,
                letterSpacing = 1.28.sp,
            )
        )
    }
}