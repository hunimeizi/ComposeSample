package com.liholin.compose.sample.ui.page.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.liholin.compose.sample.R
import com.liholin.compose.sample.bean.BannerData
import com.liholin.compose.sample.ui.page.widgets.Banner
import com.liholin.compose.sample.uiutils.dpHeight
import com.liholin.compose.sample.uiutils.dpWidth

@Composable
fun MallTopView() {
    Box {
        Box(Modifier
            .fillMaxWidth()
            .height(641.dpHeight)) {
            Image(painterResource(id = R.mipmap.icon_mine_back),
                contentDescription = null,
                Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
            Row(Modifier.fillMaxWidth()) {
                Image(painterResource(id = R.mipmap.icon_yilife_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 32.dpWidth, top = 101.dpWidth, end = 13.dpWidth)
                        .size(97.dpWidth))
                Image(painterResource(id = R.mipmap.icon_yishenghuo), contentDescription = null,
                    modifier = Modifier
                        .padding(top = 114.dpWidth, end = 180.dpWidth)
                        .width(279.dpWidth)
                        .height(74.dpHeight))
                Image(painterResource(id = R.mipmap.head_pic), contentDescription = null,
                    modifier = Modifier
                        .padding(top = 107.dpWidth, end = 15.dpWidth)
                        .size(100.dpWidth))
                Text(text = "张二喜", color = Color.White, fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 130.dpWidth)
                        .weight(1f), maxLines = 1)
                Box {
                    Image(painterResource(id = R.mipmap.icon_store_share),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 29.dpWidth, top = 131.dpWidth)
                            .width(141.dpWidth)
                            .height(56.dpHeight))
                    Text(text = "小店分享", fontSize = 10.sp, color = Color(0xffD90193),
                        modifier = Modifier
                            .padding(end = 30.dpWidth, top = 131.dpWidth)
                            .align(Alignment.Center))
                }
            }
        }
        Banner(list = listOf(BannerData("旅行好伴侣",
            "https://img.zcool.cn/community/01af4959226b6eb5b3086ed4b06827.jpg@1280w_1l_2o_100sh.jpg",
            "https://www.ctrip.com/?allianceid=5376&sid=153480&ouid=000401app&qhclickid=2a84021b458b3746&keywordid=8119226793"),
            BannerData("智能家居",
                "https://img.zcool.cn/community/0108605d62d301a80120695ce557eb.jpg@1280w_1l_2o_100sh.jpg",
                "https://consumer.huawei.com/cn/wholehome/"),
            BannerData("秋冬新品",
                "https://www.ficgra.cn/design/wp-content/uploads/2019/03/fuzhuangbanner.png",
                "https://www.taobao.com/")),
            modifier = Modifier
                .padding(top = 231.dpWidth)
                .fillMaxWidth()
                .height(563.dpHeight),
            onClick = { link, title ->

            })
    }
}
