package com.example.covid19_vaccine.data

import com.example.covid19_vaccine.data.domain.VaccineData

object DataManger {
    private val vaccineList = mutableListOf<VaccineData>()

    private var vaccineIndex = 0

    fun addVaccine(vaccine: VaccineData){
        vaccineList.add(vaccine)
    }



}