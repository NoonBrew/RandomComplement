package com.example.randomcomplement

import retrofit2.Response
import retrofit2.http.GET

interface ComplementService {
    // We only need to get the complement, and do not need to store them
    @GET("random")
    suspend fun getComplement(): Response<Complement>
}