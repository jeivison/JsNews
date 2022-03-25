package com.example.jsnews.repository

import androidx.lifecycle.ViewModel
import androidx.room.Query
import com.example.jsnews.db.ArticleDatabase
import com.example.jsnews.service.RetrofitInstance

class NewsRepository(
    val db: ArticleDatabase
) : ViewModel() {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

}