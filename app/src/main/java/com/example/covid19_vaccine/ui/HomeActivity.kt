package com.example.covid19_vaccine.ui
import android.os.Bundle
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.ActivityHomeBinding
import com.example.covid19_vaccine.ui.fragment.*
import com.example.covid19_vaccine.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeActivity: AppCompatActivity() {
    var binding : ActivityHomeBinding? = null

    private val myHomeFragment = HomeFragment()
    private val mySearchFragment = SearchFragment()
    private val myStatisticFragment = StatisticFragment()
    private val myAboutFragment = AboutFragment()
    private val myVaccineType = VaccineTypeFragment()
    private val myDetailsButtonFragment = DetailsButtonFragment()
    lateinit var viewC : CardView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(requireNotNull(binding).root)
        setTheme(R.style.Theme_Covid19_vaccine)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN) //this set using for hiding the statistbar

        setup()
        addCallbacks()
    }

    private fun setup() {
        initSubView()
        parseFile()
    }

    private fun addCallbacks() {
        selectFragment()


    }

    private fun selectFragment(){

        binding?.bottomNavigationView?.setOnItemSelectedListener {
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
      fun removeFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.remove(fragment)
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
