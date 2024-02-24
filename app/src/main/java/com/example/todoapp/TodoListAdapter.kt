package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(var todoItems: List<TodoItem>) :
    RecyclerView.Adapter<TodoListAdapter.TodoItemViewHolder>() {

    inner class TodoItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkbox: CheckBox = itemView.findViewById(R.id.checkbox)
        val textTask: TextView = itemView.findViewById(R.id.textTask)
        val imageButton: ImageButton = itemView.findViewById(R.id.infoButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_preview, parent, false)
        return TodoItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val currentItem = todoItems[position]

        holder.checkbox.isChecked = currentItem.isDone
        holder.textTask.text = currentItem.description

        holder.imageButton.setOnClickListener {
        }
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }
}
