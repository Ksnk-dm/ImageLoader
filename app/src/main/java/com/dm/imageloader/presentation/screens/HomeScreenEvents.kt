package com.dm.imageloader.presentation.screens

sealed class HomeScreenEvents {
    data class LoadImages(val q: String) : HomeScreenEvents()
    data class UpdateText(val q: String) : HomeScreenEvents()
}