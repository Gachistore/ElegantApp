package com.example.elegantapp

import androidx.lifecycle.ViewModel
import com.example.elegantapp.data.ElegantUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ElegantViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ElegantUiState())
    val uiState: StateFlow<ElegantUiState> = _uiState.asStateFlow()


}