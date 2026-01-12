package com.example.proyectonavidadvideojuegos.ui.videojuegos

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.proyectonavidadvideojuegos.R
import com.example.proyectonavidadvideojuegos.model.construirUrlImagen
import com.example.proyectonavidadvideojuegos.ui.Pantalla
import com.example.proyectonavidadvideojuegos.viewmodel.videojuegos.ViewModelListaVideojuegos

@Composable
fun Favoritos(navController: NavController, viewModelListaVideojuegos: ViewModelListaVideojuegos) {

    Column(
        modifier = Modifier
            .padding(top = 70.dp)
            .padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Mis favoritos",
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )

        if (viewModelListaVideojuegos.listaFavoritos.isEmpty()) {
            Text(
                text = "No tienes favoritos aún",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 24.dp)
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 250.dp),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 30.dp)
            ) {
                items(viewModelListaVideojuegos.listaFavoritos.size) { i ->
                    var juegoActual = viewModelListaVideojuegos.listaFavoritos.get(i);

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                            .clickable {
                                navController.navigate(Pantalla.PantallaDetallesVideojuego.ruta + "/${juegoActual.id}")
                            }
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(14.dp)
                        ) {
                            Text(
                                text = "${juegoActual.name} ❤️",
                                fontSize = 24.sp,
                                lineHeight = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                            AsyncImage(
                                model = construirUrlImagen(juegoActual.cover?.image_id),

                                contentDescription = "Portada de ${juegoActual.name}",

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(vertical = 12.dp)
                                    .clip(RoundedCornerShape(12.dp)),

                                contentScale = ContentScale.Crop,

                                placeholder = painterResource(R.drawable.ic_launcher_background),
                                error = painterResource(R.drawable.ic_launcher_background)
                            )
                            Text(
                                text = "Valoración: ${juegoActual.total_rating?.toInt() ?: "N/A"}/100",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .padding(bottom = 12.dp)
                            )
                            Button(
                                onClick = { viewModelListaVideojuegos.alternarFavorito(juegoActual) }
                            ) {
                                Text(
                                    text = "❤️ Quitar"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}