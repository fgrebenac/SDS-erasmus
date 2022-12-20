package com.erasmus.sds.models

data class AppThread(
    val id: String,
    val title: String,
    val content: String,
//    @Json(name = "user_id")
//    val userId: String,
//    @Json(name = "category_id")
//    val categoryId: String
)
