package com.example.proyectonavidadvideojuegos.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun MenuInicio(navController : NavController) {


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    ) {
        Text(
            text = "Videojuegos!",
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.padding(30.dp)
        )

        Button(
            onClick = {
                navController.navigate(Pantalla.PantallaListaVideojuegos.ruta)
            }
        ) {
            Text(
                text = "Ver Top videojuegos",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
        Button(
            onClick = {
                navController.navigate(Pantalla.PantallaFavoritos.ruta)
            },
            modifier = Modifier
                .padding(top = 30.dp)
        ) {
            Text(
                text = "Ver Favoritos",
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }


}