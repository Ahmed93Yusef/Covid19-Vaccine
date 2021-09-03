package com.example.covid19_vaccine.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.databinding.ActivityHomeBinding
import com.example.covid19_vaccine.ui.fragment.AboutFragment
import com.example.covid19_vaccine.ui.fragment.HomeFragment
import com.example.covid19_vaccine.ui.fragment.SearchFragment
import com.example.covid19_vaccine.ui.fragment.StatisticFragment
import com.example.covid19_vaccine.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeActivity: AppCompatActivity() {
    private var binding : ActivityHomeBinding? = null
    private val myHomeFragment = HomeFragment()
    private val mySearchFragment = SearchFragment()
    private val myAboutFragment = AboutFragment()
    private val myStatisticFragment = StatisticFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(requireNotNull(binding).root)
//        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN) //this function using for hiding the stats bar
        setup()
        addCallbacks()
    }
    private fun setup() {
        initSubView()
        parseFile()
        DataManger.initCountryList()
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
    } //this function Do : give each item in menu on the NavButton functionality to tran to the specific fragment
    private fun initSubView() {
        addFragment(HomeFragment()) //this function Do : to make the first Screen shown is the "HomeFragment".
    }
    private fun parseFile() {
        val inputStream = assets.open("country_vaccinations.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            val currentVaccine = parser.parse(it)
            DataManger.addVaccine(currentVaccine)
        }
    }/* this function Do to transfer data the csv provide it to File to make dail with it symbol
    ,then sprite the data to single line using @parse function then using it. */
    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, fragment)  
        transaction.commit()
    }// this function using for add fragment on another fragment when we want trans to another Screen.
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
           // .addToBackStack(null)
        transaction.commit()
    }// this function using for replace fragment to another fragment , so the above fragment is deleted.
}
