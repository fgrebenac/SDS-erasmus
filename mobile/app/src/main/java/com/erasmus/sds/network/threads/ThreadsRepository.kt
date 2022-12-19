package com.erasmus.sds.network.registration

import com.erasmus.sds.models.RegistrationBody

class RegistrationRepository(private val apiService: RegistrationApiService) {

    suspend fun registerUser(body: RegistrationBody) = apiService.register(body)

}