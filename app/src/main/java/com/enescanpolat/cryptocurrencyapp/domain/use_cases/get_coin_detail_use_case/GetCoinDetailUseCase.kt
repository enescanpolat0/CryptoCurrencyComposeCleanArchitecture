package com.enescanpolat.cryptocurrencyapp.domain.use_cases.get_coin_detail_use_case

import com.enescanpolat.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.enescanpolat.cryptocurrencyapp.data.remote.dto.toCoinList
import com.enescanpolat.cryptocurrencyapp.domain.model.CoinDetail
import com.enescanpolat.cryptocurrencyapp.domain.model.CoinList
import com.enescanpolat.cryptocurrencyapp.domain.repository.CoinRepository
import com.enescanpolat.cryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository : CoinRepository){

    operator fun invoke (coinId:String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = repository.getCoinDetail(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))

        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?:"Internet Error"))
        }catch (e: IOException){
            emit(Resource.Error(e.localizedMessage?:"Couldn't reach server.Check your internet"))
        }
    }



}