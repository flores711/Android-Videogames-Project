package com.example.proyectonavidadvideojuegos.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object IGDBClient {

    private const val CLIENT_ID = "tpwqv75fclhovaibsdvc0c4y5mbza3"
    private const val CLIENT_SECRET = "t3xyh6va25hvlfh3l95io12yaoybzk"

    var accessToken: String? = null

    private val twitchRetrofit = Retrofit.Builder()
        .baseUrl("https://id.twitch.tv/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val twitchAuthService = twitchRetrofit.create(TwitchAuthService::class.java)

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
                .addHeader("Client-ID", CLIENT_ID)

            accessToken?.let {
                requestBuilder.addHeader("Authorization", "Bearer $it")
            }

            chain.proceed(requestBuilder.build())
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.igdb.com/v4/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: IGDBService = retrofit.create(IGDBService::class.java)


    suspend fun getIGDBToken(): String {
        val response = twitchAuthService.getAccessToken(CLIENT_ID, CLIENT_SECRET)
        accessToken = response.access_token
        return response.access_token
    }

}