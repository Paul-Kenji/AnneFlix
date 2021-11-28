package com.gmail.eamosse.idbdata.data

data class CategoryMovies(
    val page: Int,
    val results: List<Any>,
    val total_results: Int,
    val total_pages: Int
)
