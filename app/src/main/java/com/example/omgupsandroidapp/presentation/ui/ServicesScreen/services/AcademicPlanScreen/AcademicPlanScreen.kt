package com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen

//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.VerticalDivider
import android.util.Log
import androidx.annotation.AnyThread
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.data.remote.dto.acafemicplan.Discipline
import com.example.omgupsandroidapp.domain.model.service.AcademicPlanModel
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import com.my.tracker.MyTracker
import java.sql.Driver

/*@OptIn(ExperimentalFoundationApi::class)
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
                            modifier = Modifier.padding(bottom = 8.dp),
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontWeight = FontWeight.Black
                        )
                        academicPlan[course].forEach { discpSemestr ->

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 16.dp),
                                horizontalArrangement = Arrangement.Start
                            )
                            {
                                Text(
                                    text = discpSemestr.key,
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Black
                                )
                            }
                            Spacer(modifier = Modifier.padding(5.dp))
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
                                        .weight(0.7f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                        Text(text = "Вид нагрузки/Контроля")
                                }
                                Column(
                                    modifier = Modifier
                                        .weight(0.3f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(text = "Количество часов",textAlign = TextAlign.Center)
                                }
                                Spacer(modifier = Modifier.padding(end = 10.dp))
                            }

                           /* for (size in discpSemestr.value.indices) {


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
                            }*/
                            val result = discpSemestr.value.groupBy { it.name }
                            Log.e("htmlContent", result.toString())
                            Spacer(modifier = Modifier.padding(5.dp))
                            result.forEach { disciplina ->
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
                                        var isVisible by remember {
                                            mutableStateOf(false)
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(
                                                    MaterialTheme.colorScheme.surfaceVariant,
                                                    shape = RoundedCornerShape(20.dp)
                                                )
                                                .padding(5.dp),
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxSize(),
                                                horizontalArrangement = Arrangement.Center,
                                            ) {
                                                Column(
                                                    modifier = Modifier.weight(0.8f),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.Top
                                                ) {
                                                    Text(
                                                        text = disciplina.key.toString(),
                                                        color = Color.Black,
                                                        textAlign = TextAlign.Center,
                                                        fontWeight = FontWeight.Bold
                                                    )

                                                }
                                                Column(
                                                    modifier = Modifier.fillMaxSize(0.075f)
                                                ) {
                                                    IconButton(onClick = {
                                                        isVisible = !isVisible
                                                    },
                                                        modifier = Modifier.size(35.dp)) {
                                                        Icon(
                                                            painter = painterResource(
                                                                id = if (isVisible) R.drawable. baseline_keyboard_arrow_up_24
                                                                else R.drawable.baseline_keyboard_arrow_down_24
                                                            ),
                                                            contentDescription = stringResource(R.string.arrow_in_order_card),
                                                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                                                        )
                                                    }
                                                }
                                            }


                                                AnimatedVisibility(isVisible) {
                                                    Column()
                                                    {
                                                        for (sizeload in disciplina.value.indices) {
                                                            Spacer(modifier = Modifier.padding(2.dp))
                                                            Row(
                                                                modifier = Modifier.fillMaxSize(),
                                                                verticalAlignment = Alignment.CenterVertically
                                                            ) {
                                                                Column(
                                                                    modifier = Modifier.fillMaxWidth(
                                                                        0.7f
                                                                    ),
                                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                                ) {
                                                                    if (disciplina.value[sizeload].load == "Зачет"
                                                                        || disciplina.value[sizeload].load == "Экзамен"
                                                                        && disciplina.value[sizeload].IsControl == true
                                                                    ) {

                                                                    } else {
                                                                        Text(
                                                                            text = disciplina.value[sizeload].load.toString(),
                                                                            textAlign = TextAlign.Center,
                                                                            color = Color.Black,
                                                                        )
                                                                    }

                                                                }
                                                                /*Row(
                                                                modifier = Modifier.fillMaxWidth(
                                                                    0.6f
                                                                ),
                                                                horizontalArrangement = Arrangement.Center

                                                            ) {
                                                                Text(
                                                                    text = disciplina.value[sizeload].IsControl.toString()
                                                                )
                                                            }*/


                                                                /*VerticalDivider(
                                                            modifier = Modifier
                                                                .width(1.dp)
                                                                .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                                                            thickness = 1.dp,
                                                            color = Color.Black
                                                        )*/

                                                                Column(
                                                                    modifier = Modifier.fillMaxSize(),
                                                                    //0.3f).background(color = Color.Red),
                                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                                ) {
                                                                    if (disciplina.value[sizeload].load == "Зачет"
                                                                        || disciplina.value[sizeload].load == "Экзамен"
                                                                        && disciplina.value[sizeload].IsControl == true) {
                                                                    } else {
                                                                        Text(
                                                                            text = disciplina.value[sizeload].amount.toString(),
                                                                            color = Color.Black,
                                                                            //textAlign = TextAlign.Center
                                                                        )
                                                                    }
                                                                }
                                                               // Spacer(modifier = Modifier.padding(5.dp))
                                                            }
                                                        }
                                                    }
                                                }
                                            for (sizeload in disciplina.value.indices) {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(0.9f),
                                                    //.background(color = Color.Red),
                                                    //verticalAlignment = Alignment.Top,
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxSize(),
                                                        horizontalArrangement = Arrangement.Center
                                                        //verticalArrangement = Arrangement.Top,
                                                        //horizontalAlignment = Alignment.CenterHorizontally
                                                    ) {
                                                        if (disciplina.value[sizeload].load == "Зачет" || disciplina.value[sizeload].load == "Экзамен"
                                                            && disciplina.value[sizeload].IsControl == true
                                                        ) {
                                                            Text(
                                                                text = "Вид контроля : ",
                                                                color = Color.Black,
                                                                fontWeight = FontWeight.Bold
                                                            )
                                                        }

                                                        /* Column(
                                                        modifier = Modifier.fillMaxWidth(),
                                                        //0.3f),
                                                        horizontalAlignment = Alignment.CenterHorizontally
                                                    ) {*/
                                                        if (disciplina.value[sizeload].IsControl == true
                                                            && disciplina.value[sizeload].load != "Курсовая работа"
                                                        ) {
                                                            Text(
                                                                text = disciplina.value[sizeload].load.toString(),
                                                                color = Color.Black,
                                                                fontWeight = FontWeight.Bold
                                                            )
                                                        } else {

                                                        }
                                                    }
                                                   // }
                                                    //
                                                // Spacer(modifier = Modifier.padding(5.dp))
                                                }
                                            }
                                            }
                                        }
                                Spacer(modifier = Modifier.padding(5.dp))
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

        }else{
            LoadingScreen()
        }
    }
}

