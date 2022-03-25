package com.example.jsnews.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.jsnews.model.NewsResponse
import com.example.jsnews.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {


    val breakingNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    val searchNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchNewsPage = 1


    init {
        getBreakingNews("br")
    }

    fun getBreakingNews(countryCode: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    fun searchNews(searchQuery: String) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        val response = newsRepository.searchNews(searchQuery, searchNewsPage)
        searchNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse> ) : Resource<NewsResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Seuccess(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }



    private fun handleSearchNewsResponse(response: Response<NewsResponse> ) : Resource<NewsResponse> {
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Seuccess(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }



}