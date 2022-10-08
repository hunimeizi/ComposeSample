package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.liholin.compose.sample.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liholin.compose.sample.uiutils.dpHeight
import com.liholin.compose.sample.uiutils.dpWidth

@Composable
fun MineTopView() {
    Box {
        MinePersonal()
        WSViewTip()
    }
}

@Composable
fun WSViewTip() {
    Box(Modifier
        .padding(start = 31.dpWidth, end = 31.dpWidth, top = 386.dpWidth)
        .fillMaxWidth()
        .height(187.dpWidth)
        .clip(RoundedCornerShape(8.dp))
        .background(Color(0xfff3e5fa))) {
        Column(modifier = Modifier.padding(start = 92.dpWidth, top = 37.dpWidth, end = 92.dpWidth)) {
            Row {
                Image(painterResource(id = R.mipmap.icon_level), contentDescription = null,
                modifier = Modifier
                    .width(70.dpWidth)
                    .height(47.dpHeight))
                Text(text = "3级城市合伙人", fontSize = 16.sp, color = Color(0xff976020),
                modifier = Modifier.padding(start = 15.dpWidth))
            }
            Text(text = "距离4级城市合伙人不远啦，多多推广吧", fontSize = 12.sp, color = Color(0xff976020),
                modifier = Modifier.padding(top = 20.dpWidth))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreMineTop() {
    MineTopView()
}