package com.digatex.composemvi.data.api.component

import com.digatex.composemvi.data.api.module.NetworkModule
import com.digatex.composemvi.ui.main.di.MainScope
import com.digatex.composemvi.ui.main.view.MainActivity
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@MainScope
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(mewApplication: MainActivity)
}