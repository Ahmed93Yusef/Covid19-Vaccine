package com.example.covid19_vaccine.ui
import android.view.LayoutInflater
import com.example.covid19_vaccine.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity: BaseActivity<ActivityMainBinding>() {
    override val LOG_TAG: String = "MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    override fun setup() {
        openFile()
    }
    override fun addCallbacks() {

    }

    private fun openFile() {
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine {
            log(it)
        }
    }



}