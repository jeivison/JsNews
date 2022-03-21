package com.example.jsnews.ui.main.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.jsnews.NewsActivity
import com.example.jsnews.R
import com.example.jsnews.ui.main.NewsViewModel


class Searchnews : Fragment(R.layout.fragment_searchnews) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }

}