package com.mustafa.cryptokotlinapp.service

import com.mustafa.cryptokotlinapp.util.Contants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoService {

    companion object{
        @Volatile private  var retrofit:Retrofit? = null
        private val lock = Any()
        operator fun invoke() = retrofit ?: synchronized(lock){
            retrofit ?: makeRetrofit().also {
                retrofit = it
            }
        }
        fun makeRetrofit(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(Contants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}