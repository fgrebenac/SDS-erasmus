package com.erasmus.sds.models

import com.squareup.moshi.Json

data class AppUser(
    val id: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "last_name")
    val lastName: String,
    val email: String,
)