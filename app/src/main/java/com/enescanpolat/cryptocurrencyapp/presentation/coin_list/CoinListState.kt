package com.enescanpolat.cryptocurrencyapp.presentation.coin_list

import com.enescanpolat.cryptocurrencyapp.domain.model.CoinList

data class CoinListState(
    val isLoading:Boolean=false,
    val coinsList : List<CoinList> = emptyList(),
    val error:String=""

)
