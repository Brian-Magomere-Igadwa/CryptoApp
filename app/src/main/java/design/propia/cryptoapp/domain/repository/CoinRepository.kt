package design.propia.cryptoapp.domain.repository

import design.propia.cryptoapp.data.remote.dto.CoinDetailDto
import design.propia.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailDto
}