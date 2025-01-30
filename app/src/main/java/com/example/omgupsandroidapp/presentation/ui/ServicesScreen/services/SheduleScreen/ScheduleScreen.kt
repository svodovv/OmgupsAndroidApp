package com.omgupsapp.presentation.ui.SheduleScreen

import android.annotation.SuppressLint
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.gestures.animateTo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.domain.model.service.SheduleModel
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.AcademicPlanScreen.DynamicRowPage
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.ServicesTopAppBar
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SheduleScreen.SheduleViewModul
import com.example.omgupsandroidapp.presentation.ui.ServicesScreen.services.SheduleScreen.TrainAnimationLottie
import com.my.tracker.MyTracker
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields
import java.util.Locale
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

enum class Anchors {
    Start,
    End
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("CoroutineCreationDuringComposition", "NewApi", "RememberReturnType")
@Composable
fun ScheduleScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    sheduleViewModul: SheduleViewModul = hiltViewModel()
) {

    ServicesTopAppBar(title = "Расписание", navController = navController)
    MyTracker.trackEvent("Расписание")

    LaunchedEffect(Unit) {
        sheduleViewModul.getShedule()
    }

    val width = 196.dp
    val squareSize = 98.dp

    //val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val density = LocalDensity.current
    val parentBoxWidth = 98.dp
    val boxSize = 196.dp
    val widthPx = with(density) {(parentBoxWidth - boxSize).toPx() }
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val state = remember {
        AnchoredDraggableState(
            initialValue = Anchors.Start,
            anchors = DraggableAnchors {
                Anchors.Start at 0f
                Anchors.End at widthPx
            },
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { with(density) { 97.dp.toPx() } },
            snapAnimationSpec = tween(durationMillis = 200),
            decayAnimationSpec = decayAnimationSpec
        )
    }

    val sheduleState = sheduleViewModul.sheduleState.collectAsStateWithLifecycle()

    val nechet = sheduleState.value.sheduleList.filter { it.type_of_week == 0 }
    val chet = sheduleState.value.sheduleList.filter { it.type_of_week == 1 }
    //val mapWeek = mapOf("Нечетная неделя" to nechet,
    //    "Четная неделя" to chet)
    //val allSchedule = listOf(mapWeek)
    val pagerState = rememberPagerState(pageCount = { 2 })
    val dayOfWeek = listOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота")
    val dayOfWeekOnEng = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY","FRIDAY", "SATURDAY")
    val day =  LocalDate.now().dayOfWeek.value
    val currentDay = LocalDate.now().dayOfWeek
    val daysOfWeekInRussian = mapOf(
        DayOfWeek.MONDAY to "Понедельник",
        DayOfWeek.TUESDAY to "Вторник",
        DayOfWeek.WEDNESDAY to "Среда",
        DayOfWeek.THURSDAY to "Четверг",
        DayOfWeek.FRIDAY to "Пятница",
        DayOfWeek.SATURDAY to "Суббота",
        DayOfWeek.SUNDAY to "Воскресенье"
    )
    var currentDayInRussian = ""
    daysOfWeekInRussian.map {
        if (currentDay == it.key) {
            currentDayInRussian = it.value
        }
    }
    //Log.e("currentDay", currentDay)
    //Log.e("isload", sheduleState.value.isLoading.toString())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
            //.padding(2.dp)
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(0.dp, 35.dp))
        //Log.e("htmlContent", sheduleState.value.sheduleList.toString())
        //ServicesTopAppBar(title = "Расписание", navController = navController)
        //Log.e("checkWeek()", checkWeek().toString())
        /*if(sheduleState.value.isLoading == false) {
         Log.e("isload", "попало в фолс"/*sheduleState.value.isLoading.toString()*/)
            LoadingScreen()
        } else*/ /*if (sheduleState.value.sheduleList.isEmpty() && sheduleState.value.isLoading == false){
            Log.e("isload", "попало в нет данных")
                // NoDataScreen()
            LoadingScreen()
        } else */if (sheduleState.value.sheduleList.isNotEmpty()) {
        val pagerState = rememberPagerState(pageCount = { 2 })

        // Синхронизация состояний пейджера и переключателя
        LaunchedEffect(pagerState.currentPage) {
            val targetAnchor = when (pagerState.currentPage) {
                0 -> Anchors.Start
                1 -> Anchors.End
                else -> Anchors.Start
            }
            state.animateTo(targetAnchor)
        }

        LaunchedEffect(state.currentValue) {
            val targetPage = when (state.currentValue) {
                Anchors.Start -> 0
                Anchors.End -> 1
            }
            pagerState.animateScrollToPage(targetPage)
        }

        Box(
            modifier = Modifier
                .size(198.dp, 26.dp)
                .anchoredDraggable(
                    state = state,
                    orientation = Orientation.Horizontal,
                )
                .background(Color.LightGray, shape = RoundedCornerShape(50)),

        ) {
            Row(
                Modifier.fillMaxSize()
                    .padding(start = 1.dp, end = 1.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .offset { IntOffset(state.offset.absoluteValue.roundToInt(), 0) }
                        .size(98.dp, 23.dp)
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(50)
                        )
                ){
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    )
                    {
                        if (checkWeek() == 0 && pagerState.currentPage == 0) {
                            Text("НЕЧЕТНАЯ", color = MaterialTheme.colorScheme.primary)
                        } else if (checkWeek() == 0 && pagerState.currentPage == 1) {
                            Text("ЧЕТНАЯ", color = MaterialTheme.colorScheme.primary)
                        } else if (checkWeek() == 1 && pagerState.currentPage == 0) {
                            Text("ЧЕТНАЯ", color = MaterialTheme.colorScheme.primary)
                        } else if (checkWeek() == 1 && pagerState.currentPage == 1) {
                            Text("НЕЧЕТНАЯ", color = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
            }
        }
            /*Row(modifier = Modifier) {
                /*Box(
                    modifier = Modifier
                        .width(width)
                        .anchoredDraggable(
                            state = state,
                            orientation = Orientation.Horizontal
                        )
                        .background(Color.LightGray)
                ) {
                    Box(
                        modifier = Modifier
                            .offset { IntOffset(state.offset.absoluteValue.roundToInt(), 0) }
                            .size(squareSize)
                            .background(Color.DarkGray)
                    )
                }*/
                //DynamicRowPage(pagerState.currentPage, pagerState.pageCount)
            }*/
            HorizontalPager(
                state = pagerState,
                //0key = { sheduleState.value.sheduleList[it].type_of_week },
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Top,
                beyondViewportPageCount = 2
            ) { indexpage ->
            LazyColumn(
                modifier = Modifier
                    //.padding(0.dp, 60.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                        Column(
                        ) {
                            //Spacer(modifier = Modifier.padding(5.dp))
                            if (checkWeek() == 0 && indexpage == 0) {
                               // allSchedule[].forEach { week ->
                                val currentDays = nechet.filter { it.day_of_week == currentDayInRussian }
                                createCurrentDayBox(currentDays)

                                /*Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(20.dp, 0.dp)
                                ) {
                                    Text("Нечетная неделя", fontSize = 25.sp)
                                }*/
                                dayOfWeek.map { dayWeek ->
                                    val days = nechet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day)
                                    }
                                }
                                Spacer(modifier = Modifier.padding(vertical = 45.dp))
                            }else if ( checkWeek() == 0 && indexpage == 1){
                               /* Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(20.dp, 0.dp)
                                ) {
                                    Text("Четная неделя", fontSize = 25.sp)
                                }*/
                                dayOfWeek.map { dayWeek ->
                                    val days = chet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day - 7)
                                    }
                                }
                                Spacer(modifier = Modifier.padding(vertical = 45.dp))
                            }else if (checkWeek() == 1 && indexpage == 0){
                                val currentDays = chet.filter { it.day_of_week == currentDayInRussian }
                                createCurrentDayBox(currentDays)

                                /*Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(20.dp, 0.dp)
                                ) {
                                    Text("Четная неделя", fontSize = 25.sp)
                                }*/
                                dayOfWeek.map { dayWeek ->
                                    val days = chet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day)
                                    }
                                }
                                Spacer(modifier = Modifier.padding(vertical = 45.dp))
                            }else if (checkWeek() == 1 && indexpage == 1){
                                /*Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(20.dp, 0.dp)
                                ) {
                                    Text("Нечетная неделя", fontSize = 25.sp)
                                }*/
                                dayOfWeek.map { dayWeek ->
                                    val days = nechet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day-7)
                                    }
                                }
                                Spacer(modifier = Modifier.padding(vertical = 45.dp))
                            }
                    }
                       /* Column(
                        ) {

                            if (checkWeek() == 0) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(15.dp, 0.dp)
                                ) {
                                    Text("Нечетная неделя", fontSize = 25.sp)
                                }
                                dayOfWeek.map { dayWeek ->
                                    val days = nechet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day)
                                    }
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(15.dp, 0.dp)
                                ) {
                                    Text("Четная неделя", fontSize = 25.sp)
                                }
                                dayOfWeek.map { dayWeek ->
                                    val days = chet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day - 7)
                                    }
                                }
                            } else {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(15.dp, 0.dp)
                                ) {
                                    Text("Четная неделя", fontSize = 25.sp)
                                }
                                dayOfWeek.map { dayWeek ->
                                    val days = chet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day)
                                    }
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(15.dp, 0.dp)
                                ) {
                                    Text("Нечетная неделя", fontSize = 25.sp)
                                }
                                dayOfWeek.map { dayWeek ->
                                    val days = nechet.filter { it.day_of_week == dayWeek }
                                    Row {
                                        createDayBox(dayOfWeek = dayWeek, schedule = days, day - 7)
                                    }
                                }
                            }
                        }
                    */
                    }
                }
            }
        } else if (sheduleState.value.sheduleList.isEmpty() && sheduleState.value.isLoading){
        LoadingScreen()
            //Log.e("isloadsheduleList", sheduleState.value.sheduleList.isEmpty().toString())
        }
    }
}

