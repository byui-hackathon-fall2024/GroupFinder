package com.example.groupfinder.model

data class User(
    val email: String = "",
    val id: Int = 0,
    val name: String = "",
    val skills: List<String> = emptyList()
){
}
