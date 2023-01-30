package com.example.telephone.Data.RepositoryImpl

import com.example.telephone.Data.LocalDB.DAO.ContactDao
import com.example.telephone.Domain.Model.Contact
import com.example.telephone.Domain.Model.Response
import com.example.telephone.Domain.Repository.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactRepositoryImpl(private val contactDao: ContactDao) : ContactRepository {
    override fun addContact(contact: Contact) = flow {
        try {
            val contacts = contactDao.addContact(contact)
            emit(Response.Success(contacts))
        } catch (e: Exception) {
            emit(Response.Error(e.message.toString()))
        }
    }

    override fun getAllContact() = flow {
        try {
            emit(Response.Loading)
            val contacts = contactDao.getAllContact()
            emit(Response.Success(contacts))
        } catch (e: Exception) {
            emit(Response.Error(e.message.toString()))
        }
    }

    override fun getOneContact(phone: String) = flow {
        try {
            emit(Response.Loading)
            val contact = contactDao.getContact(phone)
            emit(Response.Success(contact))
        } catch (e: Exception) {
            emit(Response.Error(e.message.toString()))
        }
    }

    override fun update(contact: Contact) = flow {
        try {
            emit(Response.Loading)
            val contact = contactDao.updateContact(contact)
            emit(Response.Success(contact))
        } catch (e: Exception) {
            emit(Response.Error(e.message.toString()))
        }
    }

    override fun deleteContact(contact: Contact) = flow {
        try {
            val response = contactDao.deleteContact(contact)
            emit(Response.Success(response))
        } catch (e: Exception) {
            emit(Response.Error(e.message.toString()))
        }
    }
}