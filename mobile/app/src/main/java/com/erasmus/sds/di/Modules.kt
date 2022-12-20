package com.erasmus.sds.di

import com.erasmus.sds.BuildConfig
import com.erasmus.sds.network.login.LoginRepository
import com.erasmus.sds.network.registration.RegistrationRepository
import com.erasmus.sds.network.threads.ThreadsRepository
import com.erasmus.sds.ui.auth.login.LoginViewModel
import com.erasmus.sds.ui.auth.registration.RegistrationViewModel
import com.erasmus.sds.ui.main.threads.ThreadsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val viewModelModule = module {
    single { RegistrationViewModel(get()) }
    single { LoginViewModel(get()) }
    single { ThreadsViewModel(get()) }
}

val repositoryModule = module {
    single { RegistrationRepository(get()) }
    single { LoginRepository(get()) }
    single { ThreadsRepository(get()) }
}

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideRegistrationApi(get()) }
    factory { provideLoginApi(get()) }
    factory { provideThreadsApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient().newBuilder().addInterceptor(loggingInterceptor).build()
}