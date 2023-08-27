package com.enescanpolat.cryptocurrencyapp.domain.use_cases.get_coins_list_use_case

import com.enescanpolat.cryptocurrencyapp.data.remote.dto.toCoinList
import com.enescanpolat.cryptocurrencyapp.domain.model.CoinList
import com.enescanpolat.cryptocurrencyapp.domain.repository.CoinRepository
import com.enescanpolat.cryptocurrencyapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsListUseCase @Inject constructor(private val repository: CoinRepository) {


    operator fun invoke (): Flow<Resource<List<CoinList>>> = flow {
        try {
            emit(Resource.Loading())
            val coinsList = repository.getCoinList().map { it.toCoinList() }
            emit(Resource.Success(coinsList))

        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"Internet Error"))
        }catch (e:IOException){
            emit(Resource.Error(e.localizedMessage?:"Couldn't reach server.Check your internet"))
        }
    }

}