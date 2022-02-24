package com.arvind.foodizone.view

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arvind.foodizone.R
import com.arvind.foodizone.navigation.Screen
import com.arvind.foodizone.ui.theme.*

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else colorPrimary)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.welcome),
                    contentDescription = "Welcome Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.Crop
                )
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
                    .padding(10.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.foodizone_logo),
                        contentDescription = "logo",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(
                        text = "Feeling Hungry ?",
                        color = colorBlack,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "Let’s order right now",
                        color = colorBlack,
                        style = MaterialTheme.typography.h6,
                    )
                    Text(
                        text = "\n" +
                                "The fastest delivery service in the\n" +
                                "town, start ordering now\n",
                        color = Color.Gray,
                        style = MaterialTheme.typography.button,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(Screen.LoginScreen.route)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorRedDark),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(start = 40.dp, end = 40.dp)
                            .align(Alignment.CenterHorizontally),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(
                            text = "Let’s order \uD83D\uDE0B",
                            color = colorWhite,
                            style = MaterialTheme.typography.button,
                            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                        )
                    }

                }


            }

        }

    }

}

@Composable
@Preview
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = NavController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun WelcomeScreenDarkPreview() {
    WelcomeScreen(navController = NavController(LocalContext.current))

}