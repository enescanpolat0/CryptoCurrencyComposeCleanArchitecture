package com.enescanpolat.cryptocurrencyapp.data.remote.dto

import com.enescanpolat.cryptocurrencyapp.domain.model.CoinList

data class CoinListDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinListDto.toCoinList():CoinList{
    return CoinList(id, is_active, name, rank, symbol)
}