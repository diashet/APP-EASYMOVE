package com.example.easymove

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    val btnAbrirProximaActivity = findViewById<Button>(R.id.btn_enter)
    btnAbrirProximaActivity.setOnClickListener {
        val i = Intent(this, InicioActivity::class.java)
        startActivity(i)
    }
    }

}