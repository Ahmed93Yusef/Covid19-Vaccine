package com.example.covid19_vaccine.data.domain

data class VaccineData(
    val country: String,
    val date: String,
    val total_vaccinated: Double,
    val people_vaccinated: Double,
    val people_fully_vaccinated: Double,
    val daily_vaccinations: Double,
    val total_vaccinated_per_hundred: Double,
    val people_vaccinated_per_hundred: Double,
    val people_fully_vaccinated_per_hundred: Double,
    val daily_vaccinations_per_million: Double
)
