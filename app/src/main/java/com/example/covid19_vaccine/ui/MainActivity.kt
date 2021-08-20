package com.example.covid19_vaccine.ui
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.ActivityMainBinding
import com.example.covid19_vaccine.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity: BaseActivity<ActivityMainBinding>() {

    private val myHomeFragment = HomeFragment()
    private val mySearchFragment = SearchFragment()
    private val myStatisticFragment = StatisticFragment()
    private val myAboutFragment = AboutFragment()
    override val LOG_TAG: String = "MAIN_ACTIVITY"
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate

    override fun setup() {
        parseFile()
        DataManger.countryFun("Algeria")
        DataManger.countryMap("Andorra")
        DataManger.group("Andorra")

    }
    override fun addCallbacks() {
        initSubView()
        binding?.bottomNavigationView!!.setOnItemSelectedListener {
            item ->
            when(item.itemId){
                R.id.homePage -> {
                    replaceFragment(myHomeFragment)
                    true
                }
                R.id.searchPage -> {
                    replaceFragment(mySearchFragment)
                    true
                }
                R.id.statisticPage -> {
                    replaceFragment(myStatisticFragment)
                    true
                }
                R.id.aboutPage -> {
                    replaceFragment(myAboutFragment)
                    true
                }
                else -> false

            }
        }

    }

    private fun initSubView() {
        addFragment(HomeFragment())

    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()

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
