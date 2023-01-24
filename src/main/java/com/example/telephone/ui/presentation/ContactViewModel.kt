package com.example.telephone.ui.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.telephone.Domain.Model.Contact
import com.example.telephone.Domain.Model.Response
import com.example.telephone.Domain.UseCases.ContactUseCases
import kotlinx.coroutines.launch

class ContactViewModel(private val contactUseCases: ContactUseCases):ViewModel() {
    var addContactResponse by mutableStateOf<Response<Void?>>(Response.Success(null))
        private set
    var getAllContactResponse by mutableStateOf<Response<List<Contact>>>(Response.Loading)
        private set
    var getContactResponse by mutableStateOf<Response<Contact>>(Response.Loading)
        private set
    var updateResponse by mutableStateOf<Response<Void?>>(Response.Success(null))
        private set

    fun addContact(contact: Contact) = viewModelScope.launch {
        contactUseCases.addContact(contact).collect{
            addContactResponse = it
        }
    }

    fun getAllContact() = viewModelScope.launch {
        contactUseCases.getAllContact().collect{
            getAllContactResponse = it
        }
    }

    fun getOneContact(phone : String) = viewModelScope.launch {
        contactUseCases.getOneContact(phone).collect{
            getContactResponse = it
        }
    }

    fun updateContact(contact: Contact) = viewModelScope.launch {
        contactUseCases.updateContact(contact).collect{
            updateResponse = it
        }
    }
 }