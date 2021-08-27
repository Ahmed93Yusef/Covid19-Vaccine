package com.example.covid19_vaccine.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.domain.VaccineRecyclerView
import com.example.covid19_vaccine.databinding.RecyclerViewLayoutBinding

class VaccineAdapter(private val listData : List<VaccineRecyclerView>, private val listener : VaccineInteraction) : RecyclerView.Adapter<VaccineAdapter.VaccineHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineHolder =
        VaccineHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout,parent,false))

    override fun onBindViewHolder(holder: VaccineHolder, position: Int) {
        val currentServices = listData[position]
        holder.binding.apply {
            serviceName.text= currentServices.nameVaccine
            serviceImage.setImageResource(currentServices.image)
            serviceName.setOnClickListener {listener.onClickServiceName(currentServices.nameVaccine)}
            serviceImage.setOnClickListener {listener.onClickServiceImage(currentServices.image)}
        }
    }
    override fun getItemCount() = listData.size

        inner class VaccineHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
            val binding = RecyclerViewLayoutBinding.bind(itemView)
        }
}
