package com.example.trainingsystem.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.FragmentNewsBinding
import com.example.trainingsystem.presentation.AppViewModel
import com.example.trainingsystem.presentation.adapters.NewsAdapter

class NewsFragment : Fragment() {

    lateinit var viewModel:AppViewModel
    lateinit var adapter: NewsAdapter
    lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = NewsAdapter()
        val rvNews = binding.rvNews
        viewModel.newsInfoList.observe(viewLifecycleOwner,{
            adapter.newsList = it
            rvNews.adapter = adapter
        })

    }
}