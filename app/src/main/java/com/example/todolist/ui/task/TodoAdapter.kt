package com.example.todolist.ui.task

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.TodoData
import com.example.todolist.databinding.FragmenttaskTodoitemBinding

class TodoAdapter(private val context: Context, private var data: List<TodoData>) :
    RecyclerView.Adapter<TodoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding: FragmenttaskTodoitemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragmenttask_todoitem,
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val dataAtPosition = data[position]
        holder.binding.data = dataAtPosition
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<TodoData>) {
        this.data = data
        notifyDataSetChanged()
    }
}

class TodoViewHolder(val binding: FragmenttaskTodoitemBinding) :
    RecyclerView.ViewHolder(binding.root)
