package com.example.todoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EditTaskFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)
        val cancelBtn: FloatingActionButton = view.findViewById(R.id.closeButton)
        cancelBtn.setOnClickListener{
            val fragment = TaskListFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_container, fragment)?.commit()
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
