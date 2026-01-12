package com.example.proyectonavidadvideojuegos.api

import com.example.proyectonavidadvideojuegos.model.Videojuego
import retrofit2.http.Body
import retrofit2.http.POST
import okhttp3.RequestBody

interface IGDBService {

    @POST("games")
    suspend fun getVideojuegos(@Body query: RequestBody): List<Videojuego>

}