package com.example.covid19_vaccine.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_vaccine.R

class VaccineAdapter() : RecyclerView.Adapter<VaccineAdapter.VaccineHolder>() {
    private var vaccineName = arrayOf(
        "Sputnik-V" ,
        "Astrazeneca" ,
        "Moderna " ,
        "Pfizer-biontec" ,
        "Novavax" ,
        "Johnson and johnson",
    )
    private var images = intArrayOf(
        R.drawable.image,
        R.drawable.image,
        R.drawable.image,
        R.drawable.image,
        R.drawable.image,
        R.drawable.image,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout,parent,false)
        return VaccineHolder(view)
    }

    override fun onBindViewHolder(holder: VaccineHolder, position: Int) {

        holder.apply {
            textView.text = vaccineName[position]
            imageView.setImageResource(images[position])
        }



    }

    override fun getItemCount() = vaccineName.size


    inner class VaccineHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
         var imageView: ImageView = itemView.findViewById(R.id.image_Vaccine)
         var textView: TextView= itemView.findViewById(R.id.textNameVaccine)

    }
}
