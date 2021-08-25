package com.example.covid19_vaccine.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.databinding.RecyclerViewLayoutBinding

class VaccineAdapter() : RecyclerView.Adapter<VaccineAdapter.VaccineHolder>() {
    private var vaccineName = arrayOf(
        "Health Support" ,
        "Vaccine Type" ,
        "Test",
        "Covid Prevent",
    )
    private var images = intArrayOf(
        R.drawable.ic_handshake,
        R.drawable.ic_injection,
        R.drawable.ic_test_tube,
        R.drawable.ic_heart,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout,parent,false)
        return VaccineHolder(view)
    }

    override fun onBindViewHolder(holder: VaccineHolder, position: Int) {

        holder.binding.apply {
            serviceName.text= vaccineName[position]
            serviceImage.setImageResource(images[position])

    }}
    override fun getItemCount() = vaccineName.size

    inner class VaccineHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = RecyclerViewLayoutBinding.bind(itemView)

    }
}
