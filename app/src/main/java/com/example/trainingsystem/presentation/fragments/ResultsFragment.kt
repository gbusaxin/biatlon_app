package com.example.trainingsystem.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.FragmentResultsBinding
import com.example.trainingsystem.presentation.AppViewModel
import com.example.trainingsystem.presentation.adapters.TeamsResultAdapter


class ResultsFragment : Fragment() {

    lateinit var adapter:TeamsResultAdapter
    lateinit var viewModel:AppViewModel
    lateinit var binding : FragmentResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = TeamsResultAdapter()
        viewModel.teamsResultData.observe(viewLifecycleOwner,{
            adapter.list = it
            binding.rvResults.adapter = adapter
        })
    }

}