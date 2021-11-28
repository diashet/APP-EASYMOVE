package com.example.easymove

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnderecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_endereco)

        val pesquisaCEP: Button = findViewById(R.id.pesquisaCEP)
        val cep: EditText = findViewById(R.id.cep)
        val txvCEP: TextView = findViewById(R.id.txvCEP)
        val uf: TextView = findViewById(R.id.txvUF)
        val bairro: TextView = findViewById(R.id.txvBairro)
        val logradouro: TextView = findViewById((R.id.txvLogradouro))
        val btnPronto: Button = findViewById(R.id.btnPronto)
        val nr: EditText = findViewById(R.id.numero)

        val extras = intent.extras
        val nmEmpresa = extras?.getString("nomeEmpresa")
        val tpCaminhao = extras?.getString("tipoCaminhao")

        pesquisaCEP.setOnClickListener {


            val call = RetrofitFactory().retrofitService().getCEP(cep.text.toString())

            call.enqueue(object : Callback<CEP> {

                override fun onResponse(call: Call<CEP>, response: Response<CEP>) {

                    response.body()?.let {
                        Log.i("CEP", it.toString())
                        Toast.makeText(this@EnderecoActivity, it.toString(), Toast.LENGTH_LONG).show()
                        logradouro.text = it.logradouro
                        uf.text = it.uf
                        txvCEP.text = it.cep
                        bairro.text = it.bairro
                    } ?: Toast.makeText(this@EnderecoActivity, "CEP não localizado", Toast.LENGTH_LONG)
                        .show()

                }

                override fun onFailure(call: Call<CEP>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                }
            })
        }

        btnPronto.setOnClickListener() {
            val i = Intent(this, FinalizarPedido::class.java)
            i.putExtra("tipoCaminhao", tpCaminhao)
            i.putExtra("nomeEmpresa", nmEmpresa)
            i.putExtra("rua", logradouro.text.toString())
            i.putExtra("numero", nr.text.toString())
            startActivity(i)
        }
    }
}