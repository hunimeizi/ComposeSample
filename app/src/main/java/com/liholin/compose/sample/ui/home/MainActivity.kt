package com.liholin.compose.sample.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.core.view.doOnNextLayout
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.liholin.compose.sample.ui.page.main.AppScaffold
import com.liholin.compose.sample.ui.theme.ComposeSampleTheme
import com.liholin.compose.sample.uiutils.ProvideDesignSize
import com.liholin.compose.sample.uiutils.ProvideFullSize

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                                    AppScaffold()
                                }
                            }
                        }
                    }
                }
            }
    }
}

