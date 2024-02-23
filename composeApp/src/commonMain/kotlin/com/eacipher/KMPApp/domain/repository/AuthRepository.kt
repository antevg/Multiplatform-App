package com.eacipher.KMPApp.domain.repository

import com.eacipher.KMPApp.domain.model.AppUser

interface AuthRepository {
    suspend fun doRegister(user: AppUser): Boolean
    suspend fun doLogin(email: String, password: String): Boolean
}