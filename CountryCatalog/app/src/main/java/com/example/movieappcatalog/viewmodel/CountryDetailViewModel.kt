package com.example.movieappcatalog.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movieappcatalog.model.Country

class CountryDetailViewModel (application: Application): AndroidViewModel(application){
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val country = Country("turkey","ankara","www.ss.com","turkish","lira","karisik")
        countryLiveData.value=country
    }
}