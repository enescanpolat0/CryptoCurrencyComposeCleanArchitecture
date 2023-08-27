package com.enescanpolat.cryptocurrencyapp.data.remote

import com.enescanpolat.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.enescanpolat.cryptocurrencyapp.data.remote.dto.CoinListDto
import com.enescanpolat.cryptocurrencyapp.domain.model.CoinList
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoinList() : List<CoinListDto>


    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId:String):CoinDetailDto

}