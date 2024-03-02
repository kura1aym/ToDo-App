package com.example.todoapp

data class TodoItem(
    val id: String,
    val description: String,
    var isDone: Boolean = false,
    val importance: String = "Нет",
    val createdAt: Long = System.currentTimeMillis(),
    var doBefore: String
)
