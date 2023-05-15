package com.example.movieappcatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappcatalog.R
import com.example.movieappcatalog.model.Country
import com.example.movieappcatalog.utill.downloadfromURL
import com.example.movieappcatalog.view.FragmentListDirections

class CountryAdapter (val countryList:ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.MovieViewHolder>() {
    class MovieViewHolder (view: View): RecyclerView.ViewHolder(view){
        val countryName = view.findViewById<TextView>(R.id.country_name)
        val countryCapital = view.findViewById<TextView>(R.id.country_capital)
        val countryFlag=view.findViewById<ImageView>(R.id.country_flag)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return MovieViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.countryName.text=countryList[position].name
        holder.countryCapital.text=countryList[position].capital

        holder.countryFlag.downloadfromURL(countryList[position].flag)

        holder.itemView.setOnClickListener {
            val action =FragmentListDirections.actionFragmentListToCountryDetail()
            Navigation.findNavController(it).navigate(action)
        }




    }

    override fun getItemCount(): Int {
        return countryList.size
    }
    fun updateData(newCountryList : List<Country>){
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }
}