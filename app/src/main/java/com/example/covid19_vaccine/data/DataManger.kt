package com.example.covid19_vaccine.data

import android.util.Log
import com.example.covid19_vaccine.data.domain.VaccineData
import java.security.Key


object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()

    private var vaccineIndex = 0

    fun addVaccine(vaccine: VaccineData) = vaccineList.add(vaccine)


//    this function using with RecyclerView to make the the last position on Recycler can Reachable

    fun getCurrentItem():VaccineData = vaccineList[vaccineIndex]
    fun getNextItem() : VaccineData{
        var a : Double = 0.0
        vaccineIndex++
        if (vaccineIndex == vaccineList.size){
            vaccineIndex = 0
        }
        return vaccineList[vaccineIndex]
    }
    fun getPreviousItem() : VaccineData{ //this function using with Recycler View to make the the last position on Recycler can Reachable
        vaccineIndex--
        if (vaccineIndex == -1){
            vaccineIndex = vaccineList.size-1
        }
        return vaccineList[vaccineIndex]
    }

    

    fun getCountry(country: String) = vaccineList.let {
        countryList = it.filter { it1 ->
            it1.country.lowercase().trim() == country.lowercase().trim() }.toMutableList()

        it.associateBy(
            keySelector = { country.lowercase().trim() },
            valueTransform = { countryList }
        )
    }








    private fun log(value : Any) {
       Log.v("MAIN_ACTIVITY", value.toString())

    }




  }
