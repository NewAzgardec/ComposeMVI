package com.digatex.composemvi.data.api.module

import com.digatex.composemvi.data.api.UsersApi
import com.digatex.composemvi.ui.main.di.MainScope
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Retrofit


@ExperimentalCoroutinesApi
@Module(includes = [NetworkModule::class])
class UsersModule {

    @Provides
    @MainScope
    internal fun provideApi(retrofit: Retrofit): UsersApi {
        return retrofit.create(UsersApi::class.java)
    }
}
