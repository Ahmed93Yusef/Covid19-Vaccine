package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.example.covid19_vaccine.R
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
                "${data.people_vaccinated_per_hundred}%".also { txtPeopleVaccinePerHundred.text = it }
                "${data.people_fully_vaccinated_per_hundred}%".also { txtPeopleFullyVaccinePerHundred.text = it }
                txtCountryName.text = data.country
            }
        }
        chartDataSet(DataManger.getDailyVaccine(country),country)
    }
    private fun chartDataSet(data: MutableList<Double>,country: String){
        val aaChartView = binding?.lineChart
        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Area)
            .title("Daily Vaccination")
            .backgroundColor(resources.getColor(R.color.white))
            .dataLabelsEnabled(true)
            .yAxisTitle("vaccination")
            .yAxisLabelsEnabled(false)
            .categories(arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"))
            .series(arrayOf(
                AASeriesElement()
                    .name(country)
                    .enableMouseTracking(true)
                    .data(arrayOf(data[1], data[data.size-125], data[data.size-110], data[data.size-90], data[data.size-75], data[data.size-40], data[data.size-20], data[data.size-1])),
            )
            )
            .animationDuration(3000)
        aaChartView?.aa_drawChartWithChartModel(aaChartModel)
        aaChartView?.aa_updateChartWithOptions(aaChartModel,true)

    }
    override fun addCallBack() {
        visibility(false)
    }
    private fun visibility(state: Boolean) {
        binding?.apply {
            cardCountry.isVisible = state
            txtCountryName.isVisible =state
            txtPeopleFullyVaccine.isVisible =state
            txtPeopleVaccinePerHundred.isVisible =state
            txtPeopleFullyVaccinePerHundred.isVisible =state
            labPeopleVaccine.isVisible =state
            labPeopleFullyVaccine.isVisible =state
            txtPeopleVaccine.isVisible =state
            lottieSearch.isVisible = !state
            lineChart.isVisible = state
            chartCard.isVisible = state
        }
    }
}