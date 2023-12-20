package com.digatex.composemvi.data.api.module

import com.digatex.composemvi.data.repository.MainRepository
import com.digatex.composemvi.data.repository.MainRepositoryImpl
import com.digatex.composemvi.ui.main.di.MainScope
import com.digatex.composemvi.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module(includes = [UsersModule::class])
abstract class MainModule {

    @Module
    companion object {
        @Provides
        @MainScope
        fun provideViewModel(repository: MainRepository) = MainViewModel(repository = repository)
    }

    @Binds
    @MainScope
    abstract fun bindRepository(impl: MainRepositoryImpl): MainRepository

}