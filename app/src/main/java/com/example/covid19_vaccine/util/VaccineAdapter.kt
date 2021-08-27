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
        }
    }
    override fun getItemCount() = listData.size

        inner class VaccineHolder(itemView : View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{
            val binding = RecyclerViewLayoutBinding.bind(itemView)
             init {
                 itemView.setOnClickListener(this)
             } //this Lambda function using to give to each item on the recycler own functionality
            override fun onClick(p0: View?) {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                 listener.onClickServiceItem(position)}
            }

        }
}
