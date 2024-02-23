package com.eacipher.KMPApp.data.remote.repository

import com.eacipher.KMPApp.data.model.UserRemote
import com.eacipher.KMPApp.domain.model.AppUser
import com.eacipher.KMPApp.domain.repository.AuthRepository
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import dev.gitlive.firebase.firestore.firestore

class AuthRepositoryImpl: AuthRepository {
    private val auth: FirebaseAuth = Firebase.auth
    private val firestore = Firebase.firestore
    override suspend fun doRegister(user: AppUser): Boolean {
        return try {
            val user = auth.createUserWithEmailAndPassword(user.email, user.password).user.let { fbUser ->
                if (fbUser != null){
                    //Записываем пользователя так же и в файрстор
                    val fireStoreUser = UserRemote(
                        email = user.email,
                        password = user.password,
                        registrationDate = user.registrationDate
                    )
                    firestore.collection("user").document(fbUser.uid).set(fireStoreUser)
                    fbUser
                } else {
                    null
                }
            }
            user != null
        } catch (e:Exception){
            false
        }
    }

    override suspend fun doLogin(email: String, password: String): Boolean {
        return try {
            val user = auth.signInWithEmailAndPassword(email, password)
            user.user != null
        } catch (e: Exception){
            false
        }

    }
}