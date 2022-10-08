package com.liholin.compose.sample.ui.page.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.liholin.compose.sample.R
import com.liholin.compose.sample.ui.home.MainViewModel
import com.liholin.compose.sample.uiutils.dpHeight
import com.liholin.compose.sample.uiutils.dpWidth

@Composable
fun MinePersonal() {
    val viewModel : MainViewModel = viewModel()
    Box(Modifier
        .fillMaxWidth()
        .height(554.dpHeight)
        .clickable {
//            startActivity(Intent(this, HomeActivity::class.java))
        }) {
        Image(painterResource(id = R.mipmap.icon_mine_back),
            contentDescription = null,
            Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
        Row(Modifier
            .fillMaxWidth()) {
            Image(rememberAsyncImagePainter(model = "https://img2.woyaogexing.com/2018/11/08/30b6f8e8207b825a!480x480.jpg"
            ,placeholder = painterResource(id = R.mipmap.head_pic)),
                contentDescription = null,
                Modifier
                    .padding(start = 47.dpWidth, top = 149.dpWidth)
                    .size(185.dpWidth)
                    .clip(CircleShape))
            Column(modifier = Modifier
                .padding(top = 191.dpHeight, start = 39.dpWidth)
                .weight(1f)) {
                Text(text = "李明明".let {
                    it.takeIf { it.length > 10 }?.substring(0, 10) ?: kotlin.run {
                        it
                    }
                },
                    fontSize = 16.67.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold, maxLines = 1)
                Spacer(modifier = Modifier.size(36.dpWidth))
                Text(text = viewModel.phone, fontSize = 14.33.sp, color = Color.White)
            }
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xfff3ecde)),
                modifier = Modifier
                    .padding(top = 200.dpWidth, end = 32.dpWidth)
                    .width(186.dpWidth)
                    .height(104.dpHeight)
                    .clip(RoundedCornerShape(8.dp))) {
                Text(text = "签到",
                    fontSize = 12.sp,
                    color = Color(0xFFC206FD),
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}