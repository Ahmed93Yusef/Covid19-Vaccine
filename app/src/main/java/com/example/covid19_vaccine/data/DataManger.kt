package com.example.covid19_vaccine.data

import android.util.Log
import com.example.covid19_vaccine.data.domain.VaccineData
import com.example.covid19_vaccine.util.Constant
import java.math.BigInteger

object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()




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






    fun log(){
        Log.v("MAIN_ACTIVITY", countryList.toString())
    }

}