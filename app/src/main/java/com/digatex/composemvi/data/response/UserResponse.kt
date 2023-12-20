package com.digatex.composemvi.data.response

import com.digatex.composemvi.data.model.UserModel
import com.digatex.composemvi.util.Transformable
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("avatar") val avatar: String? = null
) : Transformable<UserModel> {

    override fun transform() = UserModel(
        id = this.id,
        name = this.name ?: "",
        phone = this.phone ?: "",
        avatar = this.avatar ?: ""
    )
}