@Composable
fun OnePairInDayShedule(
    beginTime: String,
    endingTime: String,
    scheduleItem: SheduleModel,
    backlight: Boolean = false
) {
    // Получаем текущее время
    val currentTime = LocalTime.of(8,10)
    // Форматируем время из строк в LocalTime
    val formatter = DateTimeFormatter.ofPattern("H:mm")
    val beginLocalTime = LocalTime.parse(beginTime, formatter)
    val endLocalTime = LocalTime.parse(endingTime, formatter)

    // Проверяем, попадает ли текущее время в диапазон
    val isCurrentPair = currentTime.isAfter(beginLocalTime) && currentTime.isBefore(endLocalTime)

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp, 5.dp)
                .fillMaxSize(.15f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(beginTime)
            }
            Row {
                Text(endingTime)
            }
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                thickness = 10.dp,
                color = Color.Black
            )
        }
        VerticalDivider(
            Modifier
                .width(0.dp)
                .height(38.dp)
                .border(width = 2.dp, MaterialTheme.colorScheme.primaryContainer)
        )
        Column(
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = if (isCurrentPair && backlight) Color(0xFFA6C6FA) else Color.Transparent,
                        shape = RoundedCornerShape(20)
                    ),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = scheduleItem.subj,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterStart)
                )
                if (isCurrentPair && backlight) {
                    TrainAnimationLottie(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .fillMaxHeight()
                    )
                }
            }
        }


        /*Column(
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    /*.background(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )*/
                    .background(
                        if (isCurrentPair && backlight) Color(0xFFA6C6FA) else Color.Transparent,
                        shape = RoundedCornerShape(20)
                    ), // Подсветка текущей пары
            ) {
                Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp, 0.dp))
                if (isCurrentPair && backlight) {
                    TrainAnimationLottie()
                }
            }
        }*/
    }
}

