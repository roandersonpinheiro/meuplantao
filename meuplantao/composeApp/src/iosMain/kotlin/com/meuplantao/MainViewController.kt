package com.meuplantao

import androidx.compose.ui.window.ComposeUIViewController
import com.meuplantao.di.initKoin
fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}