package com.example.javatokotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewHelloKotlin = findViewById<TextView>(R.id.text_view_hello_kotlin)
        val buttonSayHelloKotlin = findViewById<Button>(R.id.button_say_hello_kotlin)

        buttonSayHelloKotlin.setOnClickListener {
            textViewHelloKotlin.text = "Hello Kotlin!"
        }
    }
}