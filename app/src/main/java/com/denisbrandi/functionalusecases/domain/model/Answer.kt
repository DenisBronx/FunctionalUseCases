package com.denisbrandi.functionalusecases.domain.model

sealed class Answer<out T, out E> {

    data class Success<out T>(val value: T) : Answer<T, Nothing>()

    data class Failure<out E>(val error: E) : Answer<Nothing, E>()

    inline fun <C> fold(success: (T) -> C, failure: (E) -> C): C = when (this) {
        is Success -> success(value)
        is Failure -> failure(error)
    }

}