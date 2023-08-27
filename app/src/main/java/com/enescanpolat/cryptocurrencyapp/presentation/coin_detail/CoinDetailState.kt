package com.enescanpolat.cryptocurrencyapp.presentation.coin_detail

import com.enescanpolat.cryptocurrencyapp.domain.model.CoinDetail
import com.enescanpolat.cryptocurrencyapp.domain.model.CoinList

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coinDetail : CoinDetail? = null,
    val error:String=""
)
