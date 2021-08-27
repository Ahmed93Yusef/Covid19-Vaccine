package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.ViewFlipper
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.VaccineDataRecyclerView
import com.example.covid19_vaccine.data.domain.VaccineRecyclerView
import com.example.covid19_vaccine.databinding.FragmentHomeBinding
import com.example.covid19_vaccine.util.VaccineInteraction
import com.example.covid19_vaccine.util.VaccineAdapter

class HomeFragment: BaseFragment<FragmentHomeBinding>(), VaccineInteraction {

    private lateinit var imagePreventFlipper: ViewFlipper


    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun setup() {
        imageFlipper()
        val adapter = VaccineAdapter(VaccineDataRecyclerView.listData,this)
        binding?.vaccineRecyclerView?.adapter = adapter
    }

    override fun addCallBack() {
    }

    private fun imageFlipper(){
        val image = arrayListOf(
            R.drawable.back,
            R.drawable.back1,
            R.drawable.back2,
            R.drawable.back3,
        )
        imagePreventFlipper = binding!!.viewFlipper
        for (i in image.iterator()){
            flipperImage(i)
        }
    } //Data Image for ImageFlipper

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

    override fun onClickItem(vaccineView: VaccineRecyclerView) {
    }

    override fun onClickServiceName(name: String) {
    } //this function override from InterFace "Interaction VaccineAdapter" to add listener when user click on name Vaccine on RecyclerView

    override fun onClickServiceImage(image: Int) {}


}
