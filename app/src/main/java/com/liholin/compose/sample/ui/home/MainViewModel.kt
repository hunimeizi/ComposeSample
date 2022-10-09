package com.liholin.compose.sample.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var phone by mutableStateOf("1866677889")
    var homeIndex by mutableStateOf(0)
    var homeCount by mutableStateOf(12)
}