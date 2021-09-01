package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.FragmentHomeTestBinding

class HomeTestFragment: BaseFragment<FragmentHomeTestBinding>(){
    override val bindingInflater: (LayoutInflater) -> FragmentHomeTestBinding = FragmentHomeTestBinding::inflate

    override fun setup() {
        buttonClicked()
    }
    override fun addCallBack() {
        visible(false)
    }
    //buttonClicked function tests whether a person is infected or not
    private fun buttonClicked() {
        binding?.submittedButton?.setOnClickListener {
            when {
                binding?.hardChip2?.isChecked == true || binding?.hardChip3?.isChecked == true || binding?.hardChip4?.isChecked == true -> {
                    binding?.infectedText?.text = getString(R.string.youInfected)
                    visible(true)
                }
                binding?.mediumChip1?.isChecked == true || binding?.mediumChip5?.isChecked == true || binding?.mediumChip6?.isChecked == true  -> {
                    binding?.infectedText?.text = getString(R.string.possibly_infected)
                    visible(true)
                }
                binding?.commonChip1?.isChecked == true || binding?.commonChip2?.isChecked == true || binding?.commonChip3?.isChecked == true -> {
                    binding?.infectedText?.text = getString(R.string.no_infected)
                    visible(true)
                }
                else -> {
                    visible(false)
                }
            }
        }
    }
    // visible function activates visibility according to the states
    private fun visible(state: Boolean) {
        binding?.infectedText?.isVisible = state
    }
}