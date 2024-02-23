package com.example.todoapp

data class TodoItem(
    val id: String,
    val description: String,
    var isDone: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    var modifiedAt: Long = System.currentTimeMillis()
)
