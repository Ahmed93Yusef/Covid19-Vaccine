package com.example.covid19_vaccine.ui.fragment


import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.FragmentVaccineTypeBinding

class VaccineTypeFragment : BaseFragment<FragmentVaccineTypeBinding>(){
    override val bindingInflater: (LayoutInflater) -> FragmentVaccineTypeBinding = FragmentVaccineTypeBinding::inflate

    override fun setup() {}

    override fun addCallBack() {
        binding?.apply {
            VizorType1.setOnClickListener {  }
            sputnikType2.setOnClickListener {  }
            astaType3.setOnClickListener {  }
            modernaType4.setOnClickListener {  }
            novavaxType5.setOnClickListener {  }
            jhonsonType6.setOnClickListener {  }
            senphormType7.setOnClickListener {  }
        }
    }
//    fun expandedCard(linear: LinearLayout, buttonShowExpanded: ImageView, image: CardView) {
//        binding!!.apply {
//            buttonShowExpanded.setOnClickListener {
//                if (linear.visibility == View.GONE) {
//                    TransitionManager.beginDelayedTransition(image, AutoTransition())
//                    linear.visibility = View.VISIBLE
//                    buttonShowExpanded.setImageResource(R.drawable.arrow_up)
//
//                } else {
//                    TransitionManager.beginDelayedTransition(image, AutoTransition())
//                    linear.visibility = View.GONE
//                    buttonShowExpanded.setImageResource(R.drawable.arrow_down)
//                }
//            }
//        }
//    }


}
