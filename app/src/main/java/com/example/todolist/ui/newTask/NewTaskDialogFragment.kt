package com.example.todolist.ui.newTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.R


class NewTaskDialogFragment : DialogFragment() {
    private lateinit var newTaskViewModel: NewTaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newTaskViewModel = ViewModelProvider(this).get(NewTaskViewModel::class.java)
        val root = inflater.inflate(R.layout.dialog_fragment_new_task, container, false)
        return root
    }

    override fun getTheme(): Int {
        return R.style.ThemeOverlay_AppCompat_Dialog_Alert
    }
}
