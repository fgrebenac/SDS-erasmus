package com.erasmus.sds.di

import com.erasmus.sds.network.login.LoginApiService
import com.erasmus.sds.network.registration.RegistrationApiService
import retrofit2.Retrofit

fun provideRegistrationApi(retrofit: Retrofit): RegistrationApiService =
    retrofit.create(RegistrationApiService::class.java)

fun provideLoginApi(retrofit: Retrofit): LoginApiService =
    retrofit.create(LoginApiService::class.java)