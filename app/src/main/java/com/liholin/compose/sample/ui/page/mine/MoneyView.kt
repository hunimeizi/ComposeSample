package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.liholin.compose.sample.R
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.liholin.compose.sample.uiutils.dpHeight
import com.liholin.compose.sample.uiutils.dpWidth

@Composable
fun MoneyView() {
    Row(Modifier
        .padding(start = 34.dpWidth, end = 34.dpWidth, top = 30.dpWidth)
        .fillMaxWidth()
        .height(195.dpHeight)
        .background(Color(0xfffef6e6))) {
        Column(Modifier
            .weight(1f)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Text(text = "我的积分", fontSize = 12.sp, color = Color(0xffCC873C))
            Image(painterResource(id = R.mipmap.icon_mine_right), contentDescription = null,
                modifier = Modifier.padding(start = 4.dpWidth).width(13.dpWidth).height(20.dpHeight))
            }
            Text(text = "888.88", fontSize = 16.sp, color = Color(0xffAD8860))
        }
//        Divider(Modifier
//            .width(2.dpWidth)
//            .height(163.dpHeight)
//            .background(Color(0xffCC873C))
//            .align(Alignment.CenterVertically))
        Image(painterResource(id = R.mipmap.icon_divider_mine), contentDescription = null,
            Modifier
                .width(2.dpWidth)
                .height(163.dpHeight)
                .align(Alignment.CenterVertically))
        Column(Modifier
            .weight(1f)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "我的怡贝", fontSize = 12.sp, color = Color(0xffCC873C))
                Image(painterResource(id = R.mipmap.icon_mine_right), contentDescription = null,
                    modifier = Modifier.padding(start = 4.dpWidth).width(13.dpWidth).height(20.dpHeight))
            }
            Text(text = "666.66", fontSize = 16.sp, color = Color(0xffAD8860))
        }
//        Divider(Modifier
//            .width(2.dpWidth)
//            .height(163.dpHeight)
//            .background(Color(0xffCC873C))
//            .align(Alignment.CenterVertically))
        Image(painterResource(id = R.mipmap.icon_divider_mine), contentDescription = null,
            Modifier
                .width(2.dpWidth)
                .height(163.dpHeight)
                .align(Alignment.CenterVertically))
        Column(Modifier
            .weight(1f)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(text = "累计提现", fontSize = 12.sp, color = Color(0xffCC873C))
                Image(painterResource(id = R.mipmap.icon_mine_right), contentDescription = null,
                    modifier = Modifier.padding(start = 4.dpWidth).width(13.dpWidth).height(20.dpHeight))
            }
            Text(text = "68.88", fontSize = 16.sp, color = Color(0xffAD8860))
        }
    }
}