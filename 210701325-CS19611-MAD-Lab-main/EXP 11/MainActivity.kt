package org.rec.exp11sms

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.SEND_SMS), 101)
        }
        val etPhoneNumber : EditText = findViewById(R.id.etPhoneNumber)
        val etMessage : EditText = findViewById(R.id.etMessage)
        val btSend : Button = findViewById(R.id.btSend)

        btSend.setOnClickListener {
            val phoneNumber = etPhoneNumber.text.toString()
            val message = etMessage.text.toString()
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber,null,message, null, null)

         }

        

    }
}
