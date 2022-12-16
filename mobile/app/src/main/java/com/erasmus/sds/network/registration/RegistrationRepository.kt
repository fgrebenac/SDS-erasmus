package com.erasmus.sds.network.registration

import com.erasmus.sds.models.RegisterBody

class RegistrationRepository(private val apiService: RegistrationApiService) {

    suspend fun registerUser(body: RegisterBody) = apiService.register(body)

}