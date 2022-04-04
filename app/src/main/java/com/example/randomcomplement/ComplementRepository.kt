package com.example.randomcomplement

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ComplementRepository {

    // Could of made the base URL include Random but figured this would allow for added features
    // in the future.
    private val baseURL = "https://random-compliment.herokuapp.com/"

    // Do not need to use the HTTP client since we do not need to pass a authorization
//    private val client: OkHttpClient = OkHttpClient.Builder().build()

    // Builds the Http request for us.
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val complementService = retrofit.create(ComplementService::class.java)

    // Future work would include adding error handling.
    suspend fun getComplement(): Complement {
        val response = complementService.getComplement()
        if (response.isSuccessful) {
            val randomComplement = response.body()!!
            return randomComplement
        } else {
            return Complement("Error - Might be issue with Server")
        }
    }
}