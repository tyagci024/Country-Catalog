package com.example.movieappcatalog.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.movieappcatalog.R
import com.example.movieappcatalog.adapter.CountryAdapter
import com.example.movieappcatalog.databinding.FragmentCountryDetailBinding
import com.example.movieappcatalog.databinding.FragmentListBinding
import com.example.movieappcatalog.viewmodel.CountryDetailViewModel
import com.example.movieappcatalog.viewmodel.CountryViewModel


class CountryDetail : Fragment() {
    private val viewModel: CountryDetailViewModel by viewModels()
    private val countryAdapter = CountryAdapter(arrayListOf())
    private var _binding : FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel.getDataFromRoom()
        // Inflate the layout for this fragment
        observeLiveData()
        return view
    }
    fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {
            it?.let{
                binding.language.text=it.language
                binding.currency.text=it.currency
                binding.region.text=it.region

            }
        })
    }


}