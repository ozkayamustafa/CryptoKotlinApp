package com.mustafa.cryptokotlinapp.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.cryptokotlinapp.model.CryptoModel
import com.mustafa.cryptokotlinapp.repository.CryptoRepoSitory
import com.mustafa.cryptokotlinapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel
@Inject
constructor(private  val repository: CryptoRepoSitory,application: Application):BaseViewModel(application)
{

    var cryptoList = mutableStateOf<List<CryptoModel>>(listOf())
    var error = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    private  var initialCrypto = listOf<CryptoModel>()
    private  var isSearchStarting = true



    init {
        getDataList()
    }


    fun searchCryptoList(query:String){
         val listToSearch = if (isSearchStarting){
              cryptoList.value
         }else{
             initialCrypto
         }

        launch (Dispatchers.Default){
            if (query.isEmpty()){
                cryptoList.value = initialCrypto
                isSearchStarting = true
                return@launch
            }

            val results = listToSearch.filter {
                it.currency.contains(query.trim(),ignoreCase = true)
            }

            if (isSearchStarting){
                initialCrypto = cryptoList.value
                isSearchStarting = false
            }

            cryptoList.value = results

        }

    }


    fun getDataList(){

            viewModelScope.launch {
                isLoading.value = true
            val result = repository.getCryptoList()
            when(result){
                is Resource.Success ->{
                    println("success girdi")
                        var cryptoItems = result.data!!.mapIndexed { index, cryptoModel ->
                            CryptoModel(cryptoModel.currency ?: "",cryptoModel.price ?: "")
                        }
                    error.value = ""
                    isLoading.value = false
                    cryptoList.value += cryptoItems
                }
                is Resource.Error ->{
                    println("error girdi")
                            error.value = result.message!!
                            isLoading.value = false
                }

            }



        }

    }

}