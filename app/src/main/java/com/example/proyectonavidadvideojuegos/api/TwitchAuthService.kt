package com.example.proyectonavidadvideojuegos.api

import retrofit2.http.POST
import retrofit2.http.Query
import com.example.proyectonavidadvideojuegos.model.TokenDevuelto

interface TwitchAuthService {
    @POST("oauth2/token")
    suspend fun getAccessToken(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("grant_type") grantType: String = "client_credentials"
    ): TokenDevuelto
}