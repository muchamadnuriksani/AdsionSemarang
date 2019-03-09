package com.nbs.adsionsemarang.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val result: List<MovieItem>
)