@Composable
fun createCurrentDayBox(schedule: List<SheduleModel>) {
    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxSize(1f)
            .border(4.dp, color = Color(0xFFA6C6FA), shape = RoundedCornerShape(16.dp))
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(16.dp)
            )

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 10.dp),
        ) {
            Text("Сегодня", fontSize = 20.sp)
        }
        for (scheduleItem in schedule) {
            when (scheduleItem.time) {
                0 -> OnePairInDayShedule("8:00", "9:35", scheduleItem,backlight = true)
                1 -> OnePairInDayShedule("9:45", "11:20", scheduleItem,backlight = true)
                2 -> OnePairInDayShedule("11:30", "13:05", scheduleItem,backlight = true)
                3 -> OnePairInDayShedule("13:55", "15:30", scheduleItem,backlight = true)
                4 -> OnePairInDayShedule("15:40", "17:15", scheduleItem,backlight = true)
            }
        }
        Spacer(Modifier.padding(5.dp))
    }
}

/*@Composable
fun createCurrentDayBox(schedule: List<SheduleModel>) {

    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxSize(1f)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 10.dp),

            ) {
            Text("Сегодня", fontSize = 20.sp)
        }
        for (scheduleItem in schedule) {
            when (scheduleItem.time) {
                0 -> OnePairInDayShedule("8:00","9:35", scheduleItem)

                1 -> OnePairInDayShedule("9:45","11:20", scheduleItem)


                2 -> OnePairInDayShedule("11:30","13:05", scheduleItem)


                3 -> OnePairInDayShedule("13:55","15:30", scheduleItem)


                4 -> OnePairInDayShedule("15:40","17:15", scheduleItem)
                /*Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("15:40")
                        }
                        Row {
                            Text("17:15")
                        }
                        VerticalDivider(
                            modifier = Modifier
                                .width(1.dp)
                                .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                            thickness = 10.dp,
                            color = Color.Black
                        )
                    }
                    VerticalDivider(
                        Modifier
                            .width(0.dp)
                            .height(38.dp)
                            .border(width = 2.dp, MaterialTheme.colorScheme.primaryContainer)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    shape = RoundedCornerShape(8.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }*/
            }
        }
    }
}*/

