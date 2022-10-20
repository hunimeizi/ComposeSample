package com.liholin.compose.sample.ui.anim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

class AnimActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
//                ViewAnima()
                AnimatedVis()
            }
        }
    }

    @Composable
    fun AnimatedVis() {
        var show by remember {
            mutableStateOf(true)
        }
        Column {
            AnimatedVisibility(show,/*enter =*/ /*fadeIn(tween())*//*expandVertically(tween(), expandFrom = Alignment.Top)*/) {
                TransitionSquare()
            }
           Button(onClick = {
               show = !show
           }) {
               Text(text = "切换")
           }
        }
    }
    @Preview
    @Composable
    fun TransitionSquare() {
        var big by remember {
            mutableStateOf(false)
        }
        val tan = updateTransition(big, label = "big")
        val size by tan.animateDp({
            if(false isTransitioningTo true) spring() else tween()
        }, label = "size") {
            if(it) 196.dp else 48.dp
        }

        val corner by tan.animateDp(label = "corner") {
            if(it) 0.dp else 8.dp
        }
        Box(Modifier
            .clip(RoundedCornerShape(corner))
            .background(Color.Green)
            .size(size)
            .clickable {
                big = !big
            }) {

        }
    }
}

@Composable
fun ViewAnima() {
    BoxWithConstraints {
        var big by remember {
            mutableStateOf(false)
        }
        val decay = exponentialDecay<Dp>()
        val size by animateDpAsState(if(big) 96.dp else 48.dp)
        val size1 = if(big) 96.dp else 48.dp

        val anim = remember {
            Animatable(size1, Dp.VectorConverter)
        }
        val animY = remember {
            Animatable(size1, Dp.VectorConverter)
        }
        LaunchedEffect(big) {
//            anim.snapTo(if(big) 196.dp else 0.dp) // 初始值
//            anim.animateTo(size1, keyframes {
//                durationMillis = 500
//                delayMillis = 500
//                if(big) 48.dp else 96.dp at 0 with FastOutSlowInEasing
//                144.dp at 150 with FastOutSlowInEasing
//                20.dp at 300 with FastOutSlowInEasing
//            })
//            anim.animateTo(size1, tween(easing = /*FastOutSlowInEasing*//*LinearOutSlowInEasing*//*LinearEasing*/FastOutSlowInEasing))
//            anim.animateTo(size1, snap(300)) // 突变的 300ms
//            anim.animateTo(size1, spring(// 弹簧
//                0.1f, // 阻尼值 数值越小 来回弹频率高
//                Spring.StiffnessMedium, // 刚度 刚度越大 回弹也会高
//                //5.dp // 可视阈值 默认0.01 达到该值后 动画直接停止 防止肉眼已经看不到view动画了 它仍在在回弹 浪费资源
//            ),2000.dp)
//            anim.animateTo(size1, repeatable(2,//执行次数
//                tween(),// 执行动画
//                repeatMode = RepeatMode.Restart,// 执行类型 重复 、倒叙
//                StartOffset(500)//时间的延时、快进
//                ),
//            )
//            anim.animateTo(size1, infiniteRepeatable(tween()))//无线循环

            //以下只是针对惯性动画 animateDecay
//            rememberSplineBasedDecay() 只针对像素
//            exponentialDecay<>() 除了像素以外所有的

            delay(1000)
            var result = anim.animateDecay(4000.dp, decay) //惯性动画
            while(result.endReason == AnimationEndReason.BoundReached) { // 已经达到临界值了 可继续做处理
                result = anim.animateDecay(-result.endState.velocity, decay) // 达到临界值进行反弹
            }
        }
        LaunchedEffect(Unit) {
            delay(1000)
            animY.animateDecay(2000.dp, decay)
        }
        anim.updateBounds(0.dp, maxWidth - 100.dp) // 设置临界值 达到了就停止动画
        animY.updateBounds(0.dp, upperBound = maxHeight - 100.dp)
        Box(Modifier
            .padding(start = anim.value, top = animY.value)
            .background(Color.Green)
            .size(100.dp)
            .clickable {
                big = !big
            }) {

        }
    }
}