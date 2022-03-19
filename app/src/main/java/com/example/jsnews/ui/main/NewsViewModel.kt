package com.example.jsnews.ui.main

import androidx.lifecycle.ViewModel
import com.example.jsnews.model.NewsResponse
import com.example.jsnews.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {



}