package com.erasmus.sds.di

import com.erasmus.sds.BuildConfig
import com.erasmus.sds.network.login.LoginRepository
import com.erasmus.sds.network.registration.RegistrationRepository
import com.erasmus.sds.ui.auth.login.LoginViewModel
import com.erasmus.sds.ui.auth.registration.RegistrationViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

val viewModelModule = module {
    single { RegistrationViewModel(get()) }
    single { LoginViewModel(get()) }
}

val repositoryModule = module {
    single { RegistrationRepository(get()) }
    single { LoginRepository(get()) }
}

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideRegistrationApi(get()) }
    factory { provideLoginApi(get()) }
    single { provideRetrofit(get()) }
}

@OptIn(ExperimentalSerializationApi::class)
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}