package com.example.covid19_vaccine.data

import android.util.Log
import com.example.covid19_vaccine.data.domain.VaccineData


object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()

    private var countryMap = mutableMapOf<String , VaccineData>()

    private var countryName = mutableSetOf<String>()

    fun addVaccine(vaccine: VaccineData){
        vaccineList.add(vaccine)
    }

    fun countryFun(country: String){
        vaccineList.forEach {
            if (country == it.country){
                countryList.add(it)
            }

        }
    }
    fun countryMap(country: String){
        vaccineList.forEach {
            if (country == it.country){
                countryMap[country] = it
            }

        }

    }

    fun nameCountry(): MutableSet<String> {
        vaccineList.forEach {
            countryName.add(it.country)
        }
        return countryName
    }

    fun group(country: String){

        var x = countryMap[country]?.people_fully_vaccinated
        log(x.toString())
        }


    }


    private fun log(value : Any){
        Log.v("MAIN_ACTIVITY", value.toString())
    }


