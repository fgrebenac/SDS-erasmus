package com.erasmus.sds.models

data class RegisterBody(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)
