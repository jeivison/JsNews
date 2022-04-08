package com.example.jsnews.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.example.jsnews.NewsActivity
import com.example.jsnews.R
import com.example.jsnews.ui.main.fragment.Article
import com.example.jsnews.ui.main.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*


class Article : Fragment(R.layout.fragment_article) {

    private lateinit var viewModel: NewsViewModel
     private val args: ArticleArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.articleFragment
        webView.apply {
            webViewClient =WebViewClient()
            article?.url?.let { loadUrl(it) }
       }

        fab.setOnClickListener {
            if (article != null) {
                viewModel.saveArticle(article)
            }
            Snackbar.make(view, "Article saved successfullyl", Snackbar.LENGTH_SHORT).show()
        }
    }
}









