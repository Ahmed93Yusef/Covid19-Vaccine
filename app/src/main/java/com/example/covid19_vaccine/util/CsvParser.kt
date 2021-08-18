package com.example.covid19_vaccine.util

import com.example.covid19_vaccine.data.domain.VaccineData

class CsvParser {
    fun parse(line: String): VaccineData{
        val tokens = line.split(",")
        return VaccineData(
            country = tokens[Constant.ColumnIndex.COUNTRY],
            date = tokens[Constant.ColumnIndex.DATE],
            people_vaccinated = tokens[Constant.ColumnIndex.PEOPLE_VACCINATED].toBigIntegerOrNull(),
            people_fully_vaccinated = tokens[Constant.ColumnIndex.PEOPLE_FULLY_VACCINATED].toBigIntegerOrNull(),
            daily_vaccinations = tokens[Constant.ColumnIndex.DAILY_VACCINATIONS].toBigIntegerOrNull(),
            people_vaccinated_per_hundred = tokens[Constant.ColumnIndex.PEOPLE_VACCINATED_PER_HUNDRED].toDoubleOrNull(),
            people_fully_vaccinated_per_hundred = tokens[Constant.ColumnIndex.PEOPLE_FULLY_VACCINATED_PER_HUNDRED].toDoubleOrNull(),
            daily_vaccinations_per_million = tokens[Constant.ColumnIndex.DAILY_VACCINATIONS_PER_MILLION].toIntOrNull()

        )
    }
}