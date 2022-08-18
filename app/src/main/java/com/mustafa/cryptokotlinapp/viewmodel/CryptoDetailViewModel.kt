package com.mustafa.cryptokotlinapp.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import com.mustafa.cryptokotlinapp.model.CryptoModel
import com.mustafa.cryptokotlinapp.repository.CryptoRepoSitory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel
  @Inject
  constructor(private  val repoSitory: CryptoRepoSitory, application: Application):
    BaseViewModel(application)
{

      var cryptoDetailCurrency = mutableStateOf<String>("")
      var cryptoDetailPrice = mutableStateOf<String>("")

      fun getDetailsData(currecy:String,prices:String){
            cryptoDetailCurrency.value = currecy
            cryptoDetailPrice.value = prices
      }


}