@Composable
fun CreateSubjectBox(semestr: String, subchect :List<AcademicPlanModel>)
{

}*/



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AcademicPlanScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    academicPlanViewModel: AcademicPlanViewModel = hiltViewModel()
) {
    ServicesTopAppBar(title = "Учебный план", navController = navController)

    MyTracker.trackEvent("Учебный план")

    val academicPlanState = academicPlanViewModel.academicPlanState.collectAsStateWithLifecycle()
    val academicPlan = academicPlanState.value.AcademicPlanList.map {
        it.disciplines
    }
    val currentacademicPlan = academicPlanState.value.AcademicPlanList
    val pagerState = rememberPagerState(pageCount = { academicPlanState.value.AcademicPlanList.size })
    var discipline = mutableMapOf<String, List<Discipline>>()
    var currentPage = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(paddingValues),
        verticalArrangement = Arrangement.Top,
        //horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ServicesTopAppBar(title = "Учебный план", navController = navController)
        if (pagerState.pageCount > 1) {
            DynamicRowPage(pagerState.currentPage, pagerState.pageCount)
        }
        if (academicPlanState.value.AcademicPlanList.isNotEmpty()) {
            HorizontalPager(
                state = pagerState,
                key ={ academicPlanState.value.AcademicPlanList[it].name },
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Top,
                beyondViewportPageCount = pagerState.pageCount
            ) { index ->
                currentPage.value = index

                LazyColumn(
                    verticalArrangement = Arrangement.Top
                ) {
                    // items(currentacademicPlan.size) { course ->
                    item {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.padding(2.dp))
                            Text(
                                text = currentacademicPlan[index].name,
                                modifier = Modifier.padding(bottom = 8.dp),
                                textAlign = TextAlign.Center,
                                color = Color.Black,
                                fontWeight = FontWeight.Black
                            )


                            academicPlan[index].forEach { discpSemestr ->

                                Row(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(start = 16.dp),
                                    horizontalArrangement = Arrangement.Start
                                )
                                {
                                    Text(
                                        text = discpSemestr.key,
                                        color = Color.Blue,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                                Spacer(modifier = Modifier.padding(5.dp))
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
                                            .weight(0.7f),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(text = "Вид нагрузки/Контроля")
                                    }
                                    Column(
                                        modifier = Modifier
                                            .weight(0.3f),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            text = "Количество часов",
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(end = 10.dp))
                                }

                                /* for (size in discpSemestr.value.indices) {


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
                            }*/
                                val result = discpSemestr.value.groupBy { it.name }
                                Log.e("htmlContent", result.toString())
                                Spacer(modifier = Modifier.padding(5.dp))
                                result.forEach { disciplina ->
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
                                        var isVisible by remember {
                                            mutableStateOf(false)
                                        }
                                        Column(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(
                                                    MaterialTheme.colorScheme.surfaceVariant,
                                                    shape = RoundedCornerShape(20.dp)
                                                )
                                                .padding(5.dp),
                                        ) {
                                            Row(
                                                modifier = Modifier.fillMaxSize(),
                                                horizontalArrangement = Arrangement.Center,
                                            ) {
                                                Column(
                                                    modifier = Modifier.weight(0.8f),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.Top
                                                ) {
                                                    Text(
                                                        text = disciplina.key.toString(),
                                                        color = Color.Black,
                                                        textAlign = TextAlign.Center,
                                                        fontWeight = FontWeight.Bold
                                                    )

                                                }
                                                Column(
                                                    modifier = Modifier.fillMaxSize(0.075f)
                                                ) {
                                                    IconButton(
                                                        onClick = {
                                                            isVisible = !isVisible
                                                        },
                                                        modifier = Modifier.size(35.dp)
                                                    ) {
                                                        Icon(
                                                            painter = painterResource(
                                                                id = if (isVisible) R.drawable.baseline_keyboard_arrow_up_24
                                                                else R.drawable.baseline_keyboard_arrow_down_24
                                                            ),
                                                            contentDescription = stringResource(R.string.arrow_in_order_card),
                                                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                                                        )
                                                    }
                                                }
                                            }


                                            AnimatedVisibility(isVisible) {
                                                Column()
                                                {
                                                    for (sizeload in disciplina.value.indices) {
                                                        Spacer(modifier = Modifier.padding(2.dp))
                                                        Row(
                                                            modifier = Modifier.fillMaxSize(),
                                                            verticalAlignment = Alignment.CenterVertically
                                                        ) {
                                                            Column(
                                                                modifier = Modifier.fillMaxWidth(
                                                                    0.7f
                                                                ),
                                                                horizontalAlignment = Alignment.CenterHorizontally
                                                            ) {
                                                                if (disciplina.value[sizeload].load == "Зачет"
                                                                    || disciplina.value[sizeload].load == "Экзамен"
                                                                    && disciplina.value[sizeload].IsControl == true
                                                                ) {

                                                                } else {
                                                                    Text(
                                                                        text = disciplina.value[sizeload].load.toString(),
                                                                        textAlign = TextAlign.Center,
                                                                        color = Color.Black,
                                                                    )
                                                                }

                                                            }
                                                            /*Row(
                                                                modifier = Modifier.fillMaxWidth(
                                                                    0.6f
                                                                ),
                                                                horizontalArrangement = Arrangement.Center

                                                            ) {
                                                                Text(
                                                                    text = disciplina.value[sizeload].IsControl.toString()
                                                                )
                                                            }*/


                                                            /*VerticalDivider(
                                                            modifier = Modifier
                                                                .width(1.dp)
                                                                .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                                                            thickness = 1.dp,
                                                            color = Color.Black
                                                        )*/

                                                            Column(
                                                                modifier = Modifier.fillMaxSize(),
                                                                //0.3f).background(color = Color.Red),
                                                                horizontalAlignment = Alignment.CenterHorizontally
                                                            ) {
                                                                if (disciplina.value[sizeload].load == "Зачет"
                                                                    || disciplina.value[sizeload].load == "Экзамен"
                                                                    && disciplina.value[sizeload].IsControl == true
                                                                ) {
                                                                } else {
                                                                    Text(
                                                                        text = disciplina.value[sizeload].amount.toString(),
                                                                        color = Color.Black,
                                                                        //textAlign = TextAlign.Center
                                                                    )
                                                                }
                                                            }
                                                            // Spacer(modifier = Modifier.padding(5.dp))
                                                        }
                                                    }
                                                }
                                            }
                                            for (sizeload in disciplina.value.indices) {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(0.9f),
                                                    //.background(color = Color.Red),
                                                    //verticalAlignment = Alignment.Top,
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxSize(),
                                                        horizontalArrangement = Arrangement.Center
                                                        //verticalArrangement = Arrangement.Top,
                                                        //horizontalAlignment = Alignment.CenterHorizontally
                                                    ) {
                                                        if (disciplina.value[sizeload].load == "Зачет" || disciplina.value[sizeload].load == "Экзамен"
                                                            && disciplina.value[sizeload].IsControl == true
                                                        ) {
                                                            Text(
                                                                text = "Вид контроля : ",
                                                                color = Color.Black,
                                                                fontWeight = FontWeight.Bold
                                                            )
                                                        }

                                                        /* Column(
                                                        modifier = Modifier.fillMaxWidth(),
                                                        //0.3f),
                                                        horizontalAlignment = Alignment.CenterHorizontally
                                                    ) {*/
                                                        if (disciplina.value[sizeload].IsControl == true
                                                            && disciplina.value[sizeload].load != "Курсовая работа"
                                                        ) {
                                                            Text(
                                                                text = disciplina.value[sizeload].load.toString(),
                                                                color = Color.Black,
                                                                fontWeight = FontWeight.Bold
                                                            )
                                                        } else {

                                                        }
                                                    }
                                                    // }
                                                    //
                                                    // Spacer(modifier = Modifier.padding(5.dp))
                                                }
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
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

        }else{
            LoadingScreen()
        }
    }
}

@Composable
fun DynamicRowPage(currentStage: Int, maxSize: Int) {
    val boxesCount = remember { mutableStateOf(maxSize) }
   // val selectedIndex = remember { mutableStateOf(currentStage) }

    /*Row(
        modifier = Modifier.wrapContentSize()/*.background(
            MaterialTheme.colorScheme.surfaceVariant,
            shape = RoundedCornerShape(20.dp)
        )*/,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(boxesCount.value) { index ->
            Spacer(modifier = Modifier.padding(2.dp))
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        if (currentStage == index) {
                            Color.Green
                        } else {
                            Color.Gray
                        },
                        shape = CircleShape
                    )
            )

        }
    }*/
    Column {
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(boxesCount.value) { iteration ->
                val color = if (currentStage == iteration) Color.Blue else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(12.dp)
                )
            }
        }
    }
}

