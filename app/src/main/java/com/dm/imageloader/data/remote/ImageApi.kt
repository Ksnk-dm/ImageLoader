package com.dm.imageloader.data.remote

import com.dm.imageloader.data.remote.models.ImagesList
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    @GET("search")
    suspend fun getApiImages(
        @Query("q") q : String
    ): ImagesList
}