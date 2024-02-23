package com.eacipher.KMPApp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.eacipher.KMPApp.presentation.screens.login.LoginScreen
import com.eacipher.KMPApp.presentation.screens.registration.RegistrationScreen
import com.eacipher.KMPApp.theme.AppTheme

import org.koin.compose.KoinContext

@Composable
internal fun App() = AppTheme {
    KoinContext {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Navigator(LoginScreen()) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}

internal expect fun openUrl(url: String?)