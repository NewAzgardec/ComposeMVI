package com.digatex.composemvi.ui.main.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.digatex.composemvi.data.api.component.DaggerApplicationComponent
import com.digatex.composemvi.data.api.component.DaggerMainComponent
import com.digatex.composemvi.ui.main.intent.MainIntent
import com.digatex.composemvi.ui.main.viewmodel.MainViewModel
import com.digatex.composemvi.ui.main.viewstate.MainState
import com.digatex.composemvi.ui.theme.ComposeMVITheme
import com.digatex.composemvi.util.NavigationDestination
import com.digatex.composemvi.util.daggerViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.create().inject(this)
        setContent {
            val navController = rememberNavController()
            ComposeMVITheme {
                Scaffold(
                    content = {
                        NavHost(
                            navController = navController,
                            startDestination = NavigationDestination.MainScreen.destination
                        ) {

                            composable(NavigationDestination.MainScreen.destination) {
                                val component = DaggerMainComponent.builder().build()
                                val viewModel: MainViewModel = daggerViewModel {
                                    component.getViewModel()
                                }
                                MainScreen(
                                    navController = navController,
                                    viewModel = viewModel
                                ) {
                                    lifecycleScope.launch {
                                        viewModel.userIntent.send(MainIntent.FetchUser)
                                    }
                                }
                            }
                        }
                    }
                )
            }

        }
    }
}
