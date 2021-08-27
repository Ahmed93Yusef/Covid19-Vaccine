package com.example.covid19_vaccine.util

import com.example.covid19_vaccine.data.domain.VaccineRecyclerView

interface VaccineInteraction {
    fun onClickItem(vaccineView : VaccineRecyclerView)
    fun onClickServiceName(name : String)
    fun onClickServiceImage(image : Int)
}
