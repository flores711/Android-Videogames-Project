package com.example.proyectonavidadvideojuegos.ui.videojuegos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.proyectonavidadvideojuegos.model.formatearFecha
import com.example.proyectonavidadvideojuegos.viewmodel.videojuegos.ViewModelListaVideojuegos

@Composable
fun DetallesVideojuego(navController: NavController, juegoId: Int, viewModelListaVideojuegos: ViewModelListaVideojuegos) {

    var juego = viewModelListaVideojuegos.obtenerJuegoPorId(juegoId)
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 650.dp)
                .verticalScroll(scrollState)
                .padding(top = 70.dp)
                .padding(horizontal = 24.dp)
        ) {

            Text(
                text = juego?.name ?: "No se encontró el videojuego",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 40.sp
            )

            AsyncImage(
                model = construirUrlImagen(juego?.cover?.image_id),

                contentDescription = "Portada de ${juego?.name}",

                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(vertical = 16.dp)
                    .clip(RoundedCornerShape(12.dp)),

                contentScale = ContentScale.Crop,

                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background)
            )

            Text(
                text = "Valoración: ${juego?.total_rating?.toInt() ?: "N/A"}/100",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)
            )

            Text(
                text = "Fecha salida: ${formatearFecha(juego?.first_release_date)}",
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(vertical = 6.dp)
            )
            Text(
                text = "Descripción:\n${juego?.summary}",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 6.dp, bottom = 30.dp)
            )

        }
    }
}