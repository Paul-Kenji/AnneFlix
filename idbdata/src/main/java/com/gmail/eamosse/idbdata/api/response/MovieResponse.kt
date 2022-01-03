package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName
import java.util.concurrent.TimeUnit

internal data class MovieResponse(
    @SerializedName("imdb_id")
    val id: String,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("vote_average")
    val vote_average: Number,
    @SerializedName("vote_count")
    val vote_count: Int,
    @SerializedName("runtime")
    val runtime: Int?,
)

internal fun MovieResponse.toMovie(): Movie {
    return Movie(
        id = id,
        original_language = "Language: " + language(original_language),
        original_title = original_title,
        title = title,
        overview = overview,
        vote_average = "Vote average: " + vote_average.toString(),
        vote_count = "Vote count: " + vote_count.toString(),
        runtime = "Runtime: " + fromMinutesToHHmm(runtime),
    )
}

private fun language(l: String): Any? {
    var lang = l
    if (l == "en") {
        lang = "English"
    }
    if (l == "hi") {
        lang = "Hindi"
    }
    if (l == "ja") {
        lang = "Japanese"
    }
    if (l == "it") {
        lang = "Italian"
    }
    if (l == "es") {
        lang = "Spanish"
    }
    if (l == "ru") {
        lang = "Russian"
    }
    if (l == "fr") {
        lang = "French"
    }
    return lang
}

private fun fromMinutesToHHmm(r: Int?): String {
    val hours = r?.let { TimeUnit.MINUTES.toHours(it.toLong()) }
    val remainMinutes = r?.minus(TimeUnit.HOURS.toMinutes(hours!!))
    return String.format("%02d:%02d", hours, remainMinutes)
}
