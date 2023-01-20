package design.propia.cryptoapp.data.repository

import design.propia.cryptoapp.data.remote.CoinPaprikaApi
import design.propia.cryptoapp.data.remote.dto.CoinDetailDto
import design.propia.cryptoapp.data.remote.dto.CoinDto
import design.propia.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi

):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}