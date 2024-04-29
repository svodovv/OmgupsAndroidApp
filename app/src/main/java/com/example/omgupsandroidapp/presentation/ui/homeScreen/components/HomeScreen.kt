package com.omgupsapp.presentation.ui.homeScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.captionBarPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R


@Composable
fun HomeScreen(
    navController: NavController,
    paddingValues: PaddingValues
) {

    Column(
        modifier = Modifier
            .padding(10.dp,80.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        HomePage(navController = navController)
    }
}


@Composable
fun HomePage(navController: NavController) {
   /* Box(
        modifier = Modifier.
        clip(shape = RoundedCornerShape(4.dp)).
        background(color = Color.Blue),
        //contentAlignment = Arrangement.Top,
        //horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Home screen")
    }*/
    Box(modifier = Modifier
        .clip(shape = RoundedCornerShape(10.dp))
        .background(color = Color(0xFFBAEAFF))
        .size(width = 400.dp, height = 300.dp),
        //.padding(20.dp,0.dp),
        contentAlignment = Alignment.TopStart

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
               modifier = Modifier
                   .fillMaxSize()
                   .padding(30.dp)
            ) {
                Box() {
                    Image(
                        painterResource(
                            id = R.drawable.spravki
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp, 60.dp),
                        alignment = Alignment.TopStart
                    )
                    Text(
                        color = Color.Black,
                        modifier = Modifier
                            .padding(0.dp,60.dp),
                        text = "Заказ справок"
                    )
                }
            }
        }
    }
}
