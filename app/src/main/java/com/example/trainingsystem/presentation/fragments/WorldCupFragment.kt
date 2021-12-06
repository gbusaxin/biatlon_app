package com.example.trainingsystem.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.FragmentWorldCupBinding
import com.example.trainingsystem.presentation.AppViewModel
import com.example.trainingsystem.presentation.adapters.WorldCupAdapter


class WorldCupFragment : Fragment() {

    lateinit var binding: FragmentWorldCupBinding
    lateinit var viewModel:AppViewModel
    lateinit var adapter:WorldCupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorldCupBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = WorldCupAdapter()
        val rvWorldCup = binding.rvWorldCup
        viewModel.worldCupList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvWorldCup.adapter = adapter
        })
    }

}