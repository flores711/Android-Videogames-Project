package com.example.proyectonavidadvideojuegos

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.proyectonavidadvideojuegos.ui.videojuegos.DetallesVideojuego
import com.example.proyectonavidadvideojuegos.ui.videojuegos.ListaVideojuegos
import com.example.proyectonavidadvideojuegos.ui.MenuInicio
import com.example.proyectonavidadvideojuegos.ui.Pantalla
import com.example.proyectonavidadvideojuegos.ui.videojuegos.Favoritos
import com.example.proyectonavidadvideojuegos.viewmodel.videojuegos.ViewModelListaVideojuegos

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val viewModelListaVideojuegos: ViewModelListaVideojuegos = viewModel()

    NavHost(navController = navController, startDestination = Pantalla.PantallaMenuInicio.ruta) {

        composable(Pantalla.PantallaMenuInicio.ruta) {
            MenuInicio(navController)
        }

        composable(Pantalla.PantallaListaVideojuegos.ruta) {
            ListaVideojuegos(navController, viewModelListaVideojuegos)
        }

        composable(
            route = Pantalla.PantallaDetallesVideojuego.ruta + "/{juegoId}",
            arguments = listOf(
                navArgument("juegoId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val juegoId = backStackEntry.arguments?.getInt("juegoId") ?: 0
            DetallesVideojuego(navController, juegoId, viewModelListaVideojuegos)
        }

        composable(Pantalla.PantallaFavoritos.ruta) {
            Favoritos(navController, viewModelListaVideojuegos)
        }
    }
}