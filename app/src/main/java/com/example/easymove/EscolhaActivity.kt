package com.example.easymove

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


class EscolhaActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolha)

        val btnAbrirProxActivity = findViewById<Button>(R.id.btnPronto)

        val extras = intent.extras
        val nmEmpresa = extras?.getString("nomeEmpresa")

        btnAbrirProxActivity.setOnClickListener() {

            var radioGroup = findViewById<RadioGroup>(R.id.RGroup)
            var idRadio = radioGroup.checkedRadioButtonId
            var radioButton = radioGroup.findViewById<RadioButton>(idRadio)?.text.toString()

            val i = Intent(this, EnderecoActivity::class.java)
            i.putExtra("tipoCaminhao", radioButton)
            i.putExtra("nomeEmpresa", nmEmpresa)
            startActivity(i)
        }
    }
}