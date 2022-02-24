package com.arvind.foodizone.view


import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Minimize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.arvind.foodizone.component.TopAppBarMyOrders
import com.arvind.foodizone.data.MyOrdersDataDummy
import com.arvind.foodizone.model.MyOrders
import com.arvind.foodizone.ui.theme.*

@Composable
fun OrderScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBarMyOrders()
    },
        backgroundColor = if (isSystemInDarkTheme()) Color.Black else colorWhite,
        content = {
            OrderMainContent()
        })

}

@Composable
fun OrderMainContent() {
    Column {
        OrderList()
        OrderCalculateData()
    }
}

@Composable
fun OrderCalculateData() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(
                start = 20.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = 20.dp
            ),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorRedLite),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Apply Coupon \uD83E\uDD11",
                    color = colorWhite,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Item total",
                    color = Color.Gray,
                    style = MaterialTheme.typography.button
                )
                Text(
                    text = "$14.95",
                    color = colorBlack,
                    style = MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Delivery fees",
                    color = Color.Gray,
                    style = MaterialTheme.typography.button
                )
                Text(
                    text = "$2.25",
                    color = colorBlack,
                    style = MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Tax",
                    color = Color.Gray,
                    style = MaterialTheme.typography.button
                )
                Text(
                    text = "$2.95",
                    color = colorBlack,
                    style = MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total:",
                    color = Color.Gray,
                    style = MaterialTheme.typography.button
                )
                Text(
                    text = "$20.15",
                    color = colorRedDark,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )

            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorBlack),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Confirm order \uD83D\uDE0B",
                    color = colorWhite,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
        }

    }
}

@Composable
fun OrderList() {
    val myOrdersTitle = remember { MyOrdersDataDummy.myOrdersList }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        items(
            items = myOrdersTitle,
            itemContent = {
                MyOrdersListItem(myOrders = it)
            })
    }

}

@Composable
fun MyOrdersListItem(myOrders: MyOrders) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = myOrders.ordersImageId),
            contentDescription = "",
            modifier = Modifier
                .width(82.dp)
                .height(82.dp)

        )
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .weight(0.9f)
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = myOrders.name,
                style = MaterialTheme.typography.h6,
                color = colorBlack,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${myOrders.price}",
                style = MaterialTheme.typography.h6,
                color = colorRedDark,
                fontWeight = FontWeight.Bold
            )

        }
        val counter = remember { mutableStateOf(1) }
        Box(
            modifier = Modifier
                .width(110.dp)
                .height(40.dp)
                .clip(shape = CircleShape)
                .background(colorRedLite)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(colorWhite)
                        .size(32.dp, 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = { counter.value-- }) {
                        Icon(
                            imageVector = Icons.Default.Minimize,
                            contentDescription = "",
                            tint = colorRedDark,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }

                Text(
                    text = "${counter.value}",
                    color = colorBlack,
                    style = MaterialTheme.typography.button,
                    fontWeight = FontWeight.Bold
                )

                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(Color.Red)
                        .size(32.dp, 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = {
                        counter.value++
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = colorWhite,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    }
                }
            }
        }

    }

    HorizontalDivider()
}

@Composable
fun HorizontalDivider() {
    Divider(
        color = colorRedLite, thickness = 1.dp,
        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
    )

}

@Composable
@Preview
fun OrderScreenPreview() {
    OrderScreen(navController = NavHostController(LocalContext.current))
}


@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun OrderScreenDarkPreview() {
    OrderScreen(navController = NavHostController(LocalContext.current))
}