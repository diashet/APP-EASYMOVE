package com.example.easymove

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EmpresasDAO {

    val URL: String = "https://webapieasymove.herokuapp.com/"

    val empresasDAO = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)

    suspend fun getEmpresasDAO(): Response<List<Empresas>> = empresasDAO.getEmpresas()
}