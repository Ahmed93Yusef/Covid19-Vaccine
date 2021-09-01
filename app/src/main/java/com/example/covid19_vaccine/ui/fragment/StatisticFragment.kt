package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import com.example.covid19_vaccine.databinding.FragmentStatisticBinding


class StatisticFragment: BaseFragment<FragmentStatisticBinding>(){
    override val bindingInflater: (LayoutInflater) -> FragmentStatisticBinding
        get() = TODO("Not yet implemented")

    override fun setup() {
        TODO("Not yet implemented")
    }

    override fun addCallBack() {
        TODO("Not yet implemented")
    }

}
//    override val bindingInflater: (LayoutInflater) -> FragmentStatisticBinding = FragmentStatisticBinding::inflate
//    override fun setup() {
////        DataManger.initCountryList()
////        val topTenCountry = DataManger.getTopTen()
////        binding?.apply {
////            country1Name.text = topTenCountry[0].country
////            country2Name.text = topTenCountry[1].country
////            country3Name.text = topTenCountry[2].country
////            country4Name.text = topTenCountry[3].country
////            country5Name.text = topTenCountry[4].country
////
////            country1VaccineTotal.text = DataManger.convertNumber(topTenCountry[0].people_fully_vaccinated)
////            country2VaccineTotal.text = DataManger.convertNumber(topTenCountry[1].people_fully_vaccinated)
////            country3VaccineTotal.text = DataManger.convertNumber(topTenCountry[2].people_fully_vaccinated)
////            country4VaccineTotal.text = DataManger.convertNumber(topTenCountry[3].people_fully_vaccinated)
////            country5VaccineTotal.text = DataManger.convertNumber(topTenCountry[4].people_fully_vaccinated)
////
////            "${topTenCountry[0].people_fully_vaccinated_per_hundred.toString()} %".also { country1VaccinePer.text = it }
////            "${topTenCountry[1].people_fully_vaccinated_per_hundred.toString()} %".also { country2VaccinePer.text = it }
////            "${topTenCountry[2].people_fully_vaccinated_per_hundred.toString()} %".also { country3VaccinePer.text = it }
////            "${topTenCountry[3].people_fully_vaccinated_per_hundred.toString()} %".also { country4VaccinePer.text = it }
////            "${topTenCountry[4].people_fully_vaccinated_per_hundred.toString()} %".also { country5VaccinePer.text = it }
//
//            setLineChartData()
//        }
//
//    override fun addCallBack() {
//        TODO("Not yet implemented")
//    }
//}
//    override fun addCallBack() {}
//    private fun dataValues1() : ArrayList<Entry>
//    {
//        val dataVal = ArrayList<Entry>()
//        dataVal.add(Entry(0F, 20F))
//        dataVal.add(Entry(1F, 24F))
//        dataVal.add(Entry(2F, 2F))
//        dataVal.add(Entry(3F, 10F))
//        return dataVal
//    }
//    private fun setLineChartData()
//    {
//        val mpLineChart = binding?.lineChart!!
//
//        val lineDataSet1 = LineDataSet(dataValues1(), "Data Set 1")
//        lineDataSet1.apply {
//            lineWidth = 4f
//            color = Color.parseColor("#00FFFF")
//            setDrawCircles(true)
//            setDrawCircleHole(false)
//            setCircleColor(Color.parseColor("#00FFFF"))
//            circleHoleColor = Color.parseColor("#00FFFF")
//            circleHoleRadius = 5f
//            circleRadius = 7f
//            valueTextSize = 12f
//            valueTextColor = Color.parseColor("#00FFFF")
//        }
//        val xAxis = mpLineChart.xAxis
//        xAxis.valueFormatter = CustomFormat(axis)
//        val dataSets : ArrayList<ILineDataSet> = ArrayList()
//        dataSets.add(lineDataSet1)
//        val data = LineData(dataSets)
//        data.setValueFormatter(CustomFormat(axis))
//        mpLineChart.data = data
//        mpLineChart.invalidate()
//        mpLineChart.setDrawGridBackground(true)
//        mpLineChart.setDrawBorders(true)
//        mpLineChart.setBorderWidth(2f)
//        val legend = mpLineChart.legend
//        legend.isEnabled = true
//        legend.textColor = Color.parseColor("#431678")
//        legend.textSize = 14F
//        legend.form = Legend.LegendForm.CIRCLE
//        legend.formSize = 10f
//        legend.xEntrySpace = 10f
//        legend.formToTextSpace = 10f
//        setvlaue
//    }
//    val axis = arrayOf<String>("22/8" , "23/8" , "29/8" , "03/9" , "09/9" , "15/9")
//    private var setvlaue = mutableListOf<String>("22/8", "31/7", "20/9")
//    private class CustomFormat(var ax: Array<String>) : IndexAxisValueFormatter() {
//        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
//            return ax[value.toInt()]
//        }
//    }

