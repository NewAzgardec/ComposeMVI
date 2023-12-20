package com.digatex.composemvi.data.api.component

import com.digatex.composemvi.data.api.module.MainModule
import com.digatex.composemvi.ui.main.di.MainScope
import com.digatex.composemvi.ui.main.viewmodel.MainViewModel
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Component(
    modules = [MainModule::class]
)
@MainScope
interface MainComponent {

    @Component.Builder
    interface Builder {
        fun build(): MainComponent
    }

    fun getViewModel(): MainViewModel
}