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
    

    private fun setData(country: String) {
        DataManger.getCountry(country).forEach { dataCountry ->
            val data = dataCountry.value[dataCountry.value.size-1]
            binding!!.apply {
                txtPeopleVaccine.text = data.people_vaccinated.toInt().toString()
                txtPeopleFullyVaccine.text = data.people_fully_vaccinated.toInt().toString()
                txtCountryName.text = data.country


                barchart.clearChart() /// Clear chart before new search


                barchart.addBar(BarModel(data.people_fully_vaccinated.toFloat(), -0xedcbaa , ))
                barchart.addBar(BarModel(data.people_vaccinated.toFloat(), -0xcbcbaa))
                barchart.addBar(BarModel(data.people_vaccinated_per_hundred.toFloat(), -0xa9cbaa))
                barchart.addBar(BarModel(data.people_fully_vaccinated_per_hundred.toFloat(), -0x78c0aa))
                barchart.addBar(BarModel(data.daily_vaccinations.toFloat(), -0xa9480f))
                barchart.addBar(BarModel(data.daily_vaccinations_per_million.toFloat(), -0xcbcbaa))

                barchart.startAnimation()


            }
        }
    }


    override fun addCallBack() {
        visibility(false)
        DataManger.totalVaccination(binding?.inputCountryText.toString())
    }

    fun visibility(state: Boolean){
        binding!!.apply {
            cardCountry.isVisible = state
            lottieSearch.isVisible = !state
            barchart.isVisible = state
        }
    }


}