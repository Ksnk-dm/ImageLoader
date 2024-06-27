package com.dm.imageloader.domain.repository


import com.dm.imageloader.core.utils.Resources
import com.dm.imageloader.domain.model.Image
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    fun getImages(text: String): Flow<Resources<List<Image>>>
}