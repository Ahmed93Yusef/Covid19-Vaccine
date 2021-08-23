package com.example.covid19_vaccine.data

import android.util.Log
import com.example.covid19_vaccine.data.domain.VaccineData


object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()

    var totalFullyVaccine = 0





    fun addVaccine(vaccine: VaccineData) = vaccineList.add(vaccine)

    fun getCountry(country: String) = vaccineList.let {
        countryList = it.filter { it1 ->
            it1.country.lowercase().trim() == country.lowercase().trim() }.toMutableList()

        it.associateBy(
            keySelector = { country.lowercase().trim() },
            valueTransform = { countryList }
        )
    }











    private fun log(value : Any){
        Log.v("MAIN_ACTIVITY", value.toString())
    }

  }


