package com.example.groupfinder.ui

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AuthenticationManager(context: android.content.Context) {
    private val auth = Firebase.auth

    fun createAccountWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success)
                }
                else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?: "Sing Up Error"))
                }
            }
    }

    fun loginWithEmail(email: String, password: String): Flow<AuthResponse> = callbackFlow {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    trySend(AuthResponse.Success)
                }
                else {
                    trySend(AuthResponse.Error(message = task.exception?.message ?: ""))
                }

            }
    }
}

interface AuthResponse {
    data object Success: AuthResponse
    data class Error(val message: String): AuthResponse
}

