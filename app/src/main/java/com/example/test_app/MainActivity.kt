package com.example.test_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE ="com.example.TEST_APP.MESSAGE"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var intentBtn : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.BtButton).setOnClickListener(this)
        findViewById<Button>(R.id.BleButton).setOnClickListener(this)
    }

    override fun onClick(view:View) {
        val btn = view as Button
        Log.i("btn",btn.text.toString())

        when(btn.text.toString()){
            "BluetoothTest" ->{intentBtn = Intent(this,BluetoothActivity::class.java) }
            "BLETest" -> {intentBtn = Intent(this,BLEActivity::class.java)}
        }
        startActivity(intentBtn)

    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        // fidViewByID< ... >(R.id."ID") ... 取得したい形式を＜＞に記入，ほしいIDを（R.id．ID)で記入
        val editText = findViewById<EditText>(R.id.editMessage)

        // 上で取得した文字をString列で取得
        val message = editText.text.toString()

        // Intent = 他機能や画面との橋渡し Intent(this, AnotherActivity::class.java)
        val intent = Intent(this,DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message) //第１引数：key,第２引数：渡したい値
        }
        startActivity(intent) //画面遷移開始
    }
}

