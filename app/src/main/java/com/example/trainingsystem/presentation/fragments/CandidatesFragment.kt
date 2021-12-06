package com.example.trainingsystem.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trainingsystem.R
import com.example.trainingsystem.databinding.FragmentCandidatesBinding
import com.example.trainingsystem.presentation.AppViewModel
import com.example.trainingsystem.presentation.adapters.CandidatAdapter

class CandidatesFragment : Fragment() {

    lateinit var viewModel:AppViewModel
    lateinit var adapter:CandidatAdapter
    lateinit var binding: FragmentCandidatesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCandidatesBinding.inflate(inflater,container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvCandidat = binding.rvCandidat
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = CandidatAdapter()
        viewModel.candidatesList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvCandidat.adapter = adapter
        })
    }

}