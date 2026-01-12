package com.example.proyectonavidadvideojuegos.ui

sealed class Pantalla(val ruta : String) {
    object PantallaMenuInicio : Pantalla("menu_inicio")
    object PantallaListaVideojuegos : Pantalla("lista_videojuegos")
    object PantallaDetallesVideojuego : Pantalla("detalles_videojuego")
    object PantallaFavoritos : Pantalla("favoritos")
}