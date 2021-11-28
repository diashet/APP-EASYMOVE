package com.example.easymove

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
                object : Callback<Void> {
                    override fun onFailure(call: Call<Void>, t: Throwable) {
                        Log.v("string", "passou por aqui")
                    }
                    override fun onResponse( call: Call<Void>, response: Response<Void>) {
                        Log.v("string", "passou por aqui")
                        Toast.makeText(this@FinalizarPedido, "Pedido Recebido Com Sucesso", Toast.LENGTH_LONG)
                            .show()

                        val i = Intent(this@FinalizarPedido, VisualizarPedidoActivity::class.java)
                        startActivity(i)
                    }
                }
            )
        }

        btnConfirmar.setOnClickListener{
            addMudanca()
        }
    }
}