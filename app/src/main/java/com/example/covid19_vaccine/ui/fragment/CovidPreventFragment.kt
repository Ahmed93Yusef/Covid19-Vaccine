package com.example.covid19_vaccine.ui.fragment

import android.view.LayoutInflater
import androidx.core.view.size
import androidx.viewpager2.widget.ViewPager2
import com.example.covid19_vaccine.data.domain.DataPrevent
import com.example.covid19_vaccine.databinding.FragmentCovidPreventBinding
import com.example.covid19_vaccine.util.ViewPagerAdapter

class CovidPreventFragment : BaseFragment<FragmentCovidPreventBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentCovidPreventBinding = FragmentCovidPreventBinding::inflate

    override fun setup() {
        viewPagerAdapter()
    }
    override fun addCallBack() {
        onClickNext()
    }
    private fun viewPagerAdapter(){
        binding?.apply {
            myViewPager.adapter = ViewPagerAdapter(DataPrevent.listData)

            myViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

            myindecator.setViewPager(myViewPager)

            myViewPager.apply {
                beginFakeDrag()
                fakeDragBy(10f)
                endFakeDrag()
            }
        }
    }
    private fun onClickNext(){

        binding?.apply {
            if (myindecator.size != DataPrevent.listData.lastIndex){
                nextPic.setOnClickListener {
                    myViewPager.beginFakeDrag()
                    myViewPager.fakeDragBy(-10f)
                    myViewPager.endFakeDrag()
                }
            }else{
                nextPic.setOnClickListener {
                    myViewPager.beginFakeDrag()
                    myViewPager.fakeDragBy(10f)
                    myViewPager.endFakeDrag()
                }
            }

        }
    }




}
