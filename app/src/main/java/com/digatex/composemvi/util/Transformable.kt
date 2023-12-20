package com.digatex.composemvi.util

interface Transformable<T> : BaseResponse {
    fun transform(): T
}
