package com.example.covid19_vaccine.ui.fragment

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import com.example.covid19_vaccine.databinding.FragmentAboutBinding

class AboutFragment: BaseFragment<FragmentAboutBinding>() {
    override val bindingInflater: (LayoutInflater) -> FragmentAboutBinding = FragmentAboutBinding::inflate

    override fun setup() {

    }

    // Open a link of Github site when click on the icon from the fragment.
    override fun addCallBack() {

        binding?.apply{
            member1.setOnClickListener() {
                val urlIntent = Intent(Intent.ACTION_VIEW)
                urlIntent.data = Uri.parse("https://github.com/Ahmed93Yusef")
                startActivity(urlIntent)
            }

            member2.setOnClickListener() {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("https://github.com/nooraldenakel")
            startActivity(urlIntent)
            }

            member3.setOnClickListener() {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("https://github.com/naufalAliraqi")
            startActivity(urlIntent)
            }

            member4.setOnClickListener() {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("https://github.com/huda997")
            startActivity(urlIntent)
            }
            member5.setOnClickListener() {
            val urlIntent = Intent(Intent.ACTION_VIEW)
            urlIntent.data = Uri.parse("https://github.com/Anwar-Alfarhany")
            startActivity(urlIntent)
            }
        }

    }


}

