package com.digatex.composemvi.data.repository

import com.digatex.composemvi.data.response.UserResponse


interface MainRepository {
    suspend fun getUsers(): List<UserResponse>
}

