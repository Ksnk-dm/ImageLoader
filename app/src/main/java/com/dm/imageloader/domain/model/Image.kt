package com.dm.imageloader.domain.model

data class Image(
    var id: String,
    var src: String,
    var srcSmall: String,
    var width: Int,
    var height: Int,
)
