package com.example.proyectonavidadvideojuegos.viewmodel.videojuegos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectonavidadvideojuegos.api.IGDBClient
import com.example.proyectonavidadvideojuegos.model.Videojuego
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

class ViewModelListaVideojuegos: ViewModel() {
    var listaVideojuegos by mutableStateOf<List<Videojuego>>(emptyList())
        private set

    var listaFavoritos by mutableStateOf<List<Videojuego>>(emptyList())
        private set


    // Constructor
    init {
        cargarVideojuegos()
    }


    private fun cargarVideojuegos() {

        val query = """
            fields id, name, cover.image_id, total_rating, total_rating_count, first_release_date, summary;
            where total_rating != null;
            sort total_rating_count desc;
            limit 50;
        """.trimIndent()

        val body = query.toRequestBody("text/plain".toMediaType())

        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (IGDBClient.accessToken == null) {
                    IGDBClient.getIGDBToken()
                }

                val resultado = IGDBClient.service.getVideojuegos(body)

                withContext(Dispatchers.Main) {
                    listaVideojuegos = resultado
                }

            } catch (e: Exception) {
                Log.e("ERROR DE API", "Error al cargar la LISTA de videojuegos: ${e.message} | ${e.printStackTrace()}")
            }
        }
    }


    fun obtenerJuegoPorId(juegoId: Int): Videojuego? {
        for (juego in listaVideojuegos) {
            if (juego.id == juegoId) {
                return juego
            }
        }
        return null
    }


    fun alternarFavorito(juego: Videojuego) {
        if (listaFavoritos.contains(juego)) {
            listaFavoritos = listaFavoritos - juego
        } else {
            listaFavoritos = listaFavoritos + juego
        }
    }


}