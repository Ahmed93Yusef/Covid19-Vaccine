package com.example.covid19_vaccine.ui
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import android.widget.*
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

    lateinit var expandLayout : LinearLayout
    lateinit var cardview : CardView
    lateinit var textViewShowMore: TextView
    lateinit var textViewShowless : TextView


    lateinit var imagePreventFlipper: ViewFlipper

    var binding : ActivityHomeBinding? = null


    private val myDetailsButtonFragment = DetailsButtonFragment()
    private val myHomeFragment = HomeFragment()
    private val mySearchFragment = SearchFragment()
    private val myStatisticFragment = StatisticFragment()
    private val myAboutFragment = AboutFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(requireNotNull(binding).root)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)

        setup()
        addCallbacks()


    }
    private fun setup() {

        initSubView()
        parseFile()

    }

    private fun addCallbacks() {
        initSubView()
        selectFragment()
    }

    private fun selectFragment(){

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

    fun addFragment(fragment: Fragment) {
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



    //Image Flipper
    private fun imageFlipper(){
        val image = arrayListOf<Int>(
            //List of Image Of Prevent
        )

//        imagePreventFlipper = findViewById(R.id.imagePreventFlipper)

        for (i in image.iterator()){
            flipeerImage(i)
        }
    }

    fun flipeerImage(image : Int){
        val imageView = ImageView(this)
        imageView.setBackgroundResource(image)
        imagePreventFlipper.addView(imageView)
        imagePreventFlipper.flipInterval = 4000
        imagePreventFlipper.isAutoStart=true

        imagePreventFlipper.setInAnimation(this,android.R.anim.slide_in_left)
        imagePreventFlipper.setOutAnimation(this,android.R.anim.slide_out_right)

    }

    fun button(view: View) {

        view.findViewById<Button>(R.id.buttonDetails).setOnClickListener {


            replaceFragment(myDetailsButtonFragment)

        }

    }

    fun showVaccineType(view: View) {



    }


}
