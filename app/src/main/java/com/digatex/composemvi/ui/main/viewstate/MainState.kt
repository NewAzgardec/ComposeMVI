package com.digatex.composemvi.ui.main.viewstate

import com.digatex.composemvi.data.model.UserModel

sealed class MainState {
    object Idle : MainState()
    object Loading : MainState()
    data class Users(val userModel: List<UserModel>) : MainState()
    data class Error(val error: String?) : MainState()
}
