package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.Discipline
import com.example.omgupsandroidapp.domain.model.service.AcademicPlanModel
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import java.sql.Driver

@Composable
fun AcademicPlanScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    academicPlanViewModel: AcademicPlanViewModel = hiltViewModel()
) {
    ServicesTopAppBar(title = "Учебный план", navController = navController)

    val academicPlanState = academicPlanViewModel.academicPlanState.collectAsStateWithLifecycle()
    val academicPlan = academicPlanState.value.AcademicPlanList.map {
        it.disciplines
    }
    val currentacademicPlan = academicPlanState.value.AcademicPlanList

    var discipline = mutableMapOf<String, List<Discipline>>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(paddingValues),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ServicesTopAppBar(title = "Учебный план", navController = navController)
        if (academicPlanState.value.AcademicPlanList.isNotEmpty()) {
            LazyColumn(
            ) {
                items(currentacademicPlan.size) { course ->
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = currentacademicPlan[course].name,
                            // style = MaterialTheme.typography,
                            modifier = Modifier.padding(bottom = 8.dp),
                            textAlign = TextAlign.Center
                        )
                        academicPlan[course].forEach { discpSemestr ->
                            Row(
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalArrangement = Arrangement.Start
                            )
                            {
                                Text(text = discpSemestr.key)
                            }
                            /*Divider(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        horizontal = 8.dp,
                                    ), thickness = 1.dp, Color.Black
                            )*/
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .height(39.dp)
                                    .background(
                                        MaterialTheme.colorScheme.surfaceVariant,
                                        shape = RoundedCornerShape(20.dp)
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .weight(6f),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Row {
                                        Text(text = "Вид нагрузки/Контроля")
                                    }
                                }
                                Column(
                                    modifier = Modifier
                                        .weight(4f),
                                    verticalArrangement = Arrangement.Bottom
                                ) {
                                    Text(text = "Количество часов")
                                }
                            }


                            var mapDis: MutableMap<String, Discipline>;
                            //Log.e("htmlContent", entris.value[0].toString())


                            for (size in discpSemestr.value.indices) {


                                if (discpSemestr.value[size].name.toString() == discpSemestr.value[size].name.toString())
                                    discipline.put(
                                        key = discpSemestr.value[size].name.toString(),
                                        listOf(
                                            Discipline(
                                                discpSemestr.value[size].IsControl,
                                                discpSemestr.value[size].load,
                                                discpSemestr.value[size].period,
                                                discpSemestr.value[size].amount,
                                                discpSemestr.value[size].code,
                                                discpSemestr.value[size].unit
                                            )
                                        )
                                    )
                            }
                            Log.e("htmlContent", discipline.toString())
                                discipline.forEach { disciplina ->
                                    Card(
                                        /*modifier = Modifier
                                        .size(300.dp)
                                        .background(
                                            MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(20.dp)
                                        ),
                                    colors = CardDefaults.cardColors(containerColor =MaterialTheme.colorScheme.surfaceVariant)
                                        //verticalAlignment = Alignment.CenterVertically*/
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(
                                                    MaterialTheme.colorScheme.surfaceVariant,
                                                    shape = RoundedCornerShape(20.dp)
                                                ),
                                        ) {

                                            Row(
                                                modifier = Modifier.fillMaxSize(),
                                                horizontalArrangement = Arrangement.Center
                                            ) {
                                                Text(
                                                    text = disciplina.key.toString(),
                                                    color = Color.Black
                                                )
                                            }
                                            for (sizeload in disciplina.value.indices) {
                                            Row(
                                                horizontalArrangement = Arrangement.Center
                                            )
                                            {
                                                    Column(
                                                        modifier = Modifier.fillMaxSize()
                                                    ) {
                                                        Row(
                                                            horizontalArrangement = Arrangement.Center
                                                        ) {
                                                            Text(
                                                                text = discpSemestr.value[sizeload].load.toString()
                                                            )
                                                        }
                                                        Row(
                                                            horizontalArrangement = Arrangement.Center
                                                        ) {
                                                            Text(
                                                                text = discpSemestr.value[sizeload].IsControl.toString()
                                                            )
                                                        }
                                                    }
                                                    VerticalDivider(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(
                                                                horizontal = 8.dp,
                                                            ), thickness = 1.dp, Color.Black
                                                    )
                                                    Column() {
                                                        Row(
                                                            modifier = Modifier
                                                                .weight(4f)
                                                        ) {
                                                            Text(text = discpSemestr.value[sizeload].amount.toString())
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                /*for (size in entris.value.indices) {
                                Text(
                                    text = "${entris.value[size].load}, Код: ${entris.value[size].code}, " +
                                            "Семестр: ${entris.value[size].period}, Объем: ${entris.value[size].amount}, " +
                                            "Контроль: ${if (entris.value[size].IsControl == true) "Да" else "Нет"}",
                                    // style = MaterialTheme.typography,
                                )
                            }*/

                            /*for (discipline in currentacademicPlan[course].disciplines) {
                            Text(
                                text = "${discipline.key = discipline.value}: ${discipline.load}, Код: ${discipline.code}, " +
                                        "Семестр: ${discipline.period}, Объем: ${discipline.amount}, " +
                                        "Контроль: ${if (discipline.IsControl == true) "Да" else "Нет"}",
                               // style = MaterialTheme.typography,
                            )
                        }*/
                        }
                    }
                }
                /*LazyColumn(
                modifier = Modifier
                    .padding(20.dp, 20.dp)
                    .fillMaxSize(),
//verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                semestrs.map {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.Start

                        ) {
                            Text(
                                it,
                                style = TextStyle(
// fontSize = 20.px,
//lineHeight = 12.px,
//fontFamily = FontFamily(Font(R.font.Russo One)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF414C53)
                                )
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(6f)
                            ){
                                Text(text = "Вид нагрузки/Контроля")
                            }
                            Column(
                                modifier = Modifier
                                    .weight(4f)
                            ) {
                                Text(text = "Количество часов")
                            }

                        }
                    }
                }
            }*/
            }

        }else{
            LoadingScreen()
        }
    }
}

@Composable
fun CreateSubjectBox(semestr: String, subchect :List<AcademicPlanModel>)
{

}