package com.example.easymove

import com.google.gson.annotations.SerializedName

data class Empresas(
    @SerializedName("idEmpresa")          val idEmpresa: String,
    @SerializedName("nomeEmpresa")   val nomeEmpresa: String,
    @SerializedName("cnpj")   val cnpj: String,
    @SerializedName("avaliacao")   val avalicao: String,
    @SerializedName("imagem")   val imagem: String

)

