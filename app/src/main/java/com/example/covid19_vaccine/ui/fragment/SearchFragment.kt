package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.FragmentSearchBinding
import com.example.covid19_vaccine.util.Constant
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

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
            var count = 0
            val xValue = mutableListOf<String>()
            val lineEntry = mutableListOf<Entry>()
            for (i in 0..5){
            val data1 = dataCountry.value[count]
                xValue.add(data1.date)
                lineEntry.add(Entry(data1.daily_vaccinations.toFloat(),i))
                count =+ 30
            }
            val lineDataSet = LineDataSet(lineEntry, Constant.CHART_LABEL)
            lineDataSet.color = resources.getColor(R.color.green)
            binding?.lineChart?.data = LineData(xValue,lineDataSet)
            binding?.lineChart?.setBackgroundColor(resources.getColor(R.color.white))
            binding?.lineChart?.animateXY(3000,3000)
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