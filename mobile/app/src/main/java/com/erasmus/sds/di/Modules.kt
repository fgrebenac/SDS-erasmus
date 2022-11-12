package com.erasmus.sds.di

import com.erasmus.sds.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit

val viewModelModule = module {
}

val repositoryModule = module {
}

val networkModule = module {
    factory { provideOkHttpClient() }
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