package com.example.easymove

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MudancasDAO {
    val URL: String = "https://webapieasymove.herokuapp.com/"
    private val client = OkHttpClient.Builder().build()

    val mudancasDAO = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun retrofitService(): RetrofitService {
        return mudancasDAO.create(RetrofitService::class.java)
    }
}