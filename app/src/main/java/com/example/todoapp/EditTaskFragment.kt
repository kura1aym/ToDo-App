package com.example.todoapp

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.UUID

class EditTaskFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        val cancelBtn: FloatingActionButton = view.findViewById(R.id.closeButton)
        cancelBtn.setOnClickListener{
            val fragment = TaskListFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
        }

        val deleteBtn: Button = view.findViewById(R.id.buttonDelete)
        deleteBtn.setOnClickListener{
            val editText = view.findViewById<EditText>(R.id.editTask)
            val textDate = view.findViewById<TextView>(R.id.textDate)
            val spinner = view.findViewById<Spinner>(R.id.spinner)
            val switch = view.findViewById<SwitchCompat>(R.id.switchCompat)
            editText.text.clear()
            textDate.text = ""
            spinner.setSelection(0)
            switch.isChecked = false
        }

        val saveBtn: Button = view.findViewById(R.id.textSave)
        saveBtn.setOnClickListener {
            val editText = view.findViewById<EditText>(R.id.editTask)
            val spinner = view.findViewById<Spinner>(R.id.spinner)
            val textDate = view.findViewById<TextView>(R.id.textDate)

            val task = editText.text.toString()
            val importance = spinner.selectedItem.toString()
            val date = textDate.text.toString()

            val todoItem = TodoItem(
                UUID.randomUUID().toString(),
                task,
                false,
                importance,
                System.currentTimeMillis(),
                date
            )


            TodoItemsRepository.addTodoItem(todoItem)

            val fragment = TaskListFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
        }


        if (view.findViewById<Spinner>(R.id.spinner) != null) {
            val importanceSpinner: Spinner = view.findViewById(R.id.spinner)
            ArrayAdapter.createFromResource(
                requireContext(),
                R.array.importance,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                importanceSpinner.adapter = adapter
            }
        }

        val switchCompat = view.findViewById<SwitchCompat>(R.id.switchCompat)
        switchCompat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val datePickerDialog = DatePickerDialog(requireContext())
                datePickerDialog.setOnDateSetListener { _, year, month, dayOfMonth ->
                    val textViewDate = view.findViewById<TextView>(R.id.textDate)
                    val selectedDate = String.format("%02d.%02d.%04d", dayOfMonth, month + 1, year)
                    textViewDate.text = selectedDate
                }
                datePickerDialog.show()
            }
        }

        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        view.findViewById<FloatingActionButton>(R.id.textSave).setOnClickListener {
//            // 1. Implement logic to save the edited task
//            // ...
//
//            // 2. Navigate back to the home fragment
//            findNavController().navigate(R.id.action_addNoteFragment_to_home_fragment)
//        }
//
//    }
}
