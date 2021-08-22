package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.FragmentSearchBinding
import org.eazegraph.lib.models.BarModel

class SearchFragment: BaseFragment<FragmentSearchBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding = FragmentSearchBinding::inflate

    override fun setup() {
        binding!!.apply {
            inputCountryText.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchSubmit(query!!)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    searchTextChange(newText!!)
                    return false
                }

            })
        }
        barChart()
    }

    private fun searchSubmit(country: String) {
        binding!!.apply {
            visibility(true)
            if(country.isEmpty() || DataManger.getCountry(country.lowercase().trim())
                        [country.lowercase().trim()].isNullOrEmpty()) {
                lottieError.visibility = View.VISIBLE
                visibility(false)
            }else {
                setData(country)
                visibility(true)
            }
            lottieSearch.isVisible = false
        }
    }

    private fun searchTextChange(newText: String){
        binding!!.apply {
            lottieError .visibility = View.GONE
            visibility(false)
            lottieSearch.isVisible = true
            barchart.isVisible = false
        }
    }
    fun setData(country: String){
        TODO()
    }

//    private fun setData(country: String) {
//        DataManger.getCountry(country).forEach { dataCountry ->
//            val data = dataCountry.value[dataCountry.value.size-1]
//            binding!!.apply {
//                txtPeopleVaccine.text = data.people_vaccinated.toInt().toString()
//                txtPeopleFullyVaccine.text = data.people_fully_vaccinated.toInt().toString()
//                txtCountryName.text = data.country
//                txtIsoCode.text = data.iso_code
//                txtTotalVaccinations.text = data.total_vaccinations.toInt().toString()
//
//                pieChart.addPieSlice(PieModel("total_vaccinations", data.total_vaccinations_per_hundred.toFloat(), Color.parseColor("#FF0000")))
//                pieChart.addPieSlice(PieModel("people_vaccinated", data.people_vaccinated_per_hundred.toFloat(), Color.parseColor("#00FF00")))
//                pieChart.addPieSlice(PieModel("people_fully_vaccinated", data.people_fully_vaccinated_per_hundred.toFloat(), Color.parseColor("#0000FF")))
//
//                pieChart.startAnimation()
//            }
//        }
//    }

    fun barChart(){

        val mBarChart =binding!!.barchart

        mBarChart.addBar(BarModel(2.3f, -0xedcbaa))
        mBarChart.addBar(BarModel(2f, -0xcbcbaa))
        mBarChart.addBar(BarModel(3.3f, -0xa9cbaa))
        mBarChart.addBar(BarModel(1.1f, -0x78c0aa))
        mBarChart.addBar(BarModel(2.7f, -0xa9480f))
        mBarChart.addBar(BarModel(2f, -0xcbcbaa))
        mBarChart.addBar(BarModel(0.4f, -0xe00b54))
        mBarChart.addBar(BarModel(4f, -0xe45b1a))

        mBarChart.startAnimation()
    }

    override fun addCallBack() {
        visibility(false)
    }

    fun visibility(state: Boolean){
        binding!!.apply {
            cardCountry.isVisible = state
            lottieSearch.isVisible = !state
            barchart.isVisible = state
        }
    }


}