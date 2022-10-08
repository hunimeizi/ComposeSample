package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MineView() {
    Column(Modifier
        .fillMaxSize()
        .background(Color(0xfff1f2f6))
        .verticalScroll(rememberScrollState())
    ) {
        MineTopView()
        MemberView()
        MoneyView()
        MyOrderView()
        ManageService()
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview
@Composable
fun PrevMineView() {
   MineView()
}