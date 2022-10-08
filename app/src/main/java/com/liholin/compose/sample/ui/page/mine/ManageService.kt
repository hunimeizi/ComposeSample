package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
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
fun ManageService() {
    Column(Modifier
        .padding(start = 34.dpWidth, end = 34.dpWidth, top = 27.dpWidth)
        .fillMaxWidth()
        .clip(RoundedCornerShape(4.dp))
        .background(Color.White)) {
        Text(text = "管理服务",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 36.dpWidth, top = 37.dpWidth),
            fontWeight = FontWeight.Bold,
            color = Color.Black)
        Row(Modifier
            .fillMaxWidth()
            .height(324.dpHeight)) {
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_share),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 36.dpWidth)
                        .size(96.dpWidth))
                Text(text = "商品分享", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_ddgl),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 35.dpWidth)
                        .width(78.dpWidth)
                        .height(96.dpHeight))
                Text(text = "订单管理", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_xhgl),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 35.dpWidth)
                        .width(105.dpWidth)
                        .height(92.dpHeight))
                Text(text = "优惠管理", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_jfgl),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 35.dpWidth)
                        .width(91.dpWidth)
                        .height(96.dpHeight))
                Text(text = "积分管理", fontSize = 12.sp, color = Color.Black)
            }
        }
        Divider(modifier = Modifier.padding(start = 35.dpWidth, end = 35.dpWidth).fillMaxWidth().height(2.dpWidth).background(
            Color(0xffcdcdcd)))
        Row(Modifier
            .fillMaxWidth()
            .height(324.dpHeight)) {
            Column(modifier = Modifier.weight(1f).fillMaxHeight(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_ybgl),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 29.dpWidth)
                        .width(105.dpWidth).height(96.dpHeight))
                Text(text = "怡呗管理", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_txgl),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 29.dpWidth)
                        .width(98.dpWidth).height(96.dpHeight))
                Text(text = "提现管理", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_hygl),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 29.dpWidth)
                        .width(103.dpWidth).height(96.dpHeight))
                Text(text = "会员管理", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_wdrw),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 29.dpWidth)
                        .width(98.dpWidth).height(96.dpHeight))
                Text(text = "我的任务", fontSize = 12.sp, color = Color.Black)
            }
        }
        Divider(modifier = Modifier.padding(start = 35.dpWidth, end = 35.dpWidth).fillMaxWidth().height(2.dpWidth).background(
            Color(0xffcdcdcd)))
        Row(Modifier
            .fillMaxWidth()
            .height(324.dpHeight)) {
            Column(modifier = Modifier.weight(1f).fillMaxHeight(), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_personal),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 25.dpWidth)
                        .width(97.dpWidth).height(83.dpHeight))
                Text(text = "个人信息", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_sc),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 23.dpWidth)
                        .width(99.dpWidth).height(96.dpHeight))
                Text(text = "收藏", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_lxkf),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 23.dpWidth)
                        .width(90.dpWidth).height(96.dpHeight))
                Text(text = "联系客服", fontSize = 12.sp, color = Color.Black)
            }
            Column(modifier = Modifier.weight(1f).fillMaxHeight(),verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(id = R.mipmap.icon_setting),
                    contentDescription = null,
                    Modifier
                        .padding(bottom = 24.dpWidth)
                        .width(102.dpWidth).height(96.dpHeight))
                Text(text = "设置", fontSize = 12.sp, color = Color.Black)
            }
        }
    }
}