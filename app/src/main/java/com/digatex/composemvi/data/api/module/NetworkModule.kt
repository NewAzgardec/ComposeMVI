package com.digatex.composemvi.data.api.module

import com.digatex.composemvi.ui.main.di.MainScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    private val BASE_URL = "https://6582040f02f747c83678fb1c.mockapi.io/api/v1/"

    @Provides
    @MainScope
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).client(basicOkHttpClient())
            .baseUrl(BASE_URL)
            .build()
    }

//    @Provides
//    @MainScope
//    fun httpInterceptor() = HttpLoggingInterceptor().apply {
//        level = HttpLoggingInterceptor.Level.BODY
//    }

    @Provides
    @MainScope
    fun basicOkHttpClient() = OkHttpClient.Builder()
//        .addInterceptor(httpInterceptor())
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS).build()

}