package com.example.covid19_vaccine.data

import android.util.Log
import com.example.covid19_vaccine.data.domain.VaccineData
import com.example.covid19_vaccine.util.Constant
import java.math.BigInteger

object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()


    var countyIndex = 0

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
    fun group(){
        var x : Int = 0

        for (i in vaccineList.indices)
        {
            if (vaccineList[i].daily_vaccinations != null){
                vaccineList[i].daily_vaccinations!!.let { x.plus(it)}
        }}
        log(x)

    }

    fun getNext():VaccineData








    fun log(value : Any){
        Log.v("MAIN_ACTIVITY", value.toString())
    }

}
