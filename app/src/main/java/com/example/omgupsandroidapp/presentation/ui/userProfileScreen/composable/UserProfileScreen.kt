package com.omgupsapp.presentation.ui.userProfileScreen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.userProfileScreen.UserProfileViewModel

@Composable
fun UserProfileScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    userProfileViewModel: UserProfileViewModel = hiltViewModel()
) {
    val userProfileState = userProfileViewModel.userProfileState.collectAsStateWithLifecycle().value
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .verticalScroll(scrollState)
    ) {
        if (userProfileState.userProfile != null) {

            userProfileState.userProfile.let { userProfile ->
                Card(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            if (userProfile.imageVector == null) {
                                Image(
                                    painter = painterResource(id = R.drawable.nonprofileimage),
                                    contentDescription = "non image user profile",
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(RoundedCornerShape(50.dp))
                                        .align(Alignment.Center)
                                )
                            } else {
                                TODO()
                            }
                        }
                        Text(
                            text = userProfile.name + " " + userProfile.surname,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = userProfile.patronymic,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )


                    }
                }

                Card(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Column(modifier = Modifier.padding(8.dp)) {
                        RowInProfile(rowName = "Институт:", title = userProfile.institute, dividerIsVisible = false)
                        RowInProfile(rowName = "Специальность:", title = userProfile.specialization)
                        RowInProfile(rowName = "Направление:", title = userProfile.direction)
                        RowInProfile(rowName = "Статус обучения:",title = userProfile.statusEducation)
                        RowInProfile(rowName = "Группа:", title = userProfile.group)
                        RowInProfile(rowName = "Форма обучения:", title = userProfile.formEducation)
                        RowInProfile(rowName = "Тип обучения:", title = userProfile.typeEducation)
                        RowInProfile(rowName = "Уровень образования:",title = userProfile.lvlEducation)
                        RowInProfile(rowName = "Курс:", title = userProfile.course.toString())
                    }
                }
            }
        } else {
            LoadingScreen()
        }
    }
}

@Composable
private fun RowInProfile(
    rowName: String, title: String, dividerIsVisible: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        if (dividerIsVisible) Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 0.8.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )
        Row(modifier = Modifier.padding(top = 4.dp, start = 4.dp, end = 4.dp)) {
            Text(
                text = rowName,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start
            )
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Start
            )
        }
    }
}
