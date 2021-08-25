package com.example.covid19_vaccine.data

import com.example.covid19_vaccine.data.domain.VaccineData


object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var countryList = mutableListOf<VaccineData>()

    var totalFullyVaccine = 0


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

    fun convertNumber(number: Double): String {
        return when {
            (number / 1000000) >= 1 -> {
                var number1 =number / 1000000
                String.format("%.2f", number1).toString() + "M"
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


