package com.example.covid19_vaccine.data

import com.example.covid19_vaccine.data.domain.VaccineData


object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()

    private var oneCountryList = mutableListOf<VaccineData>()

    private var topVaccine = mutableListOf<Double>()



    fun addVaccine(vaccine: VaccineData) = vaccineList.add(vaccine)

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
            topVaccine.add(oneCountryList[i].people_vaccinated)
        }
    }
    fun topTen() = topVaccine.sort()



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


}


