package com.example.jsnews.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jsnews.NewsActivity
import com.example.jsnews.R
import com.example.jsnews.ui.main.NewsViewModel


class Breaknews : Fragment(R.layout.fragment_breaknews) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
    }
}