package com.example.test_app

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi

class BLEActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bleactivity)

        val mBluetoothManager: BluetoothManager = getSystemService(BluetoothManager::class.java)
        val mBluetoothAdapter: BluetoothAdapter? = mBluetoothManager?.adapter
        val REQUEST_ENABLE_BT = 1

        if(mBluetoothAdapter != null && !mBluetoothAdapter.isEnabled){
            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent,REQUEST_ENABLE_BT)
        }
    }
}