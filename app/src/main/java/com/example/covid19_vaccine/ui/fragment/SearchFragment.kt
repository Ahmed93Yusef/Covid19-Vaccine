package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.FragmentSearchBinding
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement


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
            val aaChartView = binding?.lineChart
            val aaChartModel : AAChartModel = AAChartModel()
                .chartType(AAChartType.Area)
                .title("title")
                .subtitle("subtitle")
                .backgroundColor("#4b2b7f")
                .dataLabelsEnabled(true)
                .series(arrayOf(
                    AASeriesElement()
                        .name("Tokyo")
                        .data(arrayOf(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6)),
                    AASeriesElement()
                        .name("NewYork")
                        .data(arrayOf(0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5)),
                    AASeriesElement()
                        .name("London")
                        .data(arrayOf(0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0)),
                    AASeriesElement()
                        .name("Berlin")
                        .data(arrayOf(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8))
                )
                )
            aaChartView?.aa_drawChartWithChartModel(aaChartModel)

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