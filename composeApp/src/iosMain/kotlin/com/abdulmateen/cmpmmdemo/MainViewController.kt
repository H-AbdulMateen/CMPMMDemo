package com.abdulmateen.cmpmmdemo

import androidx.compose.ui.window.ComposeUIViewController
import com.abdulmateen.cmpmmdemo.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }