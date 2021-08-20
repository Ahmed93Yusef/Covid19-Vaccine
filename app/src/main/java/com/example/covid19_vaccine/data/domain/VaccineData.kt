package com.example.covid19_vaccine.data.domain

import java.math.BigInteger

data class VaccineData(
    val country: String,
    val date: String,
    val people_vaccinated: BigInteger?,
    val people_fully_vaccinated: BigInteger?,
    val daily_vaccinations: Int?,
    val people_vaccinated_per_hundred: Double?,
    val people_fully_vaccinated_per_hundred: Double?,
    val daily_vaccinations_per_million: Int?
)
