package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.FragmentStatisticBinding


class StatisticFragment: BaseFragment<FragmentStatisticBinding>(){
    override val bindingInflater: (LayoutInflater) -> FragmentStatisticBinding = FragmentStatisticBinding::inflate

    override fun setup() {

        DataManger.initCountryList()
        val topTeenCountry = DataManger.getTopTeen()
        binding?.apply {
            country1Name.text = topTeenCountry[0].country
            country2Name.text = topTeenCountry[1].country
            country3Name.text = topTeenCountry[2].country
            country4Name.text = topTeenCountry[3].country
            country5Name.text = topTeenCountry[4].country

            country1VaccineTotal.text = DataManger.convertNumber(topTeenCountry[0].people_vaccinated)
            country2VaccineTotal.text = DataManger.convertNumber(topTeenCountry[1].people_vaccinated)
            country3VaccineTotal.text = DataManger.convertNumber(topTeenCountry[2].people_vaccinated)
            country4VaccineTotal.text = DataManger.convertNumber(topTeenCountry[3].people_vaccinated)
            country5VaccineTotal.text = DataManger.convertNumber(topTeenCountry[4].people_vaccinated)

            "${topTeenCountry[0].people_vaccinated_per_hundred}%".also { country1VaccinePer.text = it }
            "${topTeenCountry[1].people_vaccinated_per_hundred}%".also { country2VaccinePer.text = it }
            "${topTeenCountry[2].people_vaccinated_per_hundred}%".also { country3VaccinePer.text = it }
            "${topTeenCountry[3].people_vaccinated_per_hundred}%".also { country4VaccinePer.text = it }
            "${topTeenCountry[4].people_vaccinated_per_hundred}%".also { country5VaccinePer.text = it }
        }
    }

    override fun addCallBack() {}
}
