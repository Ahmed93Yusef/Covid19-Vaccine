package com.example.covid19_vaccine.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.domain.StatisticRecyclerView
import com.example.covid19_vaccine.databinding.ItemStatisticsBinding

class StatisticsAdapter (val listStatis: List<StatisticRecyclerView>): RecyclerView.Adapter<StatisticsAdapter.StatisticViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatisticViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_statistics, parent, false)
        return StatisticViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatisticViewHolder, position: Int) {
        val currentCountry = listStatis[position]
        holder.binding.apply{
            countryName.text = currentCountry.countryName
            countryVaccinePer.text = currentCountry.countryVaccinePer.toString()
            countryVaccineTotal.text = currentCountry.countryVaccineTotal.toString()

        }
    }

    override fun getItemCount() = listStatis.size

    class StatisticViewHolder (viewItem: View): RecyclerView.ViewHolder(viewItem){
        val binding = ItemStatisticsBinding.bind(viewItem)
    }
}