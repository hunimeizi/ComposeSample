package com.liholin.compose.sample.ui.home

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.liholin.compose.sample.bean.MallStoreResponseItem

@SuppressLint("MutableCollectionMutableState")
class MainViewModel : ViewModel() {
    var phone by mutableStateOf("1866677889")
    var homeIndex by mutableStateOf(0)
    var homeCount by mutableStateOf(12)
    var storeResponse by mutableStateOf(ArrayList<MallStoreResponseItem>())
}