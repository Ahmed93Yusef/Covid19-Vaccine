import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.data.domain.VaccineData
import com.example.covid19_vaccine.databinding.ItemStatisticsBinding
import com.example.covid19_vaccine.util.CountryInterAction
import com.example.covid19_vaccine.util.VaccineInteraction

class StatisticsAdapter(private val listData: List<VaccineData>,private val listener : CountryInterAction) : RecyclerView.Adapter<StatisticsAdapter.TopViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_statistics,parent,false))

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        val textList = listData[position]
        holder.binding.apply {
            countryName.isSelected=true
            countryName.text = textList.country
            countryVaccinePer.text = DataManger.convertNumber(textList.people_vaccinated)
            "${textList.people_vaccinated_per_hundred}%".also { countryVaccineTotal.text = it }
        }

    }
    override fun getItemCount() = listData.size

    inner class TopViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val binding = ItemStatisticsBinding.bind(itemView)
        init {
            itemView.setOnClickListener (this)
        } //this Lambda function using to give to each item on the recycler own functionality
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onClickCountryItem(position)}
        }
    }

}
