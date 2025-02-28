package com.dm.imageloader.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dm.imageloader.core.utils.Resources
import com.dm.imageloader.domain.repository.ImageRepository
import com.dm.imageloader.presentation.screens.HomeScreenEvents
import com.dm.imageloader.presentation.screens.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val imageRepository: ImageRepository
) : ViewModel() {

    var state by mutableStateOf(HomeScreenState())
        private set

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.LoadImages -> {
                loadImages(event.q)
            }

            is HomeScreenEvents.UpdateText -> {
                updateTextField(event.q)
            }
        }
    }

    private fun updateTextField(str: String) {
        state = state.copy(text = str)
    }

    private fun loadImages(q: String) {
        viewModelScope.launch {
            imageRepository.getImages(q).collect { result ->
                when (result) {
                    is Resources.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }

                    is Resources.Success -> {
                        println("Data in View model  ${result.data}")
                        result.data?.let { listings ->
                            state = state.copy(
                                images = listings
                            )
                        }
                    }

                    is Resources.Error -> {
                        state = state.copy(isLoading = false)
                    }
                }
            }
        }
    }
}