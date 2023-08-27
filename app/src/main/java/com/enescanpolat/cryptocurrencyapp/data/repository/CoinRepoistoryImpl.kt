package com.enescanpolat.cryptocurrencyapp.data.repository

import com.enescanpolat.cryptocurrencyapp.data.remote.CoinApi
import com.enescanpolat.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.enescanpolat.cryptocurrencyapp.data.remote.dto.CoinListDto
import com.enescanpolat.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepoistoryImpl @Inject constructor(private val api : CoinApi) :CoinRepository {
    override suspend fun getCoinList(): List<CoinListDto> {
        return api.getCoinList()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto {
        return api.getCoinDetail(coinId)
    }
}