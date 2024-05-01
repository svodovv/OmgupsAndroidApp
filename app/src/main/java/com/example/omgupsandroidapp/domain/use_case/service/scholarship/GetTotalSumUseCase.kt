package com.example.omgupsandroidapp.domain.use_case.service.scholarship

import android.util.Log
import com.example.omgupsandroidapp.domain.model.ScholarshipModel
import kotlinx.coroutines.flow.flow
import org.joda.time.DateTime
import org.joda.time.Months
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

class GetTotalSumUseCase @Inject constructor() {

    operator fun invoke(listScholarship: List<ScholarshipModel>) = flow<Int> {

        val formatter = DateTimeFormat.forPattern("dd.MM.yyyy")

        val dateString = listScholarship[0].dateInterval.split(" - ")

        val startDate = DateTime.parse(dateString[0].trim(), formatter)
        val endDate = DateTime.parse(dateString[1].trim(), formatter)

        val months = Months.monthsBetween(startDate, endDate).months
        Log.e("MONTH", months.toString())
        emit(months)
    }
}