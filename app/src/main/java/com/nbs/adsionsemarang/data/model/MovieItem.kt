package com.nbs.adsionsemarang.data.model

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("original_title")
    val title: String?,

    @SerializedName("poster_path")
    val poster: String?,

    @SerializedName("id")
    val id: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("homepage")
    val homePage: String?
)