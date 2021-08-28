package com.example.covid19_vaccine.ui.fragment

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.FragmentButtonDetailsBinding

class DetailsButtonFragment : BaseFragment<FragmentButtonDetailsBinding>(){
    override val bindingInflater: (LayoutInflater) -> FragmentButtonDetailsBinding = FragmentButtonDetailsBinding::inflate

    override fun setup() {

    }

    override fun addCallBack() {
        cardExpandedDetails()
    }

    fun cardExpandedDetails(){
        binding?.apply {
            expanededButton.setOnClickListener {
                if (whatTheVaccien.visibility == View.GONE){

                    if (
                        whatTheVaccien1.visibility == View.VISIBLE ||
                        whatTheVaccien2.visibility == View.VISIBLE ||
                        whatTheVaccien3.visibility == View.VISIBLE){

                        TransitionManager.beginDelayedTransition(lineraMain1, AutoTransition())
                        whatTheVaccien1.visibility = View.GONE
                        expanededButton1.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain2, AutoTransition())
                        whatTheVaccien2.visibility = View.GONE
                        expanededButton2.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain3, AutoTransition())
                        whatTheVaccien3.visibility = View.GONE
                        expanededButton3.setImageResource(R.drawable.circle_outline)
                    }
                    TransitionManager.beginDelayedTransition(lineraMain, AutoTransition())
                    whatTheVaccien.visibility = View.VISIBLE
                    expanededButton.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                }
                else{
                    TransitionManager.beginDelayedTransition(lineraMain, AutoTransition())
                    whatTheVaccien.visibility = View.GONE
                    expanededButton.setImageResource(R.drawable.circle_outline)
                }
            }
            expanededButton1.setOnClickListener {
                if (whatTheVaccien1.visibility == View.GONE){

                    if (
                        whatTheVaccien.visibility == View.VISIBLE ||
                        whatTheVaccien2.visibility == View.VISIBLE ||
                        whatTheVaccien3.visibility == View.VISIBLE){

                        TransitionManager.beginDelayedTransition(lineraMain, AutoTransition())
                        whatTheVaccien.visibility = View.GONE
                        expanededButton.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain2, AutoTransition())
                        whatTheVaccien2.visibility = View.GONE
                        expanededButton2.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain3, AutoTransition())
                        whatTheVaccien3.visibility = View.GONE
                        expanededButton3.setImageResource(R.drawable.circle_outline)
                    }

                    TransitionManager.beginDelayedTransition(lineraMain1, AutoTransition())
                    whatTheVaccien1.visibility = View.VISIBLE
                    expanededButton1.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                }
                else{
                    TransitionManager.beginDelayedTransition(lineraMain1, AutoTransition())
                    whatTheVaccien1.visibility = View.GONE
                    expanededButton1.setImageResource(R.drawable.circle_outline)
                }
            }
            expanededButton2.setOnClickListener {
                if (whatTheVaccien2.visibility == View.GONE){

                    if (
                        whatTheVaccien.visibility == View.VISIBLE ||
                        whatTheVaccien1.visibility == View.VISIBLE ||
                        whatTheVaccien3.visibility == View.VISIBLE){

                        TransitionManager.beginDelayedTransition(lineraMain, AutoTransition())
                        whatTheVaccien.visibility = View.GONE
                        expanededButton.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain1, AutoTransition())
                        whatTheVaccien1.visibility = View.GONE
                        expanededButton1.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain3, AutoTransition())
                        whatTheVaccien3.visibility = View.GONE
                        expanededButton3.setImageResource(R.drawable.circle_outline)
                    }

                    TransitionManager.beginDelayedTransition(lineraMain2, AutoTransition())
                    whatTheVaccien2.visibility = View.VISIBLE
                    expanededButton2.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                }
                else{
                    TransitionManager.beginDelayedTransition(lineraMain2, AutoTransition())
                    whatTheVaccien2.visibility = View.GONE
                    expanededButton2.setImageResource(R.drawable.circle_outline)
                }
            }
            expanededButton3.setOnClickListener {
                if (whatTheVaccien3.visibility == View.GONE){

                    if (
                        whatTheVaccien.visibility == View.VISIBLE ||
                        whatTheVaccien1.visibility == View.VISIBLE ||
                        whatTheVaccien2.visibility == View.VISIBLE){

                        TransitionManager.beginDelayedTransition(lineraMain, AutoTransition())
                        whatTheVaccien.visibility = View.GONE
                        expanededButton.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain1, AutoTransition())
                        whatTheVaccien1.visibility = View.GONE
                        expanededButton1.setImageResource(R.drawable.circle_outline)

                        TransitionManager.beginDelayedTransition(lineraMain2, AutoTransition())
                        whatTheVaccien2.visibility = View.GONE
                        expanededButton2.setImageResource(R.drawable.circle_outline)
                    }

                    TransitionManager.beginDelayedTransition(lineraMain3, AutoTransition())
                    whatTheVaccien3.visibility = View.VISIBLE
                    expanededButton3.setImageResource(R.drawable.ic_baseline_remove_circle_24)
                }
                else{
                    TransitionManager.beginDelayedTransition(lineraMain3, AutoTransition())
                    whatTheVaccien3.visibility = View.GONE
                    expanededButton3.setImageResource(R.drawable.circle_outline)
                }
            }
        }
    }
}
