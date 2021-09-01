package com.example.covid19_vaccine.ui.fragment

import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.FragmentStatisticBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import java.util.ArrayList


class StatisticFragment: BaseFragment<FragmentStatisticBinding>(){
    override val bindingInflater: (LayoutInflater) -> FragmentStatisticBinding = FragmentStatisticBinding::inflate

    override fun setup() {

        DataManger.initCountryList()
        val topTeenCountry = DataManger.getTopTen()
        binding?.apply {
            country1Name.text = topTeenCountry[0].country
            country2Name.text = topTeenCountry[1].country
            country3Name.text = topTeenCountry[2].country
            country4Name.text = topTeenCountry[3].country
            country5Name.text = topTeenCountry[4].country

            country1VaccineTotal.text = DataManger.convertNumber(topTeenCountry[0].people_fully_vaccinated)
            country2VaccineTotal.text = DataManger.convertNumber(topTeenCountry[1].people_fully_vaccinated)
            country3VaccineTotal.text = DataManger.convertNumber(topTeenCountry[2].people_fully_vaccinated)
            country4VaccineTotal.text = DataManger.convertNumber(topTeenCountry[3].people_fully_vaccinated)
            country5VaccineTotal.text = DataManger.convertNumber(topTeenCountry[4].people_fully_vaccinated)

            country1VaccinePer.text = topTeenCountry[0].people_fully_vaccinated_per_hundred.toString()
            country2VaccinePer.text = topTeenCountry[1].people_fully_vaccinated_per_hundred.toString()
            country3VaccinePer.text = topTeenCountry[2].people_fully_vaccinated_per_hundred.toString()
            country4VaccinePer.text = topTeenCountry[3].people_fully_vaccinated_per_hundred.toString()
            country5VaccinePer.text = topTeenCountry[4].people_fully_vaccinated_per_hundred.toString()

            setLineChartData()
        }
    }

    override fun addCallBack() {


    }


    fun dataValues1() : ArrayList<Entry>
    {
        val dataVal = ArrayList<Entry>()
        dataVal.add(Entry(0F, 20F))
        dataVal.add(Entry(1F, 24F))
        dataVal.add(Entry(2F, 2F))
        dataVal.add(Entry(3F, 10F))
        return dataVal
    }

    fun setLineChartData()
    {
        val mpLineChart = binding?.lineChart!!

        val lineDataSet1 = LineDataSet(dataValues1(), "Data Set 1")
        lineDataSet1.lineWidth = 4f
        lineDataSet1.color = Color.parseColor("#00FFFF")
        lineDataSet1.setDrawCircles(true)
        lineDataSet1.setDrawCircleHole(false)
        lineDataSet1.setCircleColor(Color.parseColor("#00FFFF"))
        lineDataSet1.circleHoleColor = Color.parseColor("#00FFFF")
        lineDataSet1.circleHoleRadius = 5f
        lineDataSet1.circleRadius = 7f
        lineDataSet1.valueTextSize = 12f
        lineDataSet1.valueTextColor = Color.parseColor("#00FFFF")

        val xAxis = mpLineChart.xAxis
        xAxis.valueFormatter = CustomFormat(axis)

        val dataSets : ArrayList<ILineDataSet> = ArrayList()

        dataSets.add(lineDataSet1)

        val data = LineData(dataSets)

        data.setValueFormatter(CustomFormat(axis))

        mpLineChart.data = data
        mpLineChart.invalidate()
//        mpLineChart?.setBackgroundColor(Color.parseColor("#ff00ff"))
        mpLineChart.setDrawGridBackground(true)
        mpLineChart.setDrawBorders(true)
//        mpLineChart.setBorderColor(Color.parseColor("#ff00ff"))
        mpLineChart.setBorderWidth(2f)

        val legend = mpLineChart.legend
        legend.isEnabled = true
        legend.textColor = Color.parseColor("#431678")
        legend.textSize = 14F
        legend.form = Legend.LegendForm.CIRCLE
        legend.formSize = 10f
        legend.xEntrySpace = 10f
        legend.formToTextSpace = 10f

        setvlaue
//        val xvalue = ArrayList<String>()
//        xvalue.add("11.00 AM")
//        xvalue.add("12.00 AM")
//        xvalue.add("1.00 AM")
//        xvalue.add("3.00 PM")
//        xvalue.add("7.00 PM")
//
//
//
//        val lineentry = ArrayList<Entry>();
//        lineentry.add(Entry(20f,0f))
//        lineentry.add(Entry(50f,1f))
//        lineentry.add(Entry(60f,2f))
//        lineentry.add(Entry(30f,3f))
//        lineentry.add(Entry(10f,4f))
//
//
//
//
//        val linedataset = LineDataSet(lineentry, "first")
//        linedataset.color = resources.getColor(R.color.cardview_shadow_start_color)
//
//
//
//        val data = LineData()

    }

    val axis = arrayOf<String>("22/8" , "23/8" , "29/8" , "03/9" , "09/9" , "15/9")

    private var setvlaue = mutableListOf<String>("22/8", "31/7", "20/9")


    private class CustomFormat(var ax: Array<String>) : IndexAxisValueFormatter() {
        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            return ax[value.toInt()]
        }
    }

    private class setAxisValue() : IndexAxisValueFormatter()
    {

    }
}
