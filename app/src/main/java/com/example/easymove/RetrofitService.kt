package com.example.easymove

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface RetrofitService {

    //https://viacep.com.br/ws/01538001/json/
    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") CEP : String) : Call<CEP>

    //https://webapieasymove.herokuapp.com/
    @GET("api/Empresas")
    suspend fun getEmpresas() : Response<List<Empresas>>

    //https://webapieasymove.herokuapp.com/
    @GET("api/Mudanca")
    fun getPedido() : Call<List<Mudanca>>

    //https://viacep.com.br/ws/SP/Sao%20Paulo/Avenida%20Lins%20de%20Vasconcelos/json/
    @GET("{estado}/{cidade}/{endereco}/json/")
    fun getRCE(@Path("estado") estado: String,
               @Path("cidade") cidade: String,
               @Path("endereco") endereco: String): Call<List<CEP>>

    @Headers("Accept:application/json","Content-Type:application/json")
    @POST("api/Mudanca")
    fun addMudanca(@Body userData: Mudanca): Call<Void>
}