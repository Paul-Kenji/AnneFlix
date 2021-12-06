package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

internal data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String?,
)

internal fun MovieResponse.toMovie() = Movie(
    id = id,
    original_language = original_language,
    original_title = original_title,
    title = title,
    overview = overview
)
