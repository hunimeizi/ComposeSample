package com.liholin.compose.sample.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.liholin.compose.sample.base.BaseApplication
import com.liholin.compose.sample.bean.MallStoreResponseItem
import com.liholin.compose.sample.utils.LocalFileUtils

class MainViewModel : ViewModel() {
    var phone by mutableStateOf("1866677889")
    var homeIndex by mutableStateOf(0)
    var homeCount by mutableStateOf(12)

    fun getStoreData() : MutableList<MallStoreResponseItem>{
        return Gson().fromJson(
            LocalFileUtils.getStringFormAsset(BaseApplication.context, "storeData.json"),
            object : TypeToken<MutableList<MallStoreResponseItem?>?>() {}.type
        )
    }
}