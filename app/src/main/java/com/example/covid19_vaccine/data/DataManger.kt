package com.example.covid19_vaccine.data

import com.example.covid19_vaccine.data.domain.VaccineData

object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()
    private var countryList = mutableListOf<VaccineData>()
    private var oneCountryList = mutableListOf<VaccineData>()
    private var vaccineIndex = 0
    var dailyList = mutableListOf<VaccineData>()
    fun addVaccine(vaccine: VaccineData) = vaccineList.add(vaccine)
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
    // initCountryList filter vaccineList according to country to create new list content only last row of data
    fun initCountryList(){
        (0 until vaccineList.size - 1)
            .filter { vaccineList[it].country != vaccineList[it +1].country }
            .forEach { oneCountryList.add(vaccineList[it]) }
        oneCountryList.add(vaccineList[vaccineList.size - 1])
    }
    // function to convert big numbers to K , M and B style
    fun convertNumber(number: Double): String {
        return when {
            (number / 1000000000) >= 1 -> {
                val number1 =number / 1000000000
                String.format("%.3f", number1) + "B"
            }
            (number / 1000000) >= 1 -> {
                val number1 =number / 1000000
                String.format("%.2f", number1) + "M"
            }
            (number / 1000) >= 1 -> {
                ((number / 1000).toInt()).toString() + "K"
            }
            else -> {
                number.toString()
            }
        }
    }
    // function getTopTen get only the top ten country according data entry
    fun getTopTen() = oneCountryList.sortedByDescending{list -> list.people_vaccinated}.subList(0, 9)

    fun getDailyVaccine(country: String): MutableList<Double> {
        val list = mutableListOf<Double>()
        vaccineList.forEach {
            if (it.country.lowercase().trim() == country.lowercase().trim()){
                list.add(it.daily_vaccinations)
            }
        }
        return list
    }

    fun getTopTen() = oneCountryList.sortedByDescending{list -> list.people_vaccinated}.subList(0, 10)
    fun getTopFive() = oneCountryList.sortedByDescending{list -> list.people_vaccinated}.subList(0, 5)
    fun getTopOneHandred() = oneCountryList.sortedByDescending{list -> list.people_vaccinated}.subList(0, 100)
  }
