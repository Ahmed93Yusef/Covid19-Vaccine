package com.example.covid19_vaccine.data

import android.util.Log
import com.example.covid19_vaccine.data.domain.VaccineData

object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()

    private var oneCountryList = mutableListOf<VaccineData>()

    private var topCountriesVaccinated = mutableListOf<Double>()

    private var countryNameList = mutableSetOf<String>()

    fun addVaccine(vaccine: VaccineData) = vaccineList.add(vaccine)

    private var vaccineIndex = 0
    //thus function using with RecyclerView to make the the first position on Recycler can Reachable
    fun getCurrentItem():VaccineData = vaccineList[vaccineIndex]
    fun getNextItem() : VaccineData{
        vaccineIndex++
        if (vaccineIndex == vaccineList.size){
            vaccineIndex = 0
        }
        return vaccineList[vaccineIndex]
    }
    fun getPreviousItem() : VaccineData{
        vaccineIndex--
        if (vaccineIndex == -1){
            vaccineIndex = vaccineList.size-1
        }
        return vaccineList[vaccineIndex]
    }
    //thus function using with Recycler View to make the the last position on Recycler can Reachable

    fun getCountry(country: String) = vaccineList.let {
        countryList = it.filter { it1 ->
            it1.country.lowercase().trim() == country.lowercase().trim()
        }.toMutableList()

        it.associateBy(
            keySelector = { country.lowercase().trim() },
            valueTransform = { countryList }
        )
    }

    fun getLastCountry(){
        for (i in 0 until vaccineList.size) {
           if( vaccineList[i].country != vaccineList[i+1].country){
            oneCountryList.add(vaccineList[i])
           }
        }

    }


    fun getTopFive(){
        for (i in oneCountryList.indices){
            topCountriesVaccinated.add(oneCountryList[i].people_vaccinated)
        }
    }
    fun topTen() = topCountriesVaccinated.sort()


// function to convert big numbers to K and M style

    fun convertNumber(number: Double): String {
        return when {
            (number / 1000000) >= 1 -> {
                val number1 =number / 1000000
                String.format("%.2f", number1) + "M"
            }
            (number / 1000) >= 1 -> {
                (((number / 1000).toInt()).toString() + "K")
            }
            else -> {
                number.toString()
            }
        }
    }

//    fun putCountryNameList(){
//        vaccineList.forEach{
//            countryNameList.add(it.country)
//        }
//        countryNameList.forEach {
//            Log.i("DataManger", it)
//        }
//    }

  }
