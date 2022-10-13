package com.liholin.compose.sample.ui.page.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.liholin.compose.sample.base.BaseApplication
import com.liholin.compose.sample.bean.MallStoreResponseItem
import com.liholin.compose.sample.ui.home.MainViewModel
import com.liholin.compose.sample.utils.LocalFileUtils

@Composable
fun HomePage() {
//    val refreshState = rememberSmartSwipeRefreshState()
//    val scrollState = rememberLazyListState()
    Column(Modifier
        .fillMaxSize()
        .background(Color(0xfff1f2f6))
        .verticalScroll(rememberScrollState())) {
        MallView()
    }
}

@Composable
fun MallView() {
    Column(Modifier.fillMaxSize()) {
        MallTopView()
        StoreView()
    }
}

@Preview
@Composable
fun PrevHomePage() {
    MallView()
}