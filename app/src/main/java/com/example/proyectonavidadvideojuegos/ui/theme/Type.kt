package com.example.proyectonavidadvideojuegos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with

val miFuente = FontFamily.Monospace
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = miFuente,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = miFuente,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
)