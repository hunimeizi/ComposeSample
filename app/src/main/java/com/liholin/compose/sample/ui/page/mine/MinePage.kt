package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MinePage() {
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
        Spacer(modifier = Modifier.height(80.dp))
    }
}


fun Modifier.unReadTip() = this.drawWithContent {
    drawContent()
    drawCircle(Color.Red, 5.dp.toPx(), Offset(size.width - 2.dp.toPx(), 2.dp.toPx()))
}

@Preview
@Composable
fun PrevMineView() {
    MinePage()
}