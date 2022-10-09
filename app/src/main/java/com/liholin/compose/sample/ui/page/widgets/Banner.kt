package com.liholin.compose.sample.ui.page.widgets

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.liholin.compose.sample.R
import com.liholin.compose.sample.bean.BannerData
import kotlinx.coroutines.delay

/**
 * 轮播图
 * [timeMillis] 停留时间
 * [loadImage] 加载中显示的布局
 * [indicatorAlignment] 指示点的的位置,默认是轮播图下方的中间,带一点padding
 * [onClick] 轮播图点击事件
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banner(
    list: List<BannerData>?,
    timeMillis: Long = 5000,
    @DrawableRes loadImage: Int = R.mipmap.no_banner,
    indicatorAlignment: Alignment = Alignment.BottomCenter,
    modifier: Modifier = Modifier,
    onClick: (link: String, title: String) -> Unit
) {

    Box(
        modifier = modifier
    ) {

        if (list == null) {
            //加载中的图片
            Image(
                painterResource(loadImage),
                modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(8.dp)),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        } else {
            val pagerState = rememberPagerState(
                //初始页面
                initialPage = 0
            )

            //监听动画执行
            var executeChangePage by remember { mutableStateOf(false) }
            var currentPageIndex = 0

            //自动滚动
            LaunchedEffect(pagerState.currentPage, executeChangePage) {
                if (pagerState.pageCount > 0) {
                    delay(timeMillis)
                    //这里直接+1就可以循环，前提是infiniteLoop == true
                    pagerState.animateScrollToPage((pagerState.currentPage + 1) % (pagerState.pageCount))
                }
            }

            HorizontalPager(
                count = list.size,
                state = pagerState,
                modifier = Modifier
                    .pointerInput(pagerState.currentPage) {
                        awaitPointerEventScope {
                            while (true) {
                                //PointerEventPass.Initial - 本控件优先处理手势，处理后再交给子组件
                                val event = awaitPointerEvent(PointerEventPass.Initial)
                                //获取到第一根按下的手指
                                val dragEvent = event.changes.firstOrNull()
                                when {
                                    //当前移动手势是否已被消费
                                    dragEvent!!.positionChangeConsumed() -> {
                                        return@awaitPointerEventScope
                                    }
                                    //是否已经按下(忽略按下手势已消费标记)
                                    dragEvent.changedToDownIgnoreConsumed() -> {
                                        //记录下当前的页面索引值
                                        currentPageIndex = pagerState.currentPage
                                    }
                                    //是否已经抬起(忽略按下手势已消费标记)
                                    dragEvent.changedToUpIgnoreConsumed() -> {
                                        //当pageCount大于1，且手指抬起时如果页面没有改变，就手动触发动画
                                        if (currentPageIndex == pagerState.currentPage && pagerState.pageCount > 1) {
                                            executeChangePage = !executeChangePage
                                        }
                                    }
                                }
                            }
                        }
                    }
                    .clickable {
                        with(list[pagerState.currentPage]) {
                            onClick.invoke(linkUrl, title)
                        }
                    }
                    .fillMaxSize(),
            ) { page ->
                Image(
                    painter = rememberAsyncImagePainter(list[page].imageUrl),
                    modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Box(
                modifier = Modifier
                    .align(indicatorAlignment)
                    .padding(bottom = 6.dp, start = 6.dp, end = 6.dp)
            ) {

                //指示点
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    for (i in list.indices) {
                        //大小
                        var size by remember { mutableStateOf(5.dp) }
                        size = if (pagerState.currentPage == i) 7.dp else 5.dp

                        //颜色
                        val color =
                            if (pagerState.currentPage == i) Color(0xffda3897) else Color.Gray

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(color)
                                //当size改变的时候以动画的形式改变
                                .animateContentSize()
                                .size(size)
                        )
                        //指示点间的间隔
                        if (i != list.lastIndex) Spacer(
                            modifier = Modifier
                                .height(0.dp)
                                .width(4.dp)
                        )
                    }
                }

            }
        }

    }
}