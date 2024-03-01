package com.example.chang_go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeKotilin = findViewById<ImageView>(R.id.kotlin)
        val changeKotlintext = findViewById<TextView>(R.id.text_kotlin)

        changeKotilin.setOnClickListener{
            val intent = Intent(this, KotlinActivity::class.java)
            startActivity(intent)
        }

        changeKotlintext.setOnClickListener{
            val intent = Intent(this, KotlinActivity::class.java)
            startActivity(intent)
        }
    }
}