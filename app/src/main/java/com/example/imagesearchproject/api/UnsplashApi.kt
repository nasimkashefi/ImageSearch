package com.example.imagesearchproject.api

import com.example.imagesearchproject.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
        const val client_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }
    @Headers("Accept-Version: v1","Authorization: Client-ID $client_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ):UnsplashResponse
}