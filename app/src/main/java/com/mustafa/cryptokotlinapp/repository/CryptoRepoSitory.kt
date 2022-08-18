package com.mustafa.cryptokotlinapp.repository

import com.mustafa.cryptokotlinapp.model.CryptoModel
import com.mustafa.cryptokotlinapp.service.CryptoAPI
import com.mustafa.cryptokotlinapp.util.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityRetainedScoped
class CryptoRepoSitory
  @Inject
  constructor( val api:CryptoAPI)
{

      suspend fun getCryptoList():Resource<List<CryptoModel>>{
          val response = try {
              api.getCrypto()
          }catch (e:Exception){
              return  Resource.Error("Error")
          }
          return  Resource.Success(response)
      }

}