package com.digatex.composemvi.data.repository

import com.digatex.composemvi.data.api.UsersApi
import com.digatex.composemvi.ui.main.di.MainScope
import javax.inject.Inject

@MainScope
class MainRepositoryImpl @Inject constructor(private val usersApi: UsersApi) : MainRepository {
    override suspend fun getUsers() = usersApi.getUsers()
}