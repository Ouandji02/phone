package com.example.telephone.Domain.Model

sealed class Response<out T>(){
    object Loading : Response<Nothing>()
    class Success<out T>(data: T) : Response<T>()
    class Error(message : String) : Response<Nothing>()
}
