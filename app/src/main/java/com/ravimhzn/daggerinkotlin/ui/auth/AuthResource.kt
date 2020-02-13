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

//class AuthResource<T>(val status: AuthStatus, val data: T?, val message: String?) {
//
//    enum class AuthStatus {
//        AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
//    }
//
//    companion object {
//
//        fun <T> authenticated(data: T?): AuthResource<T> {
//            return AuthResource(AuthStatus.AUTHENTICATED, data, null)
//        }
//
//        fun <T> error(msg: String, data: T?): AuthResource<T> {
//            return AuthResource(AuthStatus.ERROR, data, msg)
//        }
//
//        fun <T> loading(data: T?): AuthResource<T> {
//            return AuthResource(AuthStatus.LOADING, data, null)
//        }
//
//        fun <T> logout(): AuthResource<T> {
//            return AuthResource(AuthStatus.NOT_AUTHENTICATED, null, null)
//        }
//    }
//
//}