package com.example.easymove.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easymove.Empresas
import com.example.easymove.EscolhaActivity
import com.example.easymove.R

class EmpresasAdapter(var listaEmpresa: ArrayList<Empresas>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<EmpresasAdapter.EmpresaViewHolder>() {

    inner class EmpresaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var txtNomeEmpresas = itemView.findViewById(R.id.txv_NomeEmpresa) as TextView
        var notaEmpresa = itemView.findViewById(R.id.notaEmpresa) as RatingBar
        init{
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
            var i = Intent(v?.context, EscolhaActivity::class.java)
            val empresa = listaEmpresa[position]
            i.putExtra("nomeEmpresa", empresa.nomeEmpresa)
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            v?.context?.startActivity(i)
        }
    }
    interface  OnItemClickListener {
        fun onItemClick(position: Int)
    }

    var mOnItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpresaViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_empresas, parent, false);
        return EmpresaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmpresaViewHolder, position: Int) {
        val empresa = listaEmpresa[position]
        holder.txtNomeEmpresas.text = empresa.nomeEmpresa
        holder.notaEmpresa.rating = empresa.avalicao.toFloat()
    }

    override fun getItemCount(): Int = listaEmpresa.size

    fun update(empresas: List<Empresas>) {
        listaEmpresa.clear()
        listaEmpresa.addAll(empresas)
        notifyDataSetChanged()
    }

}