package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import com.example.covid19_vaccine.databinding.FragmentVaccineTypeShowBinding

class VaccineTypeShowFragment : BaseFragment<FragmentVaccineTypeShowBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentVaccineTypeShowBinding = FragmentVaccineTypeShowBinding::inflate
    override fun setup() {
    }
    override fun addCallBack() {}
}
