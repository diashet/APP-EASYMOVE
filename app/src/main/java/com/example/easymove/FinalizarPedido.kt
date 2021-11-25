package com.example.easymove

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinalizarPedido : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalizar_pedido)

        val txvNomeEmpresa: TextView = findViewById(R.id.txvNomeEmpresa)
        val tipoCaminhao: TextView = findViewById(R.id.txvTipoCaminhao)
        val logradouroText: TextView = findViewById(R.id.txvLogradouro)
        val numeroText: TextView = findViewById(R.id.txvNumero)
        val btnConfirmar: Button =findViewById(R.id.btnConfirmar)

        val extras = intent.extras
        val nmEmpresa = extras?.getString("nomeEmpresa")
        val tpCaminhao = extras?.getString("tipoCaminhao")
        val logradouro = extras?.getString("rua")
        val numero = extras?.getString("numero")

        txvNomeEmpresa.text = nmEmpresa
        tipoCaminhao.text = tpCaminhao
        logradouroText.text = logradouro
        numeroText.text = numero

        fun addMudanca() {

            val mudancaInfo = Mudanca(
                nmEmpresa = nmEmpresa.toString(),
                tpCaminhao = tpCaminhao.toString(),
                logradouro = logradouro.toString(),
                numero = numero.toString()
            )


            Log.v("string","string")
            val call = MudancasDAO().retrofitService().addMudanca(mudancaInfo)
            call.enqueue(
                object : Callback<Mudanca> {
                    override fun onFailure(call: Call<Mudanca>, t: Throwable) {

                    }
                    override fun onResponse( call: Call<Mudanca>, response: Response<Mudanca>) {
                        Log.v("string", "passou por aqui")
                    }
                }
            )
        }

        btnConfirmar.setOnClickListener{
            addMudanca()
        }
    }
}