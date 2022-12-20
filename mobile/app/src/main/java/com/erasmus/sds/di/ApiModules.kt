package com.erasmus.sds.di

import com.erasmus.sds.network.login.LoginApiService
import com.erasmus.sds.network.registration.RegistrationApiService
import com.erasmus.sds.network.threads.ThreadsApiService
import retrofit2.Retrofit

fun provideRegistrationApi(retrofit: Retrofit): RegistrationApiService =
    retrofit.create(RegistrationApiService::class.java)

fun provideLoginApi(retrofit: Retrofit): LoginApiService =
    retrofit.create(LoginApiService::class.java)

fun provideThreadsApi(retrofit: Retrofit): ThreadsApiService =
    retrofit.create(ThreadsApiService::class.java)