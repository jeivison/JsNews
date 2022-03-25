package com.example.jsnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jsnews.databinding.ActivityNewsBinding
import com.example.jsnews.repository.NewsRepository
import com.example.jsnews.ui.main.NewsViewModel
import com.example.jsnews.ui.main.NewsViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_news.*
import com.example.jsnews.db.ArticleDatabase as ArticleDatabase1

class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val newsRepository = NewsRepository(ArticleDatabase1(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}