package com.ravimhzn.daggerinkotlin.ui.auth


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class AuthResources<T>(
    @field:NonNull @param:NonNull val status: AuthStatus,
    @field:Nullable @param:Nullable val data: T,
    @field:Nullable @param:Nullable val message: String?
) {

    enum class AuthStatus {
        AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED
    }

    fun <T> authenticated(@Nullable data: T): AuthResources<T> {
        return AuthResources(AuthStatus.AUTHENTICATED, data, null)
    }

    fun <T> error(@NonNull msg: String?, @Nullable data: T): AuthResources<T> {
        return AuthResources(AuthStatus.ERROR, data, msg)
    }

    fun <T> loading(@Nullable data: T): AuthResources<T> {
        return AuthResources(AuthStatus.LOADING, data, null)
    }

    fun <T> logout(): AuthResources<Any?> {
        return AuthResources<Any?>(AuthStatus.NOT_AUTHENTICATED, null, null)
    }


}
