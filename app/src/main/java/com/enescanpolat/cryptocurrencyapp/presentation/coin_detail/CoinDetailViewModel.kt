package com.enescanpolat.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.cryptocurrencyapp.domain.use_cases.get_coin_detail_use_case.GetCoinDetailUseCase
import com.enescanpolat.cryptocurrencyapp.presentation.coin_list.CoinListState
import com.enescanpolat.cryptocurrencyapp.util.Constants.PARAM_COIN_ID
import com.enescanpolat.cryptocurrencyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle

    ) :ViewModel(){


    private val _state = mutableStateOf(CoinDetailState())
    val state : State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let {coinId->
            getCoinDetail(coinId)
        }
    }

    private fun getCoinDetail(coinId:String){
        getCoinDetailUseCase(coinId).onEach {result->
            when(result){

                is Resource.Success->{
                    _state.value= CoinDetailState(coinDetail = result.data)
                }

                is Resource.Error->{
                    _state.value= CoinDetailState(error = result.message?:"An unexcepted error occurded")

                }
                is Resource.Loading->{
                    _state.value = CoinDetailState(true)

                }

            }
        }.launchIn(viewModelScope)
    }



}