package com.example.jsnews.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.jsnews.NewsActivity
import com.example.jsnews.R
import com.example.jsnews.ui.main.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*


class Article : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    val args: ArticleArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.articleFragment
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

    }

}

