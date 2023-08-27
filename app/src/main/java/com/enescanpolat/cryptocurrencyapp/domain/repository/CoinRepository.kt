package com.enescanpolat.cryptocurrencyapp.domain.repository

import com.enescanpolat.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.enescanpolat.cryptocurrencyapp.data.remote.dto.CoinListDto
import com.enescanpolat.cryptocurrencyapp.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoinList():List<CoinListDto>

    suspend fun getCoinDetail(coinId:String):CoinDetailDto

}