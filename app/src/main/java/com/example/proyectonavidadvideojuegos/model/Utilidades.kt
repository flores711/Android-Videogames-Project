package com.example.proyectonavidadvideojuegos.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun construirUrlImagen(imageId: String?): String {
    if (imageId.isNullOrEmpty()) {
        return ""
    } else {
        return "https://images.igdb.com/igdb/image/upload/t_cover_big/$imageId.jpg"
    }
}


fun formatearFecha(fechaLong: Long?): String?{
    if (fechaLong == null)
        return "Fecha desconocida"

    // Convertir segundos a milisegundos
    val fecha = Date(fechaLong * 1000)

    // Definir el formato
    val formato = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    return formato.format(fecha)
}