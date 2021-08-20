package com.example.covid19_vaccine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covid19_vaccine.data.domain.VaccineData
import com.example.covid19_vaccine.databinding.FragmentStatisticBinding
import com.example.covid19_vaccine.util.VaccineAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class StatisticFragment: Fragment() {
    lateinit var binding: FragmentStatisticBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatisticBinding.inflate(inflater, container, false)
        return binding.root
    }
}
