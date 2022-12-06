package com.erasmus.sds.models

import kotlinx.serialization.SerialName

data class AppThread(
    val id: String,
    val title: String,
    val content: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("category_id")
    val categoryId: String
)
