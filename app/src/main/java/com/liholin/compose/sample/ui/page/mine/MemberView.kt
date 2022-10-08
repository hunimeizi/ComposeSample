package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.liholin.compose.sample.uiutils.dpHeight
import com.liholin.compose.sample.uiutils.dpWidth

@Composable
fun MemberView() {
    Row(Modifier.padding(start = 34.dpWidth, end = 34.dpWidth, top = 30.dpWidth)) {
        Column(Modifier
            .weight(1f)
            .padding(end = 43.dpWidth)
            .height(195.dpHeight)
            .background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "会员总数", fontSize = 12.sp, color = Color(0xff9F9498))
            Text(text = "86", fontSize = 16.sp, color = Color(0xffee1992))
        }
        Column(Modifier
            .weight(1f)
            .padding(end = 43.dpWidth)
            .height(195.dpHeight)
            .background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "消费总数", fontSize = 12.sp, color = Color(0xff9F9498))
            Text(text = "36", fontSize = 16.sp, color = Color(0xffee1992))
        }
        Column(Modifier
            .weight(1f)
            .height(195.dpHeight)
            .background(Color.White), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "本周新增", fontSize = 12.sp, color = Color(0xff9F9498))
            Text(text = "6", fontSize = 16.sp, color = Color(0xffee1992))
        }
    }
}