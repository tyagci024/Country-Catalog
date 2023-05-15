package com.example.movieappcatalog.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movieappcatalog.model.Country
import com.example.movieappcatalog.service.CountryApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class CountryViewModel(application: Application):AndroidViewModel(application) {
    private val countryApiService= CountryApiService()
    private val disposable= CompositeDisposable()

    val countryValue = MutableLiveData<List<Country>>()



    fun getDataFromApi(){
        disposable.add(
            countryApiService.getCountry()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>(){
                    override fun onSuccess(t: List<Country>) {
                        countryValue.value=t


                    }

                    override fun onError(e: Throwable) {
                     e.printStackTrace()
                    }


                }

                )
        )

    }
}

