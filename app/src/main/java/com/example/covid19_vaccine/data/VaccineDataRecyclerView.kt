package com.example.covid19_vaccine.data
import com.example.covid19_vaccine.R
import com.example.covid19_vaccine.data.domain.VaccineRecyclerView

object VaccineDataRecyclerView {
    val listData = listOf<VaccineRecyclerView>(
        VaccineRecyclerView("Health Support" , R.drawable.ic_handshake),
        VaccineRecyclerView("Vaccine Type" , R.drawable.ic_injection),
        VaccineRecyclerView("Test" , R.drawable.ic_test_tube),
        VaccineRecyclerView("Covid Prevent" , R.drawable.ic_medical_mask)
    )
}
