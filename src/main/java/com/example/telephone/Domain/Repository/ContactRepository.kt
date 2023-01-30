package com.example.telephone.Domain.Repository

import com.example.telephone.Domain.Model.Contact
import com.example.telephone.Domain.Model.Response
import kotlinx.coroutines.flow.Flow

interface ContactRepository {
    fun addContact(contact: Contact) : Flow<Response<Void?>>
    fun getAllContact() : Flow<Response<List<Contact>>>
    fun getOneContact(phone : String) : Flow<Response<Contact>>
    fun update(contact: Contact) : Flow<Response<Void?>>
    fun deleteContact(contact: Contact) : Flow<Response<Void?>>
}