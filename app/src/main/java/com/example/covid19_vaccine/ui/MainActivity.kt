package com.example.covid19_vaccine.ui
import android.view.LayoutInflater
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.ActivityMainBinding
import com.example.covid19_vaccine.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity: BaseActivity<ActivityMainBinding>() {
    override val LOG_TAG: String = "MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    override fun setup() {
        parseFile()
    }
    override fun addCallbacks() {


    }

    private fun parseFile() {
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val currentVaccine = parser.parse(it)
            DataManger.addVaccine(currentVaccine)
        }
    }



}