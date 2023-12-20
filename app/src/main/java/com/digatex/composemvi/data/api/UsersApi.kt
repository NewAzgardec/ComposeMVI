package com.digatex.composemvi.data.api

import com.digatex.composemvi.data.response.UserResponse
import retrofit2.http.GET

interface UsersApi {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}