package com.liholin.compose.sample.ui.page.home

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import com.liholin.compose.sample.ui.page.widgets.MyRefreshFooter
import com.liholin.compose.sample.ui.page.widgets.MyRefreshHeader
import com.liholin.compose.sample.ui.page.widgets.SmartSwipeRefresh
import com.liholin.compose.sample.ui.page.widgets.SmartSwipeRefreshState

//https://github.com/Loren-Moon/ComposeSmartRefresh/blob/master/sample/src/main/java/com/loren/component/view/sample/MainActivity.kt
@Composable
fun SmartSwipeRefreshView(
    refreshState: SmartSwipeRefreshState,
    scrollState: LazyListState,
) {
    SmartSwipeRefresh(state = refreshState,
        onRefresh = {

        }, onLoadMore = {

        }, isNeedRefresh = true,
        isNeedLoadMore = true, headerIndicator = {
            MyRefreshHeader(refreshState.refreshFlag, true)
        },
        footerIndicator = {
            MyRefreshFooter(refreshState.loadMoreFlag, true)
        }) {
        LaunchedEffect(refreshState.smartSwipeRefreshAnimateFinishing) {
            if(refreshState.smartSwipeRefreshAnimateFinishing.isFinishing && !refreshState.smartSwipeRefreshAnimateFinishing.isRefresh) {
                scrollState.animateScrollToItem(scrollState.firstVisibleItemIndex + 1)
            }
        }
//            LaunchedEffect(mainUiState.value) {
//                mainUiState.value?.let {
//                    if (!it.isLoading) {
//                        refreshState.refreshFlag = when (it.refreshSuccess) {
//                            true -> SmartSwipeStateFlag.SUCCESS
//                            false -> SmartSwipeStateFlag.ERROR
//                            else -> SmartSwipeStateFlag.IDLE
//                        }
//                        refreshState.loadMoreFlag = when (it.loadMoreSuccess) {
//                            true -> SmartSwipeStateFlag.SUCCESS
//                            false -> SmartSwipeStateFlag.ERROR
//                            else -> SmartSwipeStateFlag.IDLE
//                        }
//                    }
//                }
//            }
        CompositionLocalProvider() {
            MallView()
        }
    }
}