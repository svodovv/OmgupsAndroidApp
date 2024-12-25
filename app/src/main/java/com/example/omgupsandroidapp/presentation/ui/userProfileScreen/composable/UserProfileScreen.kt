package com.omgupsapp.presentation.ui.userProfileScreen.composable

import android.content.ClipData.Item
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.room.util.TableInfo
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.presentation.components.coilImage.CoilImage
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.userProfileScreen.UserProfileViewModel
import com.example.omgupsandroidapp.presentation.utils.portable
import com.omgupsapp.presentation.Screen

@Composable
fun UserProfileScreen(
    navController: NavController,
    paddingValues: PaddingValues,
    userProfileViewModel: UserProfileViewModel = hiltViewModel()
) {
    val userProfileState = userProfileViewModel.userProfileState.collectAsStateWithLifecycle().value
    val userPhotoProfileState = userProfileViewModel.userPhotoState.collectAsStateWithLifecycle().value
    val scrollState = rememberScrollState()
    val orientation = LocalConfiguration.current.orientation

    Log.e("htmlContent", userPhotoProfileState.userPhoto.photoUrl)
    when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    //.scrollable(scrollState,orientation = Orientation.Horizontal)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(paddingValues)
            ) {
                if (userProfileState.userProfile != null) {
                    userPhotoProfileState.let { userPhoto ->
                        userProfileState.userProfile.let { userProfile ->
                            Box(
                                modifier = Modifier.weight(3f),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Box(modifier = Modifier.size(135.dp).background(shape = RoundedCornerShape(135.dp), color = MaterialTheme.colorScheme.primaryContainer)) {
                                            CoilImage(
                                                modifier = Modifier.fillMaxSize(),
                                                imageUrl = userPhoto.userPhoto.photoUrl,
                                                contentDescription = stringResource(R.string.user_photo),
                                                defaultImageResId = R.drawable.ic_outilineprofile
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Row(
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = userProfile.username.portable(2),
                                            modifier = Modifier.fillMaxWidth(),
                                            style = MaterialTheme.typography.titleLarge,
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colorScheme.surfaceVariant
                                        )
                                    }
                                }
                            }
                            Card(
                                modifier = Modifier
                                    .weight(6f)
                                    .fillMaxSize(), shape = RoundedCornerShape(
                                    topStart = 38.dp,
                                    topEnd = 38.dp,
                                    bottomEnd = 0.dp,
                                    bottomStart = 0.dp
                                )
                            ) {

                                Column(
                                    modifier = Modifier
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .fillMaxHeight()
                                        .padding(10.dp)
                                ) {
                                    RowInProfile(
                                        rowName = "Институт:",
                                        title = userProfile.faculty,
                                        dividerIsVisible = false
                                    )
                                    RowInProfile(rowName = "Группа:", title = userProfile.group)
                                    RowInProfile(
                                        rowName = "Курс:",
                                        title = userProfile.course.toString()
                                    )
                                    RowInProfile(
                                        rowName = "Статус обучения:",
                                        title = userProfile.status
                                    )
                                    RowInProfile(
                                        rowName = "Форма обучения:",
                                        title = userProfile.formEducation
                                    )
                                    RowInProfile(
                                        rowName = "Зачетная книжка:",
                                        title = userProfile.recordBook
                                    )
                                    RowInProfile(
                                        rowName = "№ Приказа:",
                                        title = userProfile.orderNumber
                                    )

                                }
                            }
                        }
                    }
                } else {
                    LoadingScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
        Configuration.ORIENTATION_LANDSCAPE -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(paddingValues)
            ) {
                if (userProfileState.userProfile != null) {
                    userPhotoProfileState.let { userPhoto ->
                    userProfileState.userProfile.let { userProfile ->
                    //    item {
                            Box(
                              //  modifier = Modifier.weight(3f),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Row(
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Box(modifier = Modifier.size(135.dp).background(shape = RoundedCornerShape(135.dp), color = MaterialTheme.colorScheme.primaryContainer)) {
                                            CoilImage(
                                                modifier = Modifier.fillMaxSize(),
                                                imageUrl = userPhoto.userPhoto.photoUrl,
                                                contentDescription = stringResource(R.string.user_photo),
                                                defaultImageResId = R.drawable.ic_outilineprofile
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Row(
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = userProfile.username.portable(2),
                                            modifier = Modifier.fillMaxWidth(),
                                            style = MaterialTheme.typography.titleLarge,
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colorScheme.surfaceVariant
                                        )
                                    }
                                }
                            }
                      //  }
                        //item {
                        Spacer(modifier = Modifier.padding(5.dp))
                        Column {
                            Card(
                                modifier = Modifier
                                    //.weight(6f)
                                    .fillMaxWidth(), shape = RoundedCornerShape(
                                    topStart = 38.dp,
                                    topEnd = 38.dp,
                                    bottomEnd = 0.dp,
                                    bottomStart = 0.dp
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .background(MaterialTheme.colorScheme.surfaceVariant)
                                        .fillMaxHeight()
                                        .padding(10.dp)
                                ) {
                                    RowInProfile(
                                        rowName = "Институт:",
                                        title = userProfile.faculty,
                                        dividerIsVisible = false
                                    )
                                    RowInProfile(rowName = "Группа:", title = userProfile.group)
                                    RowInProfile(
                                        rowName = "Курс:",
                                        title = userProfile.course.toString()
                                    )
                                    RowInProfile(
                                        rowName = "Статус обучения:",
                                        title = userProfile.status
                                    )
                                    RowInProfile(
                                        rowName = "Форма обучения:",
                                        title = userProfile.formEducation
                                    )
                                    RowInProfile(
                                        rowName = "Зачетная книжка:",
                                        title = userProfile.recordBook
                                    )
                                    RowInProfile(
                                        rowName = "№ Приказа:",
                                        title = userProfile.orderNumber
                                    )
                                    Spacer(modifier = Modifier.padding(30.dp))
                                }
                            }
                        //}
                    }
                        }
                        }
                } else {
                    //item {
                        LoadingScreen(
                            modifier = Modifier
                                .fillMaxSize()
                            //.align(Alignment.CenterHorizontally)
                        )
                    //}
                }
            }
        }
    }
    /*Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(MaterialTheme.colorScheme.primary)
            .padding(paddingValues),
    ) {
        if (userProfileState.userProfile != null) {

            userProfileState.userProfile.let { userProfile ->
                //    item {
                Box(
                    //  modifier = Modifier.weight(3f),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Box(modifier = Modifier.size(135.dp)) {
                                CoilImage(
                                    modifier = Modifier.fillMaxSize(),
                                    imageUrl = userProfile.photoUrl,
                                    contentDescription = stringResource(R.string.user_photo),
                                    defaultImageResId = R.drawable.ic_outilineprofile
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = userProfile.username.portable(2),
                                modifier = Modifier.fillMaxWidth(),
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    }
                }
                //  }
                //item {
                Column(
                    modifier = Modifier.fillMaxHeight()
                ){
                    Card(
                        modifier = Modifier
                            //.weight(6f)
                            .fillMaxSize(), shape = RoundedCornerShape(
                            topStart = 38.dp,
                            topEnd = 38.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .fillMaxHeight()
                                .padding(10.dp)
                        ) {
                            RowInProfile(
                                rowName = "Институт:",
                                title = userProfile.faculty,
                                dividerIsVisible = false
                            )
                            RowInProfile(rowName = "Группа:", title = userProfile.group)
                            RowInProfile(
                                rowName = "Курс:",
                                title = userProfile.course.toString()
                            )
                            RowInProfile(
                                rowName = "Статус обучения:",
                                title = userProfile.status
                            )
                            RowInProfile(
                                rowName = "Форма обучения:",
                                title = userProfile.formEducation
                            )
                            RowInProfile(
                                rowName = "Зачетная книжка:",
                                title = userProfile.recordBook
                            )
                            RowInProfile(
                                rowName = "№ Приказа:",
                                title = userProfile.orderNumber
                            )

                        }
                    }
                }
                //}
            }
        } else {
            //item {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                LoadingScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        //.align(Alignment.CenterHorizontally)
                )
                //}
            }
        }
    } */ // Код для 2 экранов кратко
    /*Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(paddingValues)
            .scrollable(scrollState,orientation = Orientation.Horizontal),
            //.verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center
    ) {
        if (userProfileState.userProfile != null) {

            userProfileState.userProfile.let { userProfile ->

               Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    //.verticalScroll(scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                        Column(
                            modifier = Modifier
                                .weight(3f)
                            // .verticalScroll(rememberScrollState()),
                            //.padding(16.dp),

                            //.verticalScroll(rememberScrollState())
                            //horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Spacer(modifier = Modifier.padding(vertical = 5.dp))
                            Row(
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Box(modifier =  Modifier.size(120.dp, 120.dp)){
                                CoilImage(
                                    modifier = Modifier.fillMaxSize(),
                                    imageUrl = userProfile.photoUrl,
                                    contentDescription = stringResource(R.string.user_photo),
                                    defaultImageResId = R.drawable.ic_outilineprofile
                                )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.padding(vertical = 5.dp))


                        Row(
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = userProfile.username.portable(2),
                                modifier = Modifier.fillMaxWidth(),
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                        Spacer(modifier = Modifier.padding(vertical = 5.dp))


                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(7f), shape = RoundedCornerShape(
                                topStart = 38.dp,
                                topEnd = 38.dp,
                                bottomEnd = 0.dp,
                                bottomStart = 0.dp
                            )
                        ) {

                            Column(
                                modifier = Modifier
                                    .background(MaterialTheme.colorScheme.surfaceVariant)
                                    .fillMaxHeight()
                                    .padding(10.dp)
                            ) {
                                RowInProfile(
                                    rowName = "Институт:",
                                    title = userProfile.faculty,
                                    dividerIsVisible = false
                                )
                                RowInProfile(rowName = "Группа:", title = userProfile.group)
                                RowInProfile(
                                    rowName = "Курс:",
                                    title = userProfile.course.toString()
                                )
                                RowInProfile(
                                    rowName = "Статус обучения:",
                                    title = userProfile.status
                                )
                                RowInProfile(
                                    rowName = "Форма обучения:",
                                    title = userProfile.formEducation
                                )
                                RowInProfile(
                                    rowName = "Зачетная книжка:",
                                    title = userProfile.recordBook
                                )
                                RowInProfile(
                                    rowName = "№ Приказа:",
                                    title = userProfile.orderNumber
                                )

                            }
                        }

                }
            }
        } else {
            LoadingScreen(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally))
        }
    }*/
   /* Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(scrollState,orientation = Orientation.Horizontal)
            .background(MaterialTheme.colorScheme.primary)
            .padding(paddingValues)

            //.horizontalScroll(rememberScrollState())
    ) {
        if (userProfileState.userProfile != null) {

            userProfileState.userProfile.let { userProfile ->
               Box (
                   modifier = Modifier.weight(3f),
                   contentAlignment = Alignment.Center
               ) {
                   Column(
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       Row(
                           horizontalArrangement = Arrangement.Center
                       ) {
                           Box(modifier = Modifier.size(120.dp)) {
                               CoilImage(
                                   modifier = Modifier.fillMaxSize(),
                                   imageUrl = userProfile.photoUrl,
                                   contentDescription = stringResource(R.string.user_photo),
                                   defaultImageResId = R.drawable.ic_outilineprofile
                               )
                           }
                       }
                       Spacer(modifier = Modifier.padding(5.dp))
                       Row(
                           horizontalArrangement = Arrangement.Center
                       ) {
                           Text(
                               text = userProfile.username.portable(2),
                               modifier = Modifier.fillMaxWidth(),
                               style = MaterialTheme.typography.titleLarge,
                               textAlign = TextAlign.Center,
                               color = MaterialTheme.colorScheme.surfaceVariant
                           )
                       }
                   }
               }
                Card(
                    modifier = Modifier
                        .weight(6f)
                        .fillMaxSize(), shape = RoundedCornerShape(
                        topStart = 38.dp,
                        topEnd = 38.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                ) {

                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .fillMaxHeight()
                            .padding(10.dp)
                    ) {
                        RowInProfile(
                            rowName = "Институт:",
                            title = userProfile.faculty,
                            dividerIsVisible = false
                        )
                        RowInProfile(rowName = "Группа:", title = userProfile.group)
                        RowInProfile(
                            rowName = "Курс:",
                            title = userProfile.course.toString()
                        )
                        RowInProfile(
                            rowName = "Статус обучения:",
                            title = userProfile.status
                        )
                        RowInProfile(
                            rowName = "Форма обучения:",
                            title = userProfile.formEducation
                        )
                        RowInProfile(
                            rowName = "Зачетная книжка:",
                            title = userProfile.recordBook
                        )
                        RowInProfile(
                            rowName = "№ Приказа:",
                            title = userProfile.orderNumber
                        )

                    }
                }
               }
            } else {
            LoadingScreen(modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally))
        }
    }*/
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

