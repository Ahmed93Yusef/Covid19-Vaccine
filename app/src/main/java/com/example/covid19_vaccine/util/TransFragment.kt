package com.example.covid19_vaccine.util

import androidx.fragment.app.Fragment

interface TransFragment {

    fun addFragment(fragment: Fragment)
    fun replaceFragment(fragment: Fragment)
}
