package com.ravimhzn.daggerinkotlin.ui.main.post


sealed class PostResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : PostResource<T>(data)
    class Loading<T>(data: T? = null) : PostResource<T>(data)
    class Error<T>(message: String, data: T? = null) : PostResource<T>(data, message)
}
