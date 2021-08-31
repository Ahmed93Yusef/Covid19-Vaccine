package com.example.covid19_vaccine.ui.fragment


import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.FragmentVaccineTypeBinding
import com.example.covid19_vaccine.ui.fragment.VaccineType.AstazanikaFragment
import com.example.covid19_vaccine.ui.fragment.VaccineType.PfizerFragment
import com.example.covid19_vaccine.ui.fragment.VaccineTypeFragments.*

class VaccineTypeFragment : BaseFragment<FragmentVaccineTypeBinding>(){

    var mySputnikFragment =  Sputing_v_Fragment()
    var myAstazanikaFragment = AstazanikaFragment()
    var myPfizerFragment = PfizerFragment()
    val myModernaFragment = ModernaFragment()
    val mySinopharmFragment = SinopharmFragment()
    val myJohnsonJohnsonFragment = JohnsonFragment()
    val myNovaVoxFragment = NovaVoxFragment()

    override val bindingInflater: (LayoutInflater) -> FragmentVaccineTypeBinding = FragmentVaccineTypeBinding::inflate

    override fun setup() {}

    override fun addCallBack() {
        binding?.apply {
            VizorType1.setOnClickListener {
                condition(myPfizerFragment)
            }
            sputnikType2.setOnClickListener {
                condition(mySputnikFragment)
            }
            astaType3.setOnClickListener {
                condition(myAstazanikaFragment)
            }
            modernaType4.setOnClickListener {
                condition(myModernaFragment)
            }
            novavaxType5.setOnClickListener {
                condition(mySinopharmFragment)
            }
            jhonsonType6.setOnClickListener {
                condition(myJohnsonJohnsonFragment)
            }
            senphormType7.setOnClickListener {
                condition(myNovaVoxFragment)
            }
        }
    }
    fun addFragment(fragment : Fragment){
        val trans = activity?.supportFragmentManager?.beginTransaction()
        trans?.add(R.id.fragmentCountainerVaccine,fragment)
        trans?.commit()
    }
    fun replaceFragment(fragment : Fragment){
        val trans = activity?.supportFragmentManager?.beginTransaction()
        trans?.replace(R.id.fragmentCountainerVaccine,fragment)
        trans?.commit()
    }
    fun condition(fragment: Fragment){
        if (R.id.fragmentCountainerVaccine != null){
            replaceFragment(fragment)
        }
        else{
            addFragment(fragment)
        }
    }
}
