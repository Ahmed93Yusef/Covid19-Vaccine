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
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun setup() {
        imageFlipper()
        val adapter = VaccineAdapter()
        vaccineRecyclerView.adapter = adapter
    }

    override fun addCallBack() {
//        showExpandedCard()

    }

//    fun showExpandedCard() { ////Expand card view th Show Vaccine details.
//
//        binding!!.ShowMore.setOnClickListener{
//            if (expandLayout.visibility == View.GONE)
//            {
//                imageViewShowMore.setImageResource(R.drawable.arrow_up)
//                TransitionManager.beginDelayedTransition(cardview , AutoTransition())
//                expandLayout.visibility = View.VISIBLE
//            }
//            else{
//                TransitionManager.beginDelayedTransition(cardview , AutoTransition())
//                expandLayout.visibility = View.GONE
//                imageViewShowMore.setImageResource(R.drawable.arrow_down)
//            }
//
//
//        }
//
//
//    }

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
