import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.DataManger
import com.example.covid19_vaccine.data.domain.VaccineData
import com.example.covid19_vaccine.databinding.ItemStatisticsBinding

class StatisticsAdapter(private val listData: List<VaccineData>) : RecyclerView.Adapter<StatisticsAdapter.TopViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TopViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_statistics,parent,false))

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {
        val textList = listData[position]
        holder.binding.apply {
            countryName.isSelected=true
            countryName.text = textList.country
            countryVaccinePer.text = DataManger.convertNumber(textList.people_vaccinated)
            countryVaccineTotal.text = textList.people_vaccinated_per_hundred.toString()
        }

    }
    override fun getItemCount() = listData.size

    inner class TopViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val binding = ItemStatisticsBinding.bind(itemView)
    }

}
