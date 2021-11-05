package com.example.test_app

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi

class BluetoothActivity : AppCompatActivity() {

    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var text_ll : LinearLayout


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)


        val mBluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        mBluetoothAdapter = mBluetoothManager?.adapter
        val REQUEST_ENABLE_BT = 1
        text_ll = findViewById<LinearLayout>(R.id.BluetoothDevices)

        if(mBluetoothAdapter != null && mBluetoothAdapter.isEnabled){
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent,REQUEST_ENABLE_BT)

        }

    }


    fun addBluetooth(){
        val pairedDevices = mBluetoothAdapter?.bondedDevices
        if (pairedDevices != null) {
            if(pairedDevices.size > 0){
                for(currentDevice in pairedDevices){
                    val textView = TextView(this)
                    textView.text = currentDevice.name.toString() + " :" + currentDevice.bondState
                    textView.textSize = 20f
                    text_ll.addView(textView)
                }
            }
        }
    }
}