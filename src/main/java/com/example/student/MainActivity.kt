package com.example.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var className : Button ?= null
    private var Student : Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        className = findViewById(R.id.classname)

        className?.setOnClickListener{
            startActivity(Intent(this,ClassNameActivity :: class.java))
        }
    }
}
