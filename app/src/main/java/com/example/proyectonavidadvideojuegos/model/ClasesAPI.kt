package com.example.proyectonavidadvideojuegos.model



data class Videojuego (
    val id: Int,
    val name: String,
    val cover: Cover?,
    val total_rating: Double?,
    val total_rating_count: Int?,
    val first_release_date: Long?,
    val summary: String?
)


// Porque aunque pidamos solo el image_id, nos lo da dentro de un objeto Cover en JSON solo con image_id dentro
data class Cover (
    val image_id: String
)


data class TokenDevuelto (
    val access_token: String,
    val expires_in: Long,
    val token_type: String
)