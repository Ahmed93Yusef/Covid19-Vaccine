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

    override fun setup() {
    }

    override fun addCallBack() {
//        binding?.let {
//            expandedCard(it.expandedLinear1, binding!!.showExpandedLinear1, binding!!.cardView1)
//            expandedCard(it.expandedLinear2, binding!!.showExpandedLinear2, binding!!.cardView2)
//            expandedCard(it.expandedLinear3, binding!!.showExpandedLinear3, binding!!.cardView3)
//            expandedCard(it.expandedLinear4, binding!!.showExpandedLinear4, binding!!.cardView4)
//            expandedCard(it.expandedLinear5, binding!!.showExpandedLinear5, binding!!.cardView5)
//            expandedCard(it.expandedLinear6, binding!!.showExpandedLinear6, binding!!.cardView6)
//            expandedCard(it.expandedLinear7, binding!!.showExpandedLinear7, binding!!.cardView7)
//        }
    }
    fun expandedCard(linear: LinearLayout, buttonShowExpanded: ImageView, image: CardView) {
        binding!!.apply {

            buttonShowExpanded.setOnClickListener {
                if (linear.visibility == View.GONE) {
                    TransitionManager.beginDelayedTransition(image, AutoTransition())
                    linear.visibility = View.VISIBLE
                    buttonShowExpanded.setImageResource(R.drawable.arrow_up)

                } else {
                    TransitionManager.beginDelayedTransition(image, AutoTransition())
                    linear.visibility = View.GONE
                    buttonShowExpanded.setImageResource(R.drawable.arrow_down)
                }
            }

        }
    }


}
