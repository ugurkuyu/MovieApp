package com.ugurkuyu.movieapp.util

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> SUCCESS(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> ERROR(message: String, data: T? = null): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun <T> LOADING(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}