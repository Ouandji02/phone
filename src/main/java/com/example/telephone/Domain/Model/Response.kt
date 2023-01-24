package com.example.telephone.Domain.Model

sealed class Response(){
    object Loading : Response()
    class Success(data: String) : Response()
    class Nothing() : Response()
}
