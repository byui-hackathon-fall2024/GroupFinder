package com.example.groupfinder.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.groupfinder.model.Group
import com.example.groupfinder.model.User
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GroupsViewModel : ViewModel() {
    private var _groupList = MutableStateFlow<List<Group>>(emptyList())
    var groupList = _groupList.asStateFlow()

    private val db = Firebase.firestore


    init {
        getGroupList()
    }

    fun getGroupList(){

        db.collection("groups")
            .addSnapshotListener { value, error ->
                if (error != null){
                    return@addSnapshotListener
                }

                if (value != null){
                    _groupList.value = value.toObjects()
                }
            }
    }

    // TODO: make dynamic
    fun createGroup() {
        val group = hashMapOf(
            "name" to "Web Team",
            "numRolesNeeded" to 2,
            "skillsNeeded" to listOf("Frontend", "Backend"),
            "teamMembers" to listOf("7ScYz2VD6Ba81VgpcOsh", "ZBrwXSUgOEbW8dEQG6Af")
        )
        db.collection("groups")
            .add(group)
            .addOnSuccessListener {
                Log.d("document", "CREATED")
            }
    }

    // TODO: make dynamic
    fun updateGroup() {
        val group = hashMapOf(
                "name" to "Web Team",
        "numRolesNeeded" to 2,
        "skillsNeeded" to listOf("Frontend", "Backend"),
        "teamMembers" to listOf("7ScYz2VD6Ba81VgpcOsh", "ZBrwXSUgOEbW8dEQG6Af")
        )
        db.collection("groups")
            .document("EvHjNpzWbNWkMcKioQiP")
            .set(group)
            .addOnSuccessListener {
                Log.d("document", "UPDATED")
            }
    }
}