package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.CategoryMovies
import com.google.gson.annotations.SerializedName

internal data class ListMoviesResponse(
    @SerializedName("results")
    val genreMovies: List<GenreMovie>,
) {
    data class GenreMovie(
        @SerializedName("id")
        val id: Int,
        @SerializedName("original_title")
        val original_title: String,
        @SerializedName("poster_path")
        val poster_path: String?

    )
}

internal fun ListMoviesResponse.GenreMovie.toCategoryMovies() = CategoryMovies(
    id = id,
    original_title = original_title,
    poster_path = poster_path
)

