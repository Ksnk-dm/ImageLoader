package com.dm.imageloader.presentation.screens

import com.dm.imageloader.domain.model.Image

data class HomeScreenState(
    val images: List<Image> = emptyList(),
    val isLoading: Boolean = false,
    val text : String = ""
)