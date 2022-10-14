package com.liholin.compose.sample.ui.page.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.statusBarsPadding
import com.liholin.compose.sample.ui.home.MainViewModel
import com.liholin.compose.sample.ui.page.common.BottomNavBarView
import com.liholin.compose.sample.ui.page.common.RouteName
import com.liholin.compose.sample.ui.page.find.FindPage
import com.liholin.compose.sample.ui.page.home.HomePage
import com.liholin.compose.sample.ui.page.message.MessagePage
import com.liholin.compose.sample.ui.page.mine.MinePage

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppScaffold() {
    val navCtrl = rememberNavController()
    val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val viewModel : MainViewModel = viewModel()
    Scaffold(modifier = Modifier
        .statusBarsPadding()
        .navigationBarsPadding(),
    bottomBar = {
        when(currentDestination?.route){
            RouteName.HOME -> BottomNavBarView(navCtrl = navCtrl)
            RouteName.MESSAGE -> BottomNavBarView(navCtrl = navCtrl)
            RouteName.FIND -> BottomNavBarView(navCtrl = navCtrl)
            RouteName.MINE -> BottomNavBarView(navCtrl = navCtrl)
        }
    },
    content = {

        NavHost(modifier = Modifier.background(Color(0xfff1f2f6)),
            navController = navCtrl,
            startDestination = RouteName.HOME){
            //首页 小店
            composable(route = RouteName.HOME){
                viewModel.homeIndex = 0
                HomePage()
            }

            // 消息
            composable(route = RouteName.MESSAGE){
                viewModel.homeIndex = 1
                MessagePage()
            }

            // 发现
            composable(route = RouteName.FIND){
                viewModel.homeIndex = 2
                FindPage()
            }

            // 我的
            composable(route = RouteName.MINE){
                viewModel.homeIndex = 3
                MinePage()
            }
        }
    }/*,
    snackbarHost = {
        SnackbarHost(
            hostState = scaffoldState.snackbarHostState
        ) { data ->
            println("actionLabel = ${data.actionLabel}")
//            AppSnackBar(data = data)
        }
    }*/)

}