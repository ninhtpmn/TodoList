package com.example.todolist

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("hideRefreshing")
    fun hideRefreshing(swipeRefreshLayout: SwipeRefreshLayout, loading: Boolean) {
        if (!loading) {
            swipeRefreshLayout.isRefreshing = false
        }
    }
}