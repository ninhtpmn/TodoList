package com.example.todolist.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.todolist.R
import com.example.todolist.TodoData
import com.example.todolist.autoCleared
import com.example.todolist.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private lateinit var rvAdapter: TodoAdapter
    private lateinit var taskViewModel: TaskViewModel
    private var binding by autoCleared<FragmentTaskBinding>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_task,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.setLifecycleOwner(viewLifecycleOwner)
        initRecyclerView()
        binding.srlRefresh.setOnRefreshListener {
            binding.loading = true
            taskViewModel.refresh()
        }
        taskViewModel.data.observe(viewLifecycleOwner, Observer {
            println("-------------->>" + it)
            binding.loading = false
            rvAdapter.setData(it)
        })
    }

    private fun initRecyclerView() {
        val tododata1 = TodoData("One", "Dec 1, 2019 11:29 AM" , "Dec 1, 2019 11:35 PM")
        val tododata2 = TodoData("Two", "Dec 2, 2019 11:29 AM" , "Dec 2, 2019 11:35 PM")
        val tododata3 = TodoData("Three", "Dec 3, 2019 11:29 AM" , "Dec 3, 2019 11:35 PM")
        val tododata4 = TodoData("Four", "Dec 4, 2019 11:29 AM" , "Dec 4, 2019 11:35 PM")
        val tododata5 = TodoData("Five", "Dec 5, 2019 11:29 AM" , "Dec 5, 2019 11:35 PM")
        val data : List<TodoData> = listOf(tododata1, tododata2, tododata3, tododata4, tododata5)
        rvAdapter = TodoAdapter(requireContext(), data)
        binding.rvTodo.adapter = rvAdapter
    }
}