package com.omgupsapp.presentation.ui.userProfileScreen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.presentation.components.coilImage.CoilImage
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.userProfileScreen.UserProfileViewModel
import com.example.omgupsandroidapp.presentation.utils.portable

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
            .background(MaterialTheme.colorScheme.secondary)
            .padding(paddingValues)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center
    ) {
        if (userProfileState.userProfile != null) {

            userProfileState.userProfile.let { userProfile ->

                Column(
                    modifier = Modifier
                        .weight(3f)
                        .padding(16.dp)
                ) {


                    CoilImage(
                        modifier = Modifier.size(100.dp).align(Alignment.CenterHorizontally),
                        imageUrl = userProfile.photoUrl,
                        contentDescription = stringResource(R.string.user_photo),
                        defaultImageResId = R.drawable.ic_outilineprofile
                    )

                    Text(
                        text = userProfile.username.portable(2),
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )


                }

                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(7f), shape = RoundedCornerShape(
                        topStart = 38.dp, topEnd = 38.dp, bottomEnd = 0.dp, bottomStart = 0.dp
                    )
                ) {

                    Column(modifier = Modifier.padding(8.dp)) {
                        RowInProfile(
                            rowName = "Институт:",
                            title = userProfile.faculty,
                            dividerIsVisible = false
                        )
                        RowInProfile(rowName = "Группа:", title = userProfile.group)
                        RowInProfile(rowName = "Курс:", title = userProfile.course.toString())
                        RowInProfile(rowName = "Статус обучения:", title = userProfile.status)
                        RowInProfile(rowName = "Форма обучения:", title = userProfile.formEducation)
                        RowInProfile(rowName = "Зачетная книжка:", title = userProfile.recordBook)
                        RowInProfile(rowName = "№ Приказа:", title = userProfile.orderNumber)


                    }
                }
            }
        } else {
            LoadingScreen(modifier = Modifier.fillMaxSize().align(Alignment.CenterHorizontally))
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

