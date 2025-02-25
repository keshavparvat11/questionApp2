package com.example.myapplication.Data

data class DataOrException<T,Boolean, E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var exception: Exception? = null
)