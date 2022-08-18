package com.mustafa.cryptokotlinapp.DI

import com.mustafa.cryptokotlinapp.repository.CryptoRepoSitory
import com.mustafa.cryptokotlinapp.service.CryptoAPI
import com.mustafa.cryptokotlinapp.service.CryptoService
import com.mustafa.cryptokotlinapp.util.Contants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providerCryptoApi():CryptoAPI{
        return CryptoService.invoke().create(CryptoAPI::class.java)

        /* Retrofit.Builder()
                   .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
                  .build()
          .create(CryptoAPI::class.java)
          */
    }

    @Singleton
    @Provides
    fun providersRepository(
        api: CryptoAPI
    )= CryptoRepoSitory(api)



}