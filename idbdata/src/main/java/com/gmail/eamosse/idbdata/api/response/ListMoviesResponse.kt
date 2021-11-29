package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.CategoryMovies
import com.google.gson.annotations.SerializedName

internal data class ListMoviesResponse(
    @SerializedName("genreMovies")
    val genreMovies: List<GenreMovie>,
) {
    data class GenreMovie(
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val results: List<Any>,
        @SerializedName("total_results")
        val total_results: Int,
        @SerializedName("total_pages")
        val total_pages: Int
    )
}

internal fun ListMoviesResponse.GenreMovie.toCategoryMovies() = CategoryMovies(
    page = page,
    results = results,
    total_results = total_results,
    total_pages = total_pages
)
