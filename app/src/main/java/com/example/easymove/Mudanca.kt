package com.example.easymove

import com.google.gson.annotations.SerializedName

data class Mudanca(
    @SerializedName("nmEmpresa") val nmEmpresa: String,
    @SerializedName("tpCaminhao") val tpCaminhao: String,
    @SerializedName("logradouro") val logradouro: String,
    @SerializedName("numero") val numero: String,

)
