package com.liholin.compose.sample.ui.page.home

import android.annotation.SuppressLint
import android.telephony.TelephonyManager
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.liholin.compose.sample.R
import com.liholin.compose.sample.ui.home.MainViewModel
import com.liholin.compose.sample.uiutils.dpHeight
import com.liholin.compose.sample.uiutils.dpWidth

@SuppressLint("MutableCollectionMutableState")
@Composable
fun StoreView() {
    Log.e("lyb======", "3333333")
    val viewModel : MainViewModel = viewModel()
    Box(modifier = Modifier
        .padding(start = 31.dpWidth, end = 31.dpWidth, top = 39.dpWidth)
        .fillMaxWidth()
        .height(349.dpHeight)
        .background(Color.White)) {

        LazyRow(modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically) {
            itemsIndexed(viewModel.storeResponse) { index, item ->
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .width(270.dpWidth)
                    .clickable {
                       viewModel.storeResponse.forEachIndexed { indexData, responseItem ->
                                   responseItem.clicked = index == indexData
                           }
                    },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(rememberAsyncImagePainter(model = item.shopLogo,
                        placeholder = painterResource(id = R.mipmap.no_banner)),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(bottom = 20.dpWidth)
                            .width(157.dpWidth)
                            .height(154.dpHeight))
                    Box(
                        modifier = if(item.clicked) Modifier
                            .size(142.dpWidth, 50.dpHeight)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        Color(0xffF73F5E),
                                        Color(0xffEB0CA4)
                                    ),
                                    tileMode = TileMode.Decal
                                )
                            ) else Modifier,
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = item.storeName ?: "",
                            color = if(item.clicked) Color.White else Color.Black,
                            fontSize = 14.sp)
                    }
                }
            }
        }
    }
}