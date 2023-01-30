package com.example.telephone.Data.services

import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.telecom.*
import android.telecom.Connection
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class CallServices : ConnectionService() {

    override fun onCreateOutgoingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        return super.onCreateOutgoingConnection(connectionManagerPhoneAccount, request)
    }

    override fun onCreateIncomingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection? {
        return super.onCreateIncomingConnection(connectionManagerPhoneAccount, request)
    }
}

class ConnectionCall : Connection(){
    override fun onShowIncomingCallUi() {
        super.onShowIncomingCallUi()
    }
}