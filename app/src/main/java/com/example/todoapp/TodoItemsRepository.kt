package com.example.todoapp

class TodoItemsRepository {
    private val todoList = mutableListOf<TodoItem>()

    init {
        todoList.addAll(listOf(
            TodoItem("1", "Погулять с собакой", false, System.currentTimeMillis()),
            TodoItem("2", "Сделать уроки", false, System.currentTimeMillis()),
            TodoItem("3", "Купить продукты", false, System.currentTimeMillis())
        ))
    }

    fun getAllTodoItems(): List<TodoItem> {
        return todoList
    }

    fun addTodoItem(todoItem: TodoItem) {
        todoList.add(todoItem)
    }
}
