package com.liholin.compose.sample.ui.page.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.liholin.compose.sample.ui.home.MainViewModel
import com.liholin.compose.sample.uiutils.dpWidth


@Composable
fun BottomNavBarView(navCtrl: NavHostController) {
    val bottomNavList = listOf(
        BottomNavRoute.Home,
        BottomNavRoute.Message,
        BottomNavRoute.Find,
        BottomNavRoute.Mine
    )
    val viewModel: MainViewModel = viewModel()
    BottomNavigation {
        val navBackStackEntry by navCtrl.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        bottomNavList.forEachIndexed { index, screen ->
            BottomNavigationItem(
                modifier = Modifier.background(Color.White),
                icon = {
                    if(index == 3) {
                        BadgedBox(
                            badge = {
                                if(viewModel.homeCount > 0) {
                                    Badge(modifier = Modifier.padding(top = 10.dp), backgroundColor = Color.Red){
                                        Text("${viewModel.homeCount}", color = Color.White)
                                    }
                                }
                            },
                        ) {
                            BottomIcon(index, viewModel, screen)
                        }
                    } else {
                        BottomIcon(index, viewModel, screen)
                    }
                },
                label = {
                    Text(text = stringResource(screen.stringId),
                        color = Color(if(index == viewModel.homeIndex) 0xffF12582 else 0x4DF12582))
                },
                selected = currentDestination?.hierarchy?.any { it.route == screen.routeName } == true,
                onClick = {
                    println("BottomNavView当前路由 ===> ${currentDestination?.hierarchy?.toList()}")
                    println("当前路由栈 ===> ${navCtrl.graph.nodes}")
                    if(currentDestination?.route != screen.routeName) {
                        navCtrl.navigate(screen.routeName) {
                            popUpTo(navCtrl.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                })
        }
    }
}

@Composable
private fun BottomIcon(
    index: Int,
    viewModel: MainViewModel,
    screen: BottomNavRoute,
) {
    Icon(
        painter = painterResource(id = if(index == viewModel.homeIndex) screen.iconPress else screen.iconDef),
        contentDescription = null,
        modifier = Modifier
            .padding(8.dpWidth)
            .size(60.dpWidth),
        tint = Color.Unspecified
    )
}