@Composable
fun createDayBox(dayOfWeek: String, schedule: List<SheduleModel>,currentDay: Int) {

    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp)
            .fillMaxSize(1f)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp, 10.dp),

            ) {

            Text(getCurrentDate(dayOfWeek,currentDay.toLong()), fontSize = 20.sp)
        }
        for (scheduleItem in schedule) {
            when (scheduleItem.time) {
                0 -> OnePairInDayShedule("8:00","9:35", scheduleItem)

                1 -> OnePairInDayShedule("9:45","11:20", scheduleItem)


                2 -> OnePairInDayShedule("11:30","13:05", scheduleItem)


                3 -> OnePairInDayShedule("13:55","15:30", scheduleItem)


                4 -> OnePairInDayShedule("15:40","17:15", scheduleItem)
                /*Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(.25f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text("15:40")
                        }
                        Row {
                            Text("17:15")
                        }
                        VerticalDivider(
                            modifier = Modifier
                                .width(1.dp)
                                .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                            thickness = 10.dp,
                            color = Color.Black
                        )
                    }
                    VerticalDivider(
                        Modifier
                            .width(0.dp)
                            .height(38.dp)
                            .border(width = 2.dp, MaterialTheme.colorScheme.primaryContainer)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp, 10.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    shape = RoundedCornerShape(8.dp),
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                )
                        ) {
                            Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
                        }
                    }
                }*/
            }
        }
    }
}


@Composable
fun TextInLazyColumns(
    columnName: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            text = columnName, style = style, textAlign = TextAlign.Center
        )
    }
}



