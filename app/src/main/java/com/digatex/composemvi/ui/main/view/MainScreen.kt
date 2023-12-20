package com.digatex.composemvi.ui.main.view

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.digatex.composemvi.data.model.UserModel
import com.digatex.composemvi.ui.compose.ListItem
import com.digatex.composemvi.ui.main.viewmodel.MainViewModel
import com.digatex.composemvi.ui.main.viewstate.MainState
import com.digatex.composemvi.ui.theme.ComposeMVITheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel,
    onTextClickAction: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    ComposeMVITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
            ) {

                item {
                    Text(
                        text = "Click me!",
                        modifier = Modifier.clickable { onTextClickAction() }
                    )
                }
                when (state) {
                    is MainState.Loading -> {
                        item {
                            CustomProgressBar()
                        }
                    }
                    is MainState.Users -> {
                        this.addUserInfo((state as MainState.Users).userModel)

                    }
                    is MainState.Error -> {

                    }
                    else -> {

                    }
                }
            }
        }

    }
}

@Composable
private fun CustomProgressBar() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(80.dp),
            color = Color.Red,
            strokeWidth = 5.dp
        )
    }
}

private fun LazyListScope.addUserInfo(usersList: List<UserModel>) {
    items(usersList) { user ->
        ListItem(
            user,
            backgroundColor = Color.White,
            onItemClick = {
                Log.i("UsersList", "Info $user")
            },
        )
    }
}
