package com.example.jsnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.jsnews.databinding.ActivityNewsBinding
import com.example.jsnews.db.ArticleDatabase
import com.example.jsnews.repository.NewsRepository
import com.example.jsnews.ui.main.NewsViewModel
import com.example.jsnews.ui.main.NewsViewModelProviderFactory



class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View model
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)


        //NavFragment
        //bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.news_nav_graph)

    }
}