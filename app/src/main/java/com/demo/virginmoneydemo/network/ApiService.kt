package com.demo.virginmoneydemo.network

import com.demo.virginmoneydemo.models.People
import com.demo.virginmoneydemo.models.Room
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("people")
    suspend fun fetchPeoples(): Response<ArrayList<People>>

    @GET("rooms")
    suspend fun fetchRooms(): Response<ArrayList<Room>>

    companion object {
        private const val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io/api/v1/"

        fun create(): ApiService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BODY }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}
