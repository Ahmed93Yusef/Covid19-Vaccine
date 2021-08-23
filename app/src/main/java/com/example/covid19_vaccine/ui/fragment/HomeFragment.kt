package com.example.covid19_vaccine.ui.fragment

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.FragmentHomeBinding
import com.example.covid19_vaccine.util.VaccineAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment<FragmentHomeBinding>() {

    lateinit var expandLayout : LinearLayout
    lateinit var cardview : CardView
    lateinit var imageViewShowMore: ImageView
    lateinit var textViewShowless : TextView
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding = FragmentHomeBinding::inflate

    override fun setup() {
        binding?.apply {
            expandLayout = binding!!.linearExpanded
            imageViewShowMore = binding!!.ShowMore
            cardview = binding!!.cardRight
        }
        val adapter = VaccineAdapter()
        recycler_Vaccine.adapter = adapter
    }

    override fun addCallBack() {
        showExpandedCard()

    }
    fun showExpandedCard() { ////Expand card view th Show Vaccine details.

        binding!!.ShowMore.setOnClickListener{
            if (expandLayout.visibility == View.GONE)
            {
                imageViewShowMore.setImageResource(R.drawable.arrow_up)
                TransitionManager.beginDelayedTransition(cardview , AutoTransition())
                expandLayout.visibility = View.VISIBLE
            }
            else{
                TransitionManager.beginDelayedTransition(cardview , AutoTransition())
                expandLayout.visibility = View.GONE
                imageViewShowMore.setImageResource(R.drawable.arrow_down)
            }


        }


    }




}
