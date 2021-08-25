package com.example.covid19_vaccine.util

import com.example.covid19_vaccine.data.domain.VaccineData

class CsvParser {
    fun parse(line: String): VaccineData{
        val tokens = line.split(",")
        return VaccineData(
            country = tokens[Constant.ColumnIndex.COUNTRY],
            date = tokens[Constant.ColumnIndex.DATE],
            total_vaccinated = tokens[Constant.ColumnIndex.TOTAL_VACCINATED].toDoubleOrNull() ?: 0.0,
            people_vaccinated = tokens[Constant.ColumnIndex.PEOPLE_VACCINATED].toDoubleOrNull() ?: 0.0,
            people_fully_vaccinated = tokens[Constant.ColumnIndex.PEOPLE_FULLY_VACCINATED].toDoubleOrNull() ?: 0.0,
            daily_vaccinations = tokens[Constant.ColumnIndex.DAILY_VACCINATIONS].toDoubleOrNull() ?: 0.0,
            total_vaccinated_per_hundred = tokens[Constant.ColumnIndex.TOTAL_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            people_vaccinated_per_hundred = tokens[Constant.ColumnIndex.PEOPLE_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            people_fully_vaccinated_per_hundred = tokens[Constant.ColumnIndex.PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDoubleOrNull() ?: 0.0,
            daily_vaccinations_per_million = tokens[Constant.ColumnIndex.DAILY_VACCINATIONS_PER_MILLION].toDoubleOrNull() ?: 0.0

        )
    }
}