/*@Composable
fun OnePairInDayShedule(
    beginTime : String,
    endingTime: String,
    scheduleItem : SheduleModel,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxSize(.25f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(beginTime)
            }
            Row {
                Text(endingTime)
            }
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(IntrinsicSize.Min), // Ограничиваем высоту делителя
                thickness = 10.dp,
                color = Color.Black
            )
        }
        VerticalDivider(
            Modifier
                .width(0.dp)
                .height(38.dp)
                .border(width = 2.dp, MaterialTheme.colorScheme.primaryContainer)
        )
        Column(
            modifier = Modifier
                .padding(10.dp, 10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
            ) {
                Text(scheduleItem.subj, color = Color.Black, modifier = Modifier.padding(5.dp,0.dp))
            }
        }
    }
}*/

/*@Composable
fun getCurrentDate(currentDay:String,valu: Int): String {
    val calendar = Calendar.getInstance()
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
    var dayresult = ""
    //var mapDay = mapOf("Понедельник" to 1,"Вторник" to 2,"Среда" to 3,"Четверг" to 4,"Пятница" to 5,"Суббота" to 6,"Воскресенье" to 7)



    //mapDay.forEach{entity ->
    when (currentDay) {
        "Понедельник" -> dayresult = "${day.minus(valu) + 1}.${month}Понедельник"
        "Вторник" -> dayresult = "${day.minus(valu) + 2}.${month}Вторник"
        "Среда" -> dayresult = "${day.minus(valu) + 3}.${month}Cреда"
        "Четверг" -> dayresult = "${day.minus(valu) + 4}.${month}Четвер"
        "Пятница" -> dayresult = "${day.minus(valu) + 5}.${month}Пятница"
        "Суббота" -> dayresult = "${day.minus(valu) + 6}.${month}Суббота"
        "Воскресенье" -> dayresult = "${day.minus(valu) + 7}.${month}Воскресенье"
    }
    // }


    return dayresult
    // println(mapDay)
    /* val day_of_week =  LocalDate.now().dayOfWeek.name
     val time = LocalDate.now().atTime(LocalTime.now())
     val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
     val year = calendar.get(Calendar.YEAR)*/
    // return "$day." + "$day_of_week" + "$time"
}*/

@SuppressLint("NewApi")
fun getCurrentDate(currentDay:String, valu: Long): String {
    var dayresult = ""

    val dtf = DateTimeFormatter.ofPattern("dd.MM ")
    val now = LocalDate.now()// Текущая дата

    when (currentDay) {
        "Понедельник" -> dayresult = now.minusDays(valu).plusDays(1).format(dtf).toString() + "Понедельник"
        "Вторник" -> dayresult = now.minusDays(valu).plusDays(2).format(dtf).toString() + "Вторник"
        "Среда"  -> dayresult = now.minusDays(valu).plusDays(3).format(dtf).toString() + "Среда"
        "Четверг" -> dayresult = now.minusDays(valu).plusDays(4).format(dtf).toString() + "Четверг"
        "Пятница" -> dayresult = now.minusDays(valu).plusDays(5).format(dtf).toString() + "Пятница"
        "Суббота" -> dayresult = now.minusDays(valu).plusDays(6).format(dtf).toString() + "Суббота"
        "Воскресенье" -> dayresult = now.minusDays(valu).plusDays(7).format(dtf).toString() + "Воскресенье"
    }
    return dayresult

}

@SuppressLint("NewApi")
fun checkWeek():Int {
    val currentTime = LocalDateTime.now()
    val currentYear = currentTime.year

    // Определяем дату начала учебного года
    val startOfSchoolYear: LocalDate
    if (currentTime.monthValue < 9) {
        startOfSchoolYear = LocalDate.of(currentYear - 1, 9, 1)
    } else {
        startOfSchoolYear = LocalDate.of(currentYear, 9, 1)
    }

    // Получаем номер недели для начала учебного года и текущей даты
    val weekFields = WeekFields.of(Locale.getDefault())
    val startWeek = startOfSchoolYear.get(weekFields.weekOfWeekBasedYear())
    val currentWeek = currentTime.toLocalDate().get(weekFields.weekOfWeekBasedYear())

    // Проверяем, четная ли неделя
    if ((currentWeek - startWeek + 1) % 2 == 0) {
        return  1
    } else {
        return 0
    }
}