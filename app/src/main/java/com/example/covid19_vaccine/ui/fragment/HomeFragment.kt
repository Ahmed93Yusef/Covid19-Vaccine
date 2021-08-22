package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import com.example.covid19_vaccine.databinding.FragmentHomeBinding
import com.example.covid19_vaccine.ui.MainActivity

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    private val myDetailsButtonFragment = DetailsButtonFragment()

    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun setup() {
    }

    override fun addCallBack() {
        buttonDetails()
    }

    fun buttonDetails() {
        binding!!.buttonDetails.setOnClickListener {

            MainActivity().addFragment(myDetailsButtonFragment)

        }

    }

}
