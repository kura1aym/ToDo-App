package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var todoListAdapter: TodoListAdapter
    private val todoItemsRepository = TodoItemsRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.tasks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val todoItems = todoItemsRepository.getAllTodoItems()
        todoListAdapter = TodoListAdapter(todoItems)
        recyclerView.adapter = todoListAdapter
    }

    override fun onResume() {
        super.onResume()
        val todoItems = todoItemsRepository.getAllTodoItems()
        todoListAdapter.todoItems = todoItems
        todoListAdapter.notifyDataSetChanged()
    }
}