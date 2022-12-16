package com.erasmus.sds.network.registration

import com.erasmus.sds.models.AppUser
import com.erasmus.sds.models.RegisterBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationApiService {

    @POST("users")
    suspend fun register(@Body body: RegisterBody): Response<AppUser>

}