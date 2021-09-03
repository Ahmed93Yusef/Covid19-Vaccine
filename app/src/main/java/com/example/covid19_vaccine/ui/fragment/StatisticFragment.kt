package com.example.covid19_vaccine.ui.fragment

import StatisticsAdapter
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
//        chartDataSet(DataManger.getDailyVaccine("Iraq"),"Iraq")
    }

    private fun chartDataSet(data: MutableList<Double>, country:String){
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

    override fun onClickCountryItem(Position: Int) {

        when(Position){
            0 -> { chartDataSet(DataManger.getDailyVaccine("china"),"china")
                adapter.notifyItemChanged(Position) }
            1 -> {
                chartDataSet(DataManger.getDailyVaccine("india"),"india")
                adapter.notifyItemChanged(Position) }
            2 -> {chartDataSet(DataManger.getDailyVaccine("united states"),"united states")
                adapter.notifyItemChanged(Position) }
            3 -> { chartDataSet(DataManger.getDailyVaccine("brazil"),"brazil")
                adapter.notifyItemChanged(Position)}
            4 -> { chartDataSet(DataManger.getDailyVaccine("japan"),"japan")
                adapter.notifyItemChanged(Position) }
            5 -> {
                chartDataSet(DataManger.getDailyVaccine("indonesia"),"indonesia")
                adapter.notifyItemChanged(Position) }
            6 -> {chartDataSet(DataManger.getDailyVaccine("mexico"),"mexico")
                adapter.notifyItemChanged(Position) }
            7 -> { chartDataSet(DataManger.getDailyVaccine("germany"),"germany")
                adapter.notifyItemChanged(Position)}
            8 -> { chartDataSet(DataManger.getDailyVaccine("united kingdom"),"united kingdom")
                adapter.notifyItemChanged(Position) }
            9 -> { chartDataSet(DataManger.getDailyVaccine("france"),"france")
                adapter.notifyItemChanged(Position) }
        }
    }}
