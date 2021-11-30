package com.gmail.eamosse.idbdata.datasources

import com.gmail.eamosse.idbdata.api.response.CategoryResponse
import com.gmail.eamosse.idbdata.api.response.ListMoviesResponse
import com.gmail.eamosse.idbdata.api.response.TokenResponse
import com.gmail.eamosse.idbdata.api.response.parse
import com.gmail.eamosse.idbdata.api.response.safeCall
import com.gmail.eamosse.idbdata.api.service.MovieService
import com.gmail.eamosse.idbdata.utils.Result

/**
 * Manipule les données de l'application en utilisant un web service
 * Cette classe est interne au module, ne peut être initialisé ou exposé aux autres composants
 * de l'application
 */
internal class OnlineDataSource(private val service: MovieService) {

    /**
     * Récupérer le token du serveur
     * @return [Result<Token>]
     * Si [Result.Succes], tout s'est bien passé
     * Sinon, une erreur est survenue
     */

    suspend fun getToken(): Result<TokenResponse> {
        return safeCall {
            val response = service.getToken()
            response.parse()
        }
    }

    suspend fun getCategories(): Result<List<CategoryResponse.Genre>> {
        return safeCall {
            val response = service.getCategories()
            val res = response.parse()
            when (res) {
                is Result.Succes -> {
                    Result.Succes(res.data.genres)
                }
                is Result.Error -> res
            }
        }
    }

    suspend fun getMovies(id_genre: String): Result<List<ListMoviesResponse.GenreMovie>> {
        return safeCall {
            val response = service.getMovies(id_genre)
            val res = response.parse()
            when (res) {
                is Result.Succes -> {
                    Result.Succes(res.data.genreMovies)
                }
                is Result.Error -> res
            }
        }
    }
}
