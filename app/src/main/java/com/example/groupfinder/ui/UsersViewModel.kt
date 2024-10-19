package com.example.groupfinder.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.groupfinder.model.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsersViewModel : ViewModel() {
    private var _userList = MutableStateFlow<List<User>>(emptyList())
    var userList = _userList.asStateFlow()

    private val db = Firebase.firestore


    init {
        getUserList()
    }

    fun getUserList(){

        db.collection("users")
            .addSnapshotListener { value, error ->
                if (error != null){
                    return@addSnapshotListener
                }

                if (value != null){
                    _userList.value = value.toObjects()
                }
            }
    }

    fun createUser() {
        val user = hashMapOf(
            "id" to 5,
            "email" to "fdaa@yahoo.com",
            "name" to "levi",
            "skills" to listOf("asdf", "ASdf")
        )
        db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("document", "CREATED")
            }
    }

    fun updateCar() {
        val user = hashMapOf(
            "id" to 7,
            "email" to "sadfsaa@yahoo.com",
            "name" to "wade",
            "skills" to listOf("asdf", "ASdf")
        )
        db.collection("users")
            .document("gpJCK1j3rzd2CwJrpyKH")
            .set(user)
            .addOnSuccessListener {
                Log.d("document", "UPDATED")
            }
    }
}