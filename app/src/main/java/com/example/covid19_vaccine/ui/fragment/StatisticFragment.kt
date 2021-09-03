package com.example.covid19_vaccine.ui.fragment

import StatisticsAdapter
import android.provider.ContactsContract
import android.view.LayoutInflater
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.data.domain.VaccineData
import com.example.covid19_vaccine.databinding.FragmentStatisticBinding
import com.example.covid19_vaccine.util.CountryInterAction
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement

class StatisticFragment: BaseFragment<FragmentStatisticBinding>(),CountryInterAction {

    private lateinit var adapter: StatisticsAdapter

    lateinit var topTeenCountry : List<VaccineData>
    override val bindingInflater: (LayoutInflater) -> FragmentStatisticBinding = FragmentStatisticBinding::inflate

    override fun setup() {

        topTeenCountry = DataManger.getTopTen()
        adapter = StatisticsAdapter(topTeenCountry,this)
        binding?.dataTopRecyclerView?.adapter = adapter
    }

    override fun addCallBack() {
        barChartDataSet()
        chartDataSet(DataManger.getDailyVaccine("china"))
    }

    private fun chartDataSet(data: MutableList<Double>){
        val aaChartView = binding?.lineChart
        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Area)
            .backgroundColor(resources.getColor(R.color.white))
            .dataLabelsEnabled(true)
            .yAxisTitle("vaccination")
            .yAxisLabelsEnabled(false)
            .legendEnabled(false)
            .categories(arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"))
            .series(arrayOf(
                AASeriesElement()
                    .enableMouseTracking(true)
                    .data(arrayOf(data[1], data[data.size-125], data[data.size-110], data[data.size-90], data[data.size-75], data[data.size-40], data[data.size-20], data[data.size-1])),
            )
            )
            .animationDuration(3000)
        aaChartView?.aa_drawChartWithChartModel(aaChartModel)
        aaChartView?.aa_updateChartWithOptions(aaChartModel,true)

    }
    private fun barChartDataSet(){
        val country = DataManger.countryTopTen
        val data = DataManger.getVaccineTotally()
        val aaChartView = binding?.barChart
        val aaChartModel : AAChartModel = AAChartModel()
            .chartType(AAChartType.Bar)
            .backgroundColor(resources.getColor(R.color.white))
            .yAxisTitle("vaccination")
            .legendEnabled(false)
            .yAxisLabelsEnabled(true)
            .xAxisLabelsEnabled(true)
            .categories(country.toTypedArray())
            .series(arrayOf(
                AASeriesElement()
                    .enableMouseTracking(true)
                    .data(data.toTypedArray())

            ))
            .animationDuration(3000)
        aaChartView?.aa_drawChartWithChartModel(aaChartModel)
        aaChartView?.aa_updateChartWithOptions(aaChartModel,true)

    }

    override fun onClickCountryItem(Position: Int) {
        val data = DataManger.countryTopTen
        for (i in 0 until data.size) {
            if (Position == i)
            {
                chartDataSet(DataManger.getDailyVaccine(data[Position]))
                adapter.notifyItemChanged(Position)
            }
        }
    }
}
