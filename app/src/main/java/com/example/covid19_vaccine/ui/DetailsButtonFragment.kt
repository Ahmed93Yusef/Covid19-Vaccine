package com.example.covid19_vaccine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.covid19_vaccine.databinding.FragmentButtonDetailsBinding

class DetailsButtonFragment : Fragment(){
    lateinit var binding: FragmentButtonDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }
}
