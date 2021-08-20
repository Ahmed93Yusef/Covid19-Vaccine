package com.example.covid19_vaccine.ui

import android.annotation.SuppressLint
import com.example.covid19_vaccine.util.VaccineAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentHomeBinding.inflate(inflater,container,false )
        return binding.root



    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = VaccineAdapter()
        binding.recyclerVaccine.layoutManager = LinearLayoutManager(activity,LinearLayout.HORIZONTAL,false)
        binding.recyclerVaccine.adapter=adapter
    }

}
