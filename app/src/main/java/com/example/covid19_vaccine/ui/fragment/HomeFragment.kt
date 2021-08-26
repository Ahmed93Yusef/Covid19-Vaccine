package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.ViewFlipper
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.FragmentHomeBinding
import com.example.covid19_vaccine.util.VaccineAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    private lateinit var imagePreventFlipper: ViewFlipper
    private val myDetailsButtonFragment = DetailsButtonFragment()


    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun setup() {
        imageFlipper()
        val adapter = VaccineAdapter()
        vaccineRecyclerView.adapter = adapter
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
    }
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
    }


}
