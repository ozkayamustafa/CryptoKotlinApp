package com.mustafa.cryptokotlinapp.service

import com.mustafa.cryptokotlinapp.model.CryptoModel
import com.mustafa.cryptokotlinapp.util.Contants
import com.mustafa.cryptokotlinapp.util.Contants.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface CryptoAPI {

    @GET("IA32-CryptoComposeData/main/cryptolist.json")
    suspend fun getCrypto():List<CryptoModel>

}