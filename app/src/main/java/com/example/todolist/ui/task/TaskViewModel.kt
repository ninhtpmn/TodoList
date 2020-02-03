package com.example.todolist.ui.task

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.TodoData

class TaskViewModel : ViewModel() {
    val data = MutableLiveData<List<TodoData>>()

    fun refresh() {
        Thread(Runnable {
            Thread.sleep(3000)

            val tododata1 = TodoData("One", "Dec 1, 2019 11:29 AM", "Dec 1, 2019 11:35 PM")
            val tododata2 = TodoData("Two", "Dec 2, 2019 11:29 AM", "Dec 2, 2019 11:35 PM")
            val tododata3 = TodoData("Three", "Dec 3, 2019 11:29 AM", "Dec 3, 2019 11:35 PM")
            val tododata4 = TodoData("Four", "Dec 4, 2019 11:29 AM", "Dec 4, 2019 11:35 PM")
            val tododata5 = TodoData("Five", "Dec 5, 2019 11:29 AM", "Dec 5, 2019 11:35 PM")
            val tododata6 = TodoData("Six", "Dec 6, 2019 11:29 AM", "Dec 6, 2019 11:35 PM")
            val tododata7 = TodoData("Seven", "Dec 7, 2019 11:29 AM", "Dec 7, 2019 11:35 PM")
            val tododata8 = TodoData("Eight", "Dec 8, 2019 11:29 AM", "Dec 8, 2019 11:35 PM")
            val tododata9 = TodoData("Nine", "Dec 9, 2019 11:29 AM", "Dec 9, 2019 11:35 PM")
            val tododata10 = TodoData("Ten", "Dec 10, 2019 11:29 AM", "Dec 10, 2019 11:35 PM")
            val data: List<TodoData> = listOf(
                tododata1,
                tododata2,
                tododata3,
                tododata4,
                tododata5,
                tododata6,
                tododata7,
                tododata8,
                tododata9,
                tododata10
            )
            Handler(Looper.getMainLooper()).post {
                this.data.value = data
            }
        }).start()
    }

}