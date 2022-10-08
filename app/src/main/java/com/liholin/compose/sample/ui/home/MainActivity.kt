package com.liholin.compose.sample.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.core.view.doOnNextLayout
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.liholin.compose.sample.ui.page.mine.MineTopView
import com.liholin.compose.sample.ui.page.mine.MineView
import com.liholin.compose.sample.ui.theme.ComposeSampleTheme
import com.liholin.compose.sample.uiutils.ProvideDesignSize
import com.liholin.compose.sample.uiutils.ProvideFullSize
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : MainViewModel by viewModels()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        findViewById<View>(android.R.id.content)
            .doOnNextLayout {
                setContent {
                    ComposeSampleTheme {
                        ProvideWindowInsets {
                            val systemUiController = rememberSystemUiController()
                            SideEffect {
                                systemUiController.setStatusBarColor(Color.Transparent,
                                    darkIcons = false)
                            }
                            ProvideFullSize(width = it.width, height = it.height) {
                                ProvideDesignSize(width = 1080, height = 2600) {
                                    MineView()
                                }
                            }
                        }
                    }
                }
            }

            lifecycleScope.launch {
                delay(3000)
                viewModel.phone = "13582309907"
            }
    }
}

