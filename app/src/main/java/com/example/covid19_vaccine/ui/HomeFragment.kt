package com.example.covid19_vaccine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.domain.VaccineData
import com.example.covid19_vaccine.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    private var adapter : RecyclerView.Adapter<VaccineAdapter.VaccineHolder>?=null

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun addCallBack(){
        binding.buttonDetails.setOnClickListener {

            //When the button_Detil is clicked
        }

    }


}
