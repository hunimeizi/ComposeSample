package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.liholin.compose.sample.uiutils.dpHeight
import com.liholin.compose.sample.uiutils.dpWidth
import com.liholin.compose.sample.R

@Composable
fun MyOrderView() {
    Column(Modifier
        .padding(start = 34.dpWidth, end = 34.dpWidth, top = 27.dpWidth)
        .fillMaxWidth()
        .height(320.dpHeight)
        .clip(RoundedCornerShape(4.dp))
        .background(Color.White)) {
        Text(text = "我的订单",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 36.dpWidth, top = 37.dpWidth),
            fontWeight = FontWeight.Bold,
            color = Color.Black)
        Row(Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Column(modifier = Modifier.weight(1f).fillMaxHeight(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_dfk),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 26.dpWidth)
                        .width(72.dpWidth).height(68.dpHeight).unReadTip())
                Text(text = "代付款", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_dfh),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 26.dpWidth)
                        .width(72.dpWidth).height(68.dpHeight))
                Text(text = "待发货", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_dfk),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 26.dpWidth)
                        .width(72.dpWidth).height(68.dpHeight))
                Text(text = "待收货", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_th),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 18.dpWidth)
                        .width(73.dpWidth).height(76.dpHeight))
                Text(text = "退货", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_qbdd),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 19.dpWidth)
                        .width(62.dpWidth).height(78.dpHeight))
                Text(text = "全部订单", fontSize = 12.sp, color = Color.Black)
            }
        }
    }
}