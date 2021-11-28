package com.example.easymove

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VisualizarPedidoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_pedido)
    pedido()

    }

    fun pedido() {
        val txvNomeEmpresa: TextView = findViewById(R.id.txvNomeEmpresa)
        val tipoCaminhao: TextView = findViewById(R.id.txvTipoCaminhao)
        val logradouroText: TextView = findViewById(R.id.txvLogradouro)
        val numeroText: TextView = findViewById(R.id.txvNumero)
        Log.v("string","string")
        val call = MudancasDAO().retrofitService().getPedido()
        call.enqueue(
            object : Callback<List<Mudanca>> {
                override fun onFailure(call: Call<List<Mudanca>>, t: Throwable) {
                    Log.v("string", "passou por aqui")
                }
                override fun onResponse(call: Call<List<Mudanca>>, response: Response<List<Mudanca>>) {
                    Log.v("string", "passou por aqui")
                    response.body()?.let {
                        val last = it.size
                        var i = 0
                            it.forEach {
                                i += 1
                                if(i == last ){
                                    txvNomeEmpresa.text = it.nmEmpresa
                                    tipoCaminhao.text = it.tpCaminhao
                                    logradouroText.text = it.logradouro
                                    numeroText.text = it.numero
                                }
                            }

                        }
                    }

                })
            }
    }