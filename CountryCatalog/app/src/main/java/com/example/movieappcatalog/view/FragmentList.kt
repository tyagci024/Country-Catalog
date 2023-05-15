package com.example.movieappcatalog.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappcatalog.R
import com.example.movieappcatalog.adapter.CountryAdapter
import com.example.movieappcatalog.databinding.FragmentListBinding
import com.example.movieappcatalog.viewmodel.CountryViewModel


class FragmentList : Fragment() {
    private val viewModel: CountryViewModel by viewModels()
    private val countryAdapter = CountryAdapter(arrayListOf())
    private var _binding : FragmentListBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.getDataFromApi()
        binding.mRcyclr.layoutManager=LinearLayoutManager(context)
        binding.mRcyclr.adapter=countryAdapter

        observeData()
        return view
    }

    fun observeData(){
        viewModel.countryValue.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.mRcyclr.visibility=View.VISIBLE
                countryAdapter.updateData(it)
            }

        })
    }
}