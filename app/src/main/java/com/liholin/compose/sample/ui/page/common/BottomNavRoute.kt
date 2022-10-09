package com.liholin.compose.sample.ui.page.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.liholin.compose.sample.R

sealed class BottomNavRoute(
    var routeName: String,
    @StringRes var stringId: Int,
    @DrawableRes var iconDef: Int,
    @DrawableRes var iconPress: Int,
) {
    object Home: BottomNavRoute(RouteName.HOME, R.string.home, R.mipmap.icon_mall,R.mipmap.icon_mall_press)
    object Message: BottomNavRoute(RouteName.MESSAGE, R.string.message, R.mipmap.icon_message,R.mipmap.icon_message_press)
    object Find: BottomNavRoute(RouteName.FIND, R.string.find, R.mipmap.icon_find,R.mipmap.icon_find_press)
    object Mine: BottomNavRoute(RouteName.MINE, R.string.mine, R.mipmap.icon_mine,R.mipmap.icon_mine_press)
}