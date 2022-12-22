package com.example.xtreamclean.model

data class TaskData(
    val id: String,
    val staff_id: String,
    val status: String,
    val property_name: String,
    val address: String,
    val task_detail: String,
    val priority: String,
    val checkOutDate: String
)