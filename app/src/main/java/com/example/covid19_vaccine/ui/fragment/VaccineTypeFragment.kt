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
        binding?.let {
            expandedCard(it.expandedLinear1, it.showExpandedLinear1, it.cardView1)
            expandedCard(it.expandedLinear2, it.showExpandedLinear2, it.cardView2)
            expandedCard(it.expandedLinear3, it.showExpandedLinear3, it.cardView3)
            expandedCard(it.expandedLinear4, it.showExpandedLinear4, it.cardView4)
            expandedCard(it.expandedLinear5, it.showExpandedLinear5, it.cardView5)
            expandedCard(it.expandedLinear6, it.showExpandedLinear6, it.cardView6)
            expandedCard(it.expandedLinear7, it.showExpandedLinear7, it.cardView7)
        }
    }
    fun expandedCard(linear: LinearLayout, buttonShowExpanded: ImageView, image: CardView) {
        binding?.apply {

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

