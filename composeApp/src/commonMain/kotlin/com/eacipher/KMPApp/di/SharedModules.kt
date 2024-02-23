package com.eacipher.KMPApp.di

import com.eacipher.KMPApp.data.remote.repository.AuthRepositoryImpl
import com.eacipher.KMPApp.domain.repository.AuthRepository
import com.eacipher.KMPApp.domain.usecase.AuthUseCase
import com.eacipher.KMPApp.presentation.screens.login.LoginViewModel
import com.eacipher.KMPApp.presentation.screens.registration.RegistrationViewModel
import org.koin.dsl.module

private val domainModule = module {
    factory { AuthUseCase() }
}

private val presentationModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl()
    }
    single { RegistrationViewModel() }
    single { LoginViewModel() }
}

private fun getAllModules() = listOf(
    domainModule, presentationModule
)

fun getAllSharedModules() = getAllModules()