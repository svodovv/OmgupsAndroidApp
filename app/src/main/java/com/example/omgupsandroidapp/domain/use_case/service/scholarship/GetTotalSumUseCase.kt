package com.example.omgupsandroidapp.domain.use_case.service.scholarship

import android.os.Build
import com.example.omgupsandroidapp.domain.model.service.Scholarship.ScholarshipModel
import com.example.omgupsandroidapp.domain.model.service.Scholarship.TotalSumPerMonthModel
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import javax.inject.Inject

class GetTotalSumUseCase @Inject constructor() {

    operator fun invoke(listScholarship: List<ScholarshipModel>) = flow {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

            val sum = listScholarship.sumOf { scholarship ->

                val dateStrings = scholarship.dateInterval.split(" - ")
                val startDateStr = dateStrings[0].trim()
                val endDateStr = dateStrings[1].trim()

                val startDate = LocalDate.parse(startDateStr, formatter)
                val endDate = LocalDate.parse(endDateStr, formatter)
                val quantityMonth = ChronoUnit.MONTHS.between(
                        startDate.withDayOfMonth(1), endDate.withDayOfMonth(1)
                    ).toInt()

                quantityMonth * scholarship.sum.toInt()
            }
            val firstMonth = listScholarship.first().dateInterval.split(" - ").first()
            val lastMonth = listScholarship.last().dateInterval.split(" - ").first()

            emit(
                TotalSumPerMonthModel(
                    totalSum = sum, firstMonth = firstMonth, lastMonth = lastMonth
                )
            )

        } else {

            emit(null)

        }


    }
}