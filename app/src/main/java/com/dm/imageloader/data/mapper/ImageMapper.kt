package com.dm.imageloader.data.mapper

import com.dm.imageloader.data.remote.models.ImageParams
import com.dm.imageloader.domain.model.Image

fun ImageParams.toImage(): Image {
    return Image(
        id = id,
        width = width,
        height = height,
        srcSmall = srcSmall,
        src = src
    )
}