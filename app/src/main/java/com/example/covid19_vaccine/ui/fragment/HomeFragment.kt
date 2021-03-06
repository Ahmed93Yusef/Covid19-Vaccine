package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.data.VaccineDataRecyclerView
import com.example.covid19_vaccine.databinding.FragmentHomeBinding
import com.example.covid19_vaccine.util.VaccineAdapter
import com.example.covid19_vaccine.util.VaccineInteraction

class HomeFragment: BaseFragment<FragmentHomeBinding>(), VaccineInteraction {
    private val myVaccineTypeFragment = VaccineTypeFragment()
    private val myDetailsButtonFragment = DetailsButtonFragment()
    private val myHomeTestFragment = HomeTestFragment()
    private var myCovidPreventFragment = CovidPreventFragment()
    lateinit var adapter: VaccineAdapter
    private lateinit var imagePreventFlipper: ViewFlipper
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding = FragmentHomeBinding::inflate
    override fun setup() {
        imageFlipper()
        adapter = VaccineAdapter(VaccineDataRecyclerView.listData,this) //Call the Recycle View to shown it
        binding?.vaccineRecyclerView?.adapter = adapter
        iraqData()
    }
    override fun addCallBack() {
        binding?.cardView?.setOnClickListener {
            replaceFragment(myDetailsButtonFragment)
        }
    }
    private fun imageFlipper(){
        val image = arrayListOf(
            R.drawable.whatthevaccine,
            R.drawable.whyshouldwetake,
            R.drawable.why_shot,
        )
        imagePreventFlipper = requireNotNull(binding?.viewFlipper)
        for (i in image.iterator()){
            flipperImage(i)
        }
    } //Data Image provide to ImageFlipper
    private fun flipperImage(image : Int){
        val imageView = ImageView(context)
        imageView.setBackgroundResource(image)
        imagePreventFlipper.apply {
            addView(imageView)
            flipInterval = 4000
            isAutoStart=true
            setInAnimation(context,android.R.anim.slide_in_left)
            setOutAnimation(context,android.R.anim.slide_out_right)
        }
    }  //This Function using to add flipper image to cardView in the Home Screen
    private fun replaceFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragment_container, fragment)?.addToBackStack(null)
        transaction?.commit()
    }
    /*this functions @Override from the "TransFragment" interface to make the trans easy to use.
     ++ the functionality of it to replace the fragment to another fragment user want to go to it*/
    override fun onClickServiceItem(Position: Int) {
        when(Position){
            0 -> {
                Toast.makeText(context,"Under Maintenance" , Toast.LENGTH_SHORT).show()
                adapter.notifyItemChanged(Position) }
            1 -> {
                replaceFragment(myVaccineTypeFragment)
                adapter.notifyItemChanged(Position) }
            2 -> {
                replaceFragment(myHomeTestFragment) }
            3 -> {
                replaceFragment(myCovidPreventFragment)
                 }
        }
    } // this function using for transition to Fragments depend on the type of services user selected , and working by Positions
    private fun iraqData(){
        DataManger.getCountry("iraq").forEach { dataCountry ->
            val data = dataCountry.value[dataCountry.value.size-1]
            binding?.apply {
                homeScreenTotal.text = DataManger.convertNumber(data.total_vaccinated)
                homeScreenDaily.text = DataManger.convertNumber(data.daily_vaccinations)
            }
        }
    } // this function provide Iraq data to shown it in homeScreen
}
