package com.enescanpolat.cryptocurrencyapp.data.dependency_injection

import com.enescanpolat.cryptocurrencyapp.data.remote.CoinApi
import com.enescanpolat.cryptocurrencyapp.data.repository.CoinRepoistoryImpl
import com.enescanpolat.cryptocurrencyapp.domain.repository.CoinRepository
import com.enescanpolat.cryptocurrencyapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectCoinApi():CoinApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)

    }


    @Singleton
    @Provides
    fun injectCoinRepository(api:CoinApi):CoinRepository{
        return CoinRepoistoryImpl(api)
    }

}