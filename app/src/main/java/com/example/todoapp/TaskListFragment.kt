package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TaskListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var todoItems = emptyList<TodoItem>()
    private lateinit var todoListAdapter: TodoListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        recyclerView = view.findViewById(R.id.tasks)
        recyclerView.layoutManager = LinearLayoutManager(context)

        todoItems = TodoItemsRepository().getAllTodoItems() // Или передайте данные через аргументы
        todoListAdapter = TodoListAdapter(todoItems)
        recyclerView.adapter = todoListAdapter

        val addButton = view.findViewById<FloatingActionButton>(R.id.addButton)

        addButton.setOnClickListener{
            val fragment = EditTaskFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
        }
        return view
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        view.findViewById<FloatingActionButton>(R.id.addButton).setOnClickListener {
//            findNavController().navigate(R.id.action_mobile_navigation_to_addNoteFragment)
//        }
//    }
}

