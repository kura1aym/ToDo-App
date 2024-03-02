package com.example.todoapp

object TodoItemsRepository {
    private val todoList = mutableListOf<TodoItem>()

    init {
        todoList.addAll(
            listOf(
                TodoItem("1", "Погулять с собакой", false, "Нет", System.currentTimeMillis(), ""),
                TodoItem("2", "Сделать уроки", false, "Нет", System.currentTimeMillis(), ""),
                TodoItem("3", "Купить продукты", false, "Нет", System.currentTimeMillis(), "")
            )
        )
    }

    fun getAllTodoItems(): List<TodoItem> {
        return todoList
    }

    fun addTodoItem(todoItem: TodoItem) {
        todoList.add(todoItem)
    }
}
