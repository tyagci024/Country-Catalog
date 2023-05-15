package com.example.movieappcatalog.service

import com.example.movieappcatalog.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getData(): Single<List<Country>>

}