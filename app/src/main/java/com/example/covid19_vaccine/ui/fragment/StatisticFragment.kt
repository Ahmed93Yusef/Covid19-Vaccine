package com.example.covid19_vaccine.ui.fragment

import StatisticsAdapter
import android.view.LayoutInflater
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.FragmentStatisticBinding

class StatisticFragment: BaseFragment<FragmentStatisticBinding>() {

    lateinit var adapter: StatisticsAdapter


    override val bindingInflater: (LayoutInflater) -> FragmentStatisticBinding = FragmentStatisticBinding::inflate

    override fun setup() {

        val topTeenCountry = DataManger.getTopTen()

        adapter = StatisticsAdapter(topTeenCountry)
        binding?.dataTopRecyclerView?.adapter = adapter
    }

    override fun addCallBack() {}


}
