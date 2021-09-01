package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    override fun setup() {
        binding?.apply {
            inputCountryText.isIconified = false
            inputCountryText.setOnQueryTextListener(object :
                android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(search: String?): Boolean {
                    searchSubmit(requireNotNull(search))
                    return false
                }

                override fun onQueryTextChange(newSearch: String?): Boolean {
                    searchTextChange(requireNotNull(newSearch))
                    return false
                }
            })
        }
    }
    private fun searchSubmit(country: String) {
        binding?.apply {
            visibility(true)
            if (country.isEmpty() || DataManger.getCountry(country.lowercase().trim())
                        [country.lowercase().trim()].isNullOrEmpty()
            ) {
                lottieError.visibility = View.VISIBLE
                visibility(false)
            } else {
                setData(country)
                visibility(true)
            }
            lottieSearch.isVisible = false
        }
    }
    private fun searchTextChange(newText: String) {
        binding?.apply {
            lottieError.visibility = View.GONE
            visibility(false)
            lottieSearch.isVisible = true
            lineChart.isVisible = false
        }
    }
    private fun setData(country: String) {
        DataManger.getCountry(country).forEach { dataCountry ->
            val data = dataCountry.value[dataCountry.value.size - 1]

            binding?.apply {
                txtPeopleVaccine.text = DataManger.convertNumber(data.people_vaccinated)
                txtPeopleFullyVaccine.text = DataManger.convertNumber(data.people_fully_vaccinated)
                txtCountryName.text = data.country
            }
        }
    }
    override fun addCallBack() {
        visibility(false)
    }
    private fun visibility(state: Boolean) {
        binding?.apply {
            cardCountry.isVisible = state
            txtCountryName.isVisible =state
            txtPeopleFullyVaccine.isVisible =state
            labPeopleVaccine.isVisible =state
            labPeopleFullyVaccine.isVisible =state
            txtPeopleVaccine.isVisible =state
            lottieSearch.isVisible = !state
            lineChart.isVisible = state
        }
    }
}