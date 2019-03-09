package com.nbs.adsionsemarang.data.model

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("original_title")
    val title: String?,

    @SerializedName("poster_path")
    val poster: String?
)