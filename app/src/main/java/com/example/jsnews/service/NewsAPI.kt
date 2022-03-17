package com.example.jsnews.service

import com.example.jsnews.model.NewsResponse
import com.example.jsnews.service.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsAPI {

    //https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
    //KEY: 883503dde64a44e7a9f83ff2b1b4959e

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "br",
        @Query("page")
        pagerNumber: Int = 1,
        apiKey: String = API_KEY
    ): Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        countryCode: String = "br",
        @Query("page")
        pagerNumber: Int = 1,
        apiKey: String = API_KEY
    ): Response<NewsResponse>

}