package com.example.covid19_vaccine.data

import com.example.covid19_vaccine.data.domain.VaccineData

object DataManger {

     val vaccineList = mutableListOf<VaccineData>()

     var countryList = mutableListOf<VaccineData>()

     var oneCountryList = mutableListOf<VaccineData>()

     var topCountriesVaccinated = mutableListOf<Double>()

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

    fun initCountryList() {
        for (i in 0 until vaccineList.size - 1) {
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
// function to convert big numbers to K and M style

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
                (((number / 1000).toInt()).toString() + "K")
            }
            else -> {
                number.toString()
            }
        }

    }

    fun getTopTeen() = oneCountryList.sortedByDescending{list -> list.people_vaccinated}.subList(0,10)



}
