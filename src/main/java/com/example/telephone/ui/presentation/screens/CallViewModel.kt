package com.example.telephone.ui.presentation.screens

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModel

class CallViewModel : ViewModel() {
    fun call(phone : String) : Intent = Intent(Intent.ACTION_CALL, Uri.parse("tel :$phone"))
}