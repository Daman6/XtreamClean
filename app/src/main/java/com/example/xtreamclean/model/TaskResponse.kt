package com.example.xtreamclean.model

data class TaskResponse(
    val `data`: TaskData,
    val result: String,
    val status: String
)