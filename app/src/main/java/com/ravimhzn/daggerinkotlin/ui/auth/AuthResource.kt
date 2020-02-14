package com.ravimhzn.daggerinkotlin.ui.auth


sealed class AuthResource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : AuthResource<T>(data)
    class Loading<T>(data: T? = null) : AuthResource<T>(data)
    class Error<T>(message: String, data: T? = null) : AuthResource<T>(data, message)
    class Logout<T>() : AuthResource<T>()
}
