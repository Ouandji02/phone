package com.example.telephone.Domain.UseCases

import com.example.telephone.Domain.Model.Contact
import com.example.telephone.Domain.Repository.ContactRepository

class ContactUseCases(private val contactRepository: ContactRepository) {
    suspend fun addContact(contact: Contact) = contactRepository.addContact(contact)
    suspend fun getAllContact() = contactRepository.getAllContact()
    suspend fun getOneContact(phone : String) = contactRepository.getOneContact(phone)
    suspend fun updateContact(contact: Contact) = contactRepository.update(contact)
    suspend fun delete(contact: Contact) = contactRepository.deleteContact(contact)
}