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
        barChartDataSet()
        chartDataSet(DataManger.getDailyVaccine("china"),"china")
    }

    private fun chartDataSet(data: MutableList<Double>, country:String){
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

//    private fun barChartDataSet(){
//        val country = DataManger.countryTopTen
//        val data = DataManger.getDailyVaccine(country[0])
//        val data1 = DataManger.getDailyVaccine(country[1])
//        val data2 = DataManger.getDailyVaccine(country[2])
//        val data3 = DataManger.getDailyVaccine(country[3])
//        val data4 = DataManger.getDailyVaccine(country[4])
//        val data5 = DataManger.getDailyVaccine(country[5])
//        val data6 = DataManger.getDailyVaccine(country[6])
//        val data7 = DataManger.getDailyVaccine(country[7])
//        val data8 = DataManger.getDailyVaccine(country[8])
//        val data9 = DataManger.getDailyVaccine(country[9])
//        val aaChartView = binding?.barChart
//        val aaChartModel : AAChartModel = AAChartModel()
//            .chartType(AAChartType.Bar)
//            .backgroundColor(resources.getColor(R.color.white))
//            .yAxisTitle("vaccination")
//            .yAxisLabelsEnabled(false)
//            .categories(arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"))
//            .series(arrayOf(
//                AASeriesElement()
//                    .name(country[0])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data[1], data[data.size-125], data[data.size-110], data[data.size-90], data[data.size-75], data[data.size-40], data[data.size-20], data[data.size-1])),
//                AASeriesElement()
//                    .name(country[1])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data1[1], data1[data1.size-125], data1[data1.size-110], data1[data1.size-90], data1[data1.size-75], data1[data1.size-40], data1[data1.size-20], data1[data1.size-1])),
//                AASeriesElement()
//                    .name(country[2])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data2[1], data2[data2.size-125], data2[data2.size-110], data2[data2.size-90], data2[data2.size-75], data2[data2.size-40], data2[data2.size-20], data2[data2.size-1])),
//                AASeriesElement()
//                    .name(country[3])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data3[1], data3[data3.size-125], data3[data3.size-110], data3[data3.size-90], data3[data3.size-75], data3[data3.size-40], data3[data3.size-20], data3[data3.size-1])),
//                AASeriesElement()
//                    .name(country[4])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data4[1], data4[data4.size-125], data4[data4.size-110], data4[data4.size-90], data4[data4.size-75], data4[data4.size-40], data4[data4.size-20], data4[data4.size-1])),
//                AASeriesElement()
//                    .name(country[5])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data5[1], data5[data5.size-125], data5[data5.size-110], data5[data5.size-90], data5[data5.size-75], data5[data5.size-40], data5[data5.size-20], data5[data5.size-1])),
//                AASeriesElement()
//                    .name(country[6])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data6[1], data6[data6.size-125], data6[data6.size-110], data6[data6.size-90], data6[data6.size-75], data6[data6.size-40], data6[data6.size-20], data6[data6.size-1])),
//                AASeriesElement()
//                    .name(country[7])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data7[1], data7[data7.size-125], data7[data7.size-110], data7[data7.size-90], data7[data7.size-75], data7[data7.size-40], data7[data7.size-20], data7[data7.size-1])),
//                AASeriesElement()
//                    .name(country[8])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data8[1], data8[data8.size-125], data8[data8.size-110], data8[data8.size-90], data8[data8.size-75], data8[data8.size-40], data8[data8.size-20], data8[data8.size-1])),
//                AASeriesElement()
//                    .name(country[9])
//                    .enableMouseTracking(true)
//                    .data(arrayOf(data9[1], data9[data9.size-125], data9[data9.size-110], data9[data9.size-90], data9[data9.size-75], data9[data9.size-40], data9[data9.size-20], data9[data9.size-1])),
//
//            )
//            )
//            .animationDuration(3000)
//        aaChartView?.aa_drawChartWithChartModel(aaChartModel)
//        aaChartView?.aa_updateChartWithOptions(aaChartModel,true)
//
//    }

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
