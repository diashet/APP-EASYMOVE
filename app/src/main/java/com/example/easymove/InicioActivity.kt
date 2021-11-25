package com.example.easymove

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easymove.adapter.EmpresasAdapter

class InicioActivity : AppCompatActivity(), EmpresasAdapter.OnItemClickListener {
    lateinit var viewModel: MainViewModel
    val empresasAdapter = EmpresasAdapter(arrayListOf(),this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        var recyclerviewEmpresas = findViewById(R.id.recyclerviewEmpresas) as RecyclerView
        viewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)
        recyclerviewEmpresas.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = empresasAdapter
        }
        viewModel.fetchEmpresas()

        viewModel.items.observe(this, androidx.lifecycle.Observer { empresas ->
            empresas?.let() {
                empresasAdapter.update(it)
            }
        })
    }
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "item clicado", Toast.LENGTH_SHORT).show()
        val clickedItem = empresasAdapter.listaEmpresa[position]
    }
}