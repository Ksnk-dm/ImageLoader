package com.dm.imageloader.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dm.imageloader.presentation.screens.HomeScreen
import com.dm.imageloader.presentation.theme.ImageLoaderTheme
import com.dm.imageloader.presentation.viewmodels.HomeScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageLoaderTheme {
                val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
                HomeScreen(state = homeScreenViewModel.state) {
                    homeScreenViewModel.onEvent(it)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ImageLoaderTheme {
       // Greeting("Android")
    }
}