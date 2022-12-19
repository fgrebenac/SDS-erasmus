package com.erasmus.sds.network.threads

import com.erasmus.sds.models.RegistrationBody

class ThreadsRepository(private val apiService: ThreadsApiService) {

    suspend fun getThreads(body: RegistrationBody) = apiService.getThreads(body)

    suspend fun addThread(body: RegistrationBody) = apiService.addThread(body)

}