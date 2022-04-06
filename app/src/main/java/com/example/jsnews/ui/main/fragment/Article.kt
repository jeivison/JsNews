package com.example.jsnews.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.jsnews.NewsActivity
import com.example.jsnews.R
import com.example.jsnews.databinding.ActivityNewsBinding
import com.example.jsnews.databinding.FragmentArticleBinding
import com.example.jsnews.ui.main.NewsViewModel
import com.example.jsnews.ui.main.NewsViewModelProviderFactory
import com.google.android.material.snackbar.Snackbar


class Article : Fragment(R.layout.fragment_article) {

    private lateinit var viewModel: NewsViewModel
    val args: ArticleArgs by navArgs()
    //Binding
    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!

    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
        //viewModel = (activity as NewsActivity).viewModel
    }
        val article = args.articleFragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view = binding.webView
        view
    }

        webView.apply {
            webViewClient = WebViewClient()
            //Alteração desse código
            article.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfullyl", Snackbar.LENGTH_SHORT).show()
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}







