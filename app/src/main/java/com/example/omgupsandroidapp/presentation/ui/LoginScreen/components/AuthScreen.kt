package com.omgupsapp.presentation.ui.LoginScreen.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.omgupsandroidapp.R
import com.example.omgupsandroidapp.presentation.ui.LoadingScreen.LoadingScreen
import com.example.omgupsandroidapp.presentation.ui.screens.LoginScreen.components.OmgupsIcon
import com.example.omgupsandroidapp.presentation.ui.screens.LoginScreen.components.OmgupsIconFon
import com.omgupsapp.presentation.NavigationGroup
import com.omgupsapp.presentation.Screen
import com.omgupsapp.presentation.ui.LoginScreen.AuthViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AuthScreen(
    viewModel: AuthViewModel = hiltViewModel(),
    navController: NavController,
) {
    val stateToken = viewModel.stateToken.value
    val stateAuthentication = viewModel.stateAuthentication.value

    var showError by remember { mutableStateOf(false) }

    LaunchedEffect(stateAuthentication) {
        if (stateAuthentication.userAuthenticated == true) {
            navController.navigate(NavigationGroup.HomeScreens.route) {
                popUpTo(Screen.AuthScreen.route) {
                    inclusive = true
                }
            }
        } else if (stateAuthentication.userAuthenticated == false) {
            viewModel.isNotLoading()
        }
    }

    if (stateToken.csrfToken) {
    if (stateAuthentication.isLoading && !showError) {

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Center)
            )

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {

        Box(modifier = Modifier.fillMaxSize().weight(4f), contentAlignment = Center) {
            OmgupsIcon(
                modifier = Modifier.padding(vertical = 100.dp, horizontal = 130.dp),
            )
        }

        Card(
            modifier = Modifier.weight(6f),
            shape = RoundedCornerShape(
                topStart = 38.dp, // Закругление верхнего левого угла
                topEnd = 38.dp,    // Верхний правый угол без закругления
                bottomEnd = 0.dp, // Закругление нижнего правого угла
                bottomStart = 0.dp // Нижний левый угол без закругления
            ),
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {

                Spacer(modifier = Modifier.padding(50.dp))

                /* ScrollableTextField(
                        value = stateAuthentication.login,
                        onValueChange = {
                            viewModel.onChangeLogin(it)
                            viewModel.userStateAuth()
                            showError = false
                        },
                        label = { Text(
                            text = stringResource(R.string.login),
                            color = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error else Color.Unspecified
                        ) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 66.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,),
                    singleLine = true
                    )*/

                /*EditNumberField(
                            label = R.string.login,
                            leadingIcon = R.drawable.ic_arrow_back,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            value = tipInput,
                            onValueChanged = { tipInput = it },
                            modifier = Modifier.padding(horizontal = 32.dp).fillMaxWidth(),
                        )*/

                AuthTextField(
                    value = stateAuthentication.login,
                    onValueChange = {
                        viewModel.onChangeLogin(it)
                        viewModel.userStateAuth()
                        showError = false
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.login),
                            color = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error else Color.Unspecified
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .padding(horizontal = 35.dp)
                        .fillMaxWidth(),
                    //.padding(horizontal = 66.dp),,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                    ),
                )
                Spacer(modifier = Modifier.padding(10.dp))
                /*OutlinedTextField(
                        value = stateAuthentication.login,
                        onValueChange = {
                            viewModel.onChangeLogin(it)
                            viewModel.userStateAuth()
                            showError = false
                        },
                        label = {
                            Text(
                                text = stringResource(R.string.login),
                                color = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error else Color.Unspecified
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .padding(horizontal = 66.dp)
                            .fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                            else MaterialTheme.colorScheme.outline,
                            unfocusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                            else MaterialTheme.colorScheme.outline,
                        ),
                        singleLine = true
                    )*/

                /*OutlinedTextField(
                            value = stateAuthentication.password,
                            onValueChange = {
                                viewModel.onChangePassword(it)
                                viewModel.userStateAuth()
                                showError = false
                            },

                            /* label = {
                                 Text(
                                     text = stringResource(R.string.Password),
                                     color = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error else Color.Unspecified
                                 )
                             },*/
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 66.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                                else MaterialTheme.colorScheme.outline,
                                unfocusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                                else MaterialTheme.colorScheme.outline,
                            ),
                            singleLine = true
                        )*/
                // Password input
                TextField(
                    value = stateAuthentication.password,
                    onValueChange = {
                        viewModel.onChangePassword(it)
                        viewModel.userStateAuth()
                        showError = false
                    },

                    placeholder = {
                        Text(
                            text = stringResource(R.string.Password),
                            color = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error else Color.Unspecified
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 35.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                        unfocusedBorderColor = if (stateAuthentication.userAuthenticated == false) MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.outline,
                    ),
                    singleLine = true
                )
                /*Spacer(modifier = Modifier.padding(18.dp)))
                    Text(text = "Забыли пароль?", modifier = Modifier.padding(start = 88.dp))
                    Spacer(modifier = Modifier.padding(18.dp))*/
                Spacer(modifier = Modifier.padding(18.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        modifier = Modifier.padding(4.dp, top = 0.dp),
                        horizontalAlignment = CenterHorizontally
                    ) {
                        if (stateAuthentication.userAuthenticated == false) {
                            Text(
                                text = stringResource(R.string.ErrorInLoginOrPassword),
                                color = MaterialTheme.colorScheme.error,
                                textAlign = TextAlign.Center
                            )
                        } else if (showError) {
                            Text(
                                text = stringResource(R.string.LoginOrPasswordIsNull),
                                color = MaterialTheme.colorScheme.error,
                                textAlign = TextAlign.Center
                            )
                        } else Spacer(modifier = Modifier.padding(8.dp))
                    }
                }

                Spacer(modifier = Modifier.padding(18.dp))

               // var isLoading by remember { mutableStateOf(false) }

               /* if (isLoading) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(0.1f),
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Center)
                            )
                        }
                    }
                } else {
                    Button(
                        onClick = {
                            if (stateAuthentication.login.isNotBlank() && stateAuthentication.password.isNotBlank()) {
                                viewModel.userAuthenticated()
                            } else showError = true
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .height(55.dp)
                            .padding(horizontal = 35.dp),
                        enabled = !stateAuthentication.isLoading,
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(stringResource(R.string.signIn), fontSize = 18.sp)
                    }
                }*/
                if (stateAuthentication.isLoading) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(0.1f),
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.align(Center)
                                    )
                                }
                            }
                        }else {
                        // Login button
                        Button(
                            onClick = {
                                if (stateAuthentication.login.isNotBlank() && stateAuthentication.password.isNotBlank()) {
                                    viewModel.userAuthenticated()
                                } else showError = true
                            },
                            modifier = Modifier
                                .fillMaxSize()
                                .height(55.dp)
                                .padding(horizontal = 35.dp),
                            enabled = !stateAuthentication.isLoading,
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(stringResource(R.string.signIn), fontSize = 18.sp)
                        }
                    }
               /* AnimatedVisibility(
                    visible = stateAuthentication.isLoading,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(0.1f),
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Center)
                            )
                        }
                    }
                }

                AnimatedVisibility(
                    visible = !stateAuthentication.isLoading,
                    enter = fadeIn() + scaleIn(),
                    exit = fadeOut() + scaleOut()
                ) {
                    Button(
                        onClick = {
                            if (stateAuthentication.login.isNotBlank() && stateAuthentication.password.isNotBlank()) {
                                viewModel.userAuthenticated()
                            } else showError = true
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .height(55.dp)
                            .padding(horizontal = 35.dp),
                        enabled = !stateAuthentication.isLoading,
                        shape = MaterialTheme.shapes.small
                    ) {
                        Text(stringResource(R.string.signIn), fontSize = 18.sp)
                    }
                }*/
                Spacer(modifier = Modifier.padding(18.dp))
            }
        }
    }
    }else if (stateToken.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            LoadingScreen(modifier = Modifier.align(CenterHorizontally))
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            ErrorScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(CenterHorizontally),
                textError = stateToken.error,
                navController,
                Screen.AuthScreen.route
            )
        }
    }
}

data class TextFieldState(
    var cursorPosition: Int = 0,
    var showCursorHandle: Boolean = false
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    modifier: Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),

) {
        TextField(
            placeholder = placeholder,
            value = value,
            singleLine = true,
            onValueChange = onValueChange,
            modifier = modifier,
            keyboardOptions = keyboardOptions,
            colors = colors,
        )
}
@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        singleLine = true,
       // leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        modifier = modifier,
        onValueChange = onValueChanged,
       // label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions
    )
}
