package com.dm.imageloader.data.remote.models

import com.google.gson.annotations.SerializedName

data class ImagesList(
    @SerializedName("images")
    val images : ArrayList<ImageParams>
)
