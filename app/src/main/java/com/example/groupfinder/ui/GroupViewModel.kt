package com.example.groupfinder.ui

import androidx.lifecycle.ViewModel
import com.example.groupfinder.model.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GroupViewModel : ViewModel() {
}

//    private var _user = MutableStateFlow<User?>(null)
//    var user = _user.asStateFlow()
//
//    init {
//        getGroupById()
//    }
//
//    fun getGroupById() {
//        val db = Firebase.firestore
//
//        db.collection("groups")
//            .document("7ScYz2VD6Ba81VgpcOsh") // find out how to get this linked to your account
//            .get()
//            .addOnSuccessListener { documentSnapshot ->
//                _user.value = documentSnapshot.toObject()
//            }
//    }
//}