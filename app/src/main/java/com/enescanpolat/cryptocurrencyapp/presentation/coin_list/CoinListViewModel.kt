package com.enescanpolat.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.cryptocurrencyapp.domain.use_cases.get_coins_list_use_case.GetCoinsListUseCase
import com.enescanpolat.cryptocurrencyapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinListUseCase : GetCoinsListUseCase):ViewModel() {


    private val _state = mutableStateOf(CoinListState())
    val state :  State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinListUseCase().onEach {result->
            when(result){

                is Resource.Success->{
                    _state.value= CoinListState(coinsList = result.data?: emptyList())
                }

                is Resource.Error->{
                    _state.value= CoinListState(error = result.message?:"An unexcepted error occurded")

                }
                is Resource.Loading->{
                    _state.value = CoinListState(true)

                }

            }
        }.launchIn(viewModelScope)
    }

}