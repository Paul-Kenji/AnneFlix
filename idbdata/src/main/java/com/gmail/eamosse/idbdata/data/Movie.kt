package com.gmail.eamosse.idbdata.data

data class Movie(
    val id: String,
    val original_language: String,
    val original_title: String,
    val title: String,
    val overview: String?,
    val vote_average: String,
    val vote_count: String,
    val runtime: String,
)
