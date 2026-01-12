## IGDB Video Game Discovery

A modern Android application built with **Kotlin** and **Jetpack Compose** that allows users to explore the most popular video games using the **IGDB API**.


### App Demo Video
**[Click here to watch the Demo Video](https://github.com/flores711/Android-Videogames-Project/releases/download/v1.0/Demo.Proyecto.Videojuegos.mp4)**


### Key Features

* **Live Discovery:** Fetches and displays games ranked by popularity (based on review count) using the IGDB API.
* **Detailed View:** Dedicated screens for each game showing descriptions, ratings, and artwork.
* **Favorites System:** Users can save games to a favorites list and manage them (Add/Remove) in real-time.
* **Dynamic Navigation:** Smooth transitions between the main catalog, game details, and the favorites section.


### Technical Architecture

I followed modern Android development standards to ensure the app is scalable and efficient:

* **MVVM Architecture:** Clean separation between UI (Compose), State management (ViewModel), and Data fetching.
* **Navigation Component:** Safe and organized routing between screens.
* **Retrofit & OKHttp:** Handles API requests to IGDB, including authentication and JSON parsing.
