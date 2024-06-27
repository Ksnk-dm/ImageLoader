package com.dm.imageloader.data.repository

import com.dm.imageloader.core.utils.Resources
import com.dm.imageloader.data.mapper.toImage
import com.dm.imageloader.data.remote.ImageApi
import com.dm.imageloader.domain.model.Image
import com.dm.imageloader.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageRepositoryImpl @Inject constructor(
    private val imageApi: ImageApi
) : ImageRepository {

    override fun getImages(text: String): Flow<Resources<List<Image>>> =
        flow {
            emit(Resources.Loading(true))
            val remoteList = runCatching {
                imageApi.getApiImages(text)
            }.onFailure {
                emit(Resources.Error(it.message.toString()))
            }.getOrNull()

            if (remoteList == null) {
                emit(Resources.Loading(false))
            }

            remoteList.let { listing ->
                emit(Resources.Success(data = listing?.images?.map { it.toImage() }))
                emit(Resources.Loading(false))
            }
        }